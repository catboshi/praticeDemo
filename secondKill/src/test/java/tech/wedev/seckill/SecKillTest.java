package tech.wedev.seckill;

import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.JedisPool;
import tech.wedev.pratice.seckill.CacheLockInterceptor;
import tech.wedev.pratice.seckill.RedisClient;

import java.lang.reflect.Proxy;
import java.util.concurrent.CountDownLatch;

public class SecKillTest {
	private static Long commodityId1 = 10000001L;
	private static Long commodityId2 = 10000002L;
	private RedisClient client;
	private JedisPool jedisPool;
	@Before
	public synchronized void  beforeTest() {
		jedisPool = new JedisPool("127.0.0.1");
	}
	
	@Test
	public void testSecKill(){
		int threadCount = 1000;
		int splitPoint = 500;
		final CountDownLatch endCount = new CountDownLatch(threadCount);
		final CountDownLatch beginCount = new CountDownLatch(1);
		final SecKillImpl testClass = new SecKillImpl();
		
		Thread[] threads = new Thread[threadCount];
		//起500个线程，秒杀第一个商品
		for(int i= 0;i < splitPoint;i++){
			threads[i] = new Thread(() -> {
				try {
					//等待在一个信号量上，挂起
					beginCount.await();
					//用动态代理的方式调用secKill方法
					SeckillInterface proxy = (SeckillInterface) Proxy.newProxyInstance(SeckillInterface.class.getClassLoader(),
							new Class[]{SeckillInterface.class}, new CacheLockInterceptor(testClass));
					proxy.secKill("test", commodityId1);
					endCount.countDown();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
			threads[i].start();

		}
		
		for(int i= splitPoint;i < threadCount;i++){
			threads[i] = new Thread(() -> {
				try {
					//等待在一个信号量上，挂起
					beginCount.await();
					//用动态代理的方式调用secKill方法
					beginCount.await();
					SeckillInterface proxy = (SeckillInterface) Proxy.newProxyInstance(SeckillInterface.class.getClassLoader(),
						new Class[]{SeckillInterface.class}, new CacheLockInterceptor(testClass));
					proxy.secKill("test", commodityId2);
					//testClass.testFunc("test", 10000001L);
					endCount.countDown();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
			threads[i].start();
		}
		
		
		long startTime = System.currentTimeMillis();
		//主线程释放开始信号量，并等待结束信号量
		beginCount.countDown();
		
		try {
			//主线程等待结束信号量
			endCount.await();
			//观察秒杀结果是否正确
			System.out.println(SecKillImpl.inventory.get(commodityId1));
			System.out.println(SecKillImpl.inventory.get(commodityId2));
			System.out.println("error count" + CacheLockInterceptor.ERROR_COUNT);
			System.out.println("total cost " + (System.currentTimeMillis() - startTime));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

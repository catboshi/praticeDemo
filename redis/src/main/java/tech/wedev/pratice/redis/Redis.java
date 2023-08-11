package tech.wedev.pratice.redis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class Redis {
    private JedisPool pool;

    public Redis() {
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        //连接池最大空闲数
        config.setMaxIdle(300);
        //最大连接数
        config.setMaxTotal(1000);
        //连接最大等待时间，如果是 -1 表示没有限制
        config.setMaxWaitMillis(30000);
        //在空闲时检查有效性
        config.setTestOnBorrow(true);
        pool = new JedisPool(config, "43.142.158.6", 6379, 3000, "P@assword123!");
    }

    public void execute(CallWithJedis callWithJedis) {
        try (Jedis jedis = pool.getResource()) {
            callWithJedis.apply(jedis);
        }
    }
}

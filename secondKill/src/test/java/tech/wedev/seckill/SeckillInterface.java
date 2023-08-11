package tech.wedev.seckill;


import tech.wedev.pratice.seckill.CacheLock;
import tech.wedev.pratice.seckill.LockedObject;

public interface SeckillInterface {
	@CacheLock(lockedPrefix="TEST_PREFIX")
	public void secKill(String arg1,@LockedObject Long arg2);
}

package tech.wedev.pratice.redis;

import redis.clients.jedis.Jedis;

@FunctionalInterface
public interface CallWithJedis {
    void apply(Jedis jedis);
}

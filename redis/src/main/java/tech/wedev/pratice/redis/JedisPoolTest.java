package tech.wedev.pratice.redis;

public class JedisPoolTest {
    public static void main(String[] args) {
        Redis redis = new Redis();
        redis.execute(jedis -> System.out.println(jedis.ping()));
    }
}

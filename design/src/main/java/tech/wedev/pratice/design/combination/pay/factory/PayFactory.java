package tech.wedev.pratice.design.combination.pay.factory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tech.wedev.pratice.design.combination.pay.context.PayContext;
import tech.wedev.pratice.design.combination.pay.strategy.PayStrategy;

/**
 * @Description 享元模式解决高并发下频繁创建对象的问题
 */
public class PayFactory {

    public final static Map<PayStrategy, PayContext> maps = new ConcurrentHashMap<>();

    public static PayContext getPayContext(PayStrategy payStrategy) {
        if (maps.get(payStrategy) == null) {
            PayContext payContext = new PayContext(payStrategy);
            maps.put(payStrategy, payContext);
        }
        return maps.get(payStrategy);
    }

}

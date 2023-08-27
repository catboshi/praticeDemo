package tech.wedev.pratice.design.combination.pay.factory;

import tech.wedev.pratice.design.combination.pay.strategy.PayStrategy;
import tech.wedev.pratice.design.combination.pay.strategyEnum.StrategyEnum;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description: 策略工厂 工厂类依靠策略枚举返回策略类 后面都不需要修改了，因为它是一个无状态的 使用饿汉单例模式创建
 */

public class StrategyFactory {

    private static final Map<String, PayStrategy> strategyMaps = new ConcurrentHashMap();

    public static PayStrategy getPayStrategy(StrategyEnum strategyEnum){
        PayStrategy payStrategy = strategyMaps.get(strategyEnum.getValue());
        try {
            payStrategy = (PayStrategy) Class.forName(strategyEnum.getValue()).newInstance();
            strategyMaps.put(strategyEnum.getValue(), payStrategy);
        } catch (Exception e) {
            //异常信息打印
        }
        return payStrategy;
    }

}

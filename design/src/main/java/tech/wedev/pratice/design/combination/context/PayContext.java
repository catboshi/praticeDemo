package tech.wedev.pratice.design.combination.context;

import tech.wedev.pratice.design.combination.pay.pojo.PayBody;
import tech.wedev.pratice.design.combination.pay.strategy.PayStrategy;

/**
 * @Description: 起到承上启下的作用
 */

public class PayContext {

    private PayStrategy payStrategy;

    public PayContext(PayStrategy payStrategy){
        this.payStrategy = payStrategy;
    }

    public Boolean execute(PayBody payBody){
        return this.payStrategy.pay(payBody);
    }

}

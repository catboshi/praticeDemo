package tech.wedev.pratice.design.combination.pay.context;

import tech.wedev.pratice.design.combination.pay.pojo.PayBody;
import tech.wedev.pratice.design.combination.pay.strategy.PayStrategy;

/**
 * @Description:动态地给一个对象添加一些额外的职责. 就得在根儿上添加。PayContext 就是我们的被装饰者，因为我们想给payContext添加额外功能：平台币更新和红包.所以我们选择使用装饰者模式。被装饰者必须要有 接口或者抽象类。
 */
public class PayContext extends AbstractPayContext{
    private PayStrategy payStrategy;

    public PayContext(PayStrategy payStrategy) {
        this.payStrategy = payStrategy;
    }

    @Override
    public Boolean execute(PayBody payBody) {
        return this.payStrategy.pay(payBody);
    }
}

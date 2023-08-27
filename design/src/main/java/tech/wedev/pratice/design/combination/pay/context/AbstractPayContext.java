package tech.wedev.pratice.design.combination.pay.context;

import tech.wedev.pratice.design.combination.pay.pojo.PayBody;

public abstract class AbstractPayContext {
    public abstract Boolean execute(PayBody payBody);
}

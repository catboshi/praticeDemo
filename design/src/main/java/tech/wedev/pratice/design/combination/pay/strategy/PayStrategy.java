package tech.wedev.pratice.design.combination.pay.strategy;

import tech.wedev.pratice.design.combination.pay.pojo.PayBody;

/**
 * @Author: zhiwei Liao
 * @Date: 2022/9/25 10:23
 * @Description: 引入策略模式
 */

public interface PayStrategy {

    //未来顶PayHandler里面的三个
    Boolean pay(PayBody payBody);

}

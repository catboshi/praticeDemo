package tech.wedev.pratice.design.combination.inter;


import tech.wedev.pratice.design.combination.pay.pojo.PayBody;

/**
 * @Description: 引入策略模式
 */
public interface PayStrategy {

    //未来顶PayHandler里面的三个
    Boolean pay(PayBody payBody);

}

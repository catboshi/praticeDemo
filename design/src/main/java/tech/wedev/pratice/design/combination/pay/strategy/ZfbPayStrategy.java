package tech.wedev.pratice.design.combination.pay.strategy;


import tech.wedev.pratice.design.combination.pay.pojo.PayBody;

/**
 * @Description: 替换掉PayHandler.zfbpay
 */

public class ZfbPayStrategy implements PayStrategy {
    @Override
    public Boolean pay(PayBody payBody) {
        //支付细节省略
        return true;
    }
}

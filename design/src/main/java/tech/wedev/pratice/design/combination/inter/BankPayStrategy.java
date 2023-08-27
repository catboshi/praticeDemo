package tech.wedev.pratice.design.combination.inter;


import tech.wedev.pratice.design.combination.pay.pojo.PayBody;

/**
 * @Description: 替换掉PayHandler.bankpay
 */

public class BankPayStrategy implements PayStrategy{
    @Override
    public Boolean pay(PayBody payBody) {
        //支付细节省略
        return true;
    }
}

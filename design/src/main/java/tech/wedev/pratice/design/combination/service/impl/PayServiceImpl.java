package tech.wedev.pratice.design.combination.service.impl;

import org.springframework.stereotype.Service;
import tech.wedev.pratice.design.combination.pay.facade.StrategyFacade;
import tech.wedev.pratice.design.combination.pay.pojo.PayBody;
import tech.wedev.pratice.design.combination.service.PayService;

@Service
public class PayServiceImpl implements PayService {


    @Override
    public Boolean pay(PayBody payBody) {
/*        //传统模式开发支付逻辑
        boolean flag = false;
        int type = payBody.getType();
        if (type == 0) {
            //支付宝支付逻辑
            flag = PayHandler.zfbpay(payBody);
        }else if(type == 1){
            //微信支付逻辑
            flag = PayHandler.wxpay(payBody);
        }else if(type == 2){
            //银行卡支付逻辑
            flag = PayHandler.bankbpay(payBody);
        }else {
            throw new UnsupportedOperationException("unsupport type,please choose o,1,2 ");
        }

        if (flag) {
            //支付成功走后续逻辑
        }
        return flag;*/

/*        //引入策略模式开发支付逻辑
        boolean flag = false;
        int type = payBody.getType();
        if (type == 0) {
            //支付宝支付逻辑
            flag = new PayContext(new ZfbPayStrategy()).execute(payBody);
        }else if(type == 1){
            //微信支付逻辑
            flag = new PayContext(new WxPayStrategy()).execute(payBody);
        }else if(type == 2){
            //银行卡支付逻辑
            flag = new PayContext(new BankPayStrategy()).execute(payBody);
        }else {
            throw new UnsupportedOperationException("unsupport type,please choose o,1,2 ");
        }

        if (flag) {
            //支付成功走后续逻辑
        }
        return flag;*/

/*        //引入工厂模式开发支付逻辑
        boolean flag = false;
        int type = payBody.getType();
        if (type == 0) {
            //支付宝支付逻辑
            flag = new PayContext(StrategyFactory.getPayStrategy(StrategyEnum.ZfbPayStrategy)).execute(payBody);
        }else if(type == 1){
            //微信支付逻辑
            flag = new PayContext(StrategyFactory.getPayStrategy(StrategyEnum.WxPayStrategy)).execute(payBody);
        }else if(type == 2){
            //银行卡支付逻辑
            flag = new PayContext(StrategyFactory.getPayStrategy(StrategyEnum.BankPayStrategy)).execute(payBody);
        }else {
            throw new UnsupportedOperationException("unsupport type,please choose o,1,2 ");
        }

        if (flag) {
            //支付成功走后续逻辑
        }
        return flag;*/

        //引入门面模式开发支付逻辑
        Boolean flag = StrategyFacade.pay(payBody);
        if (flag) {
            //支付成功走后续逻辑
        }
        return flag;
    }
}

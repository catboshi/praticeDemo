package tech.wedev.pratice.design.combination.handler;

import org.springframework.stereotype.Component;
import tech.wedev.pratice.design.combination.pojo.PayBody;

/**
 * @Author: zhiwei Liao
 * @Date: 2022/9/25 9:42
 * @Description:
 */
@Component
public class PayHandler {


    public static boolean zfbpay(PayBody payBody) {
        //详细调用支付宝提供的第三方接口
        //........................
        return true;
    }

    public static boolean wxpay(PayBody payBody) {
        //详细调用支付宝提供的第三方接口
        //........................
        return true;
    }

    public static boolean bankbpay(PayBody payBody) {
        //详细调用支付宝提供的第三方接口
        //........................
        return true;
    }
}

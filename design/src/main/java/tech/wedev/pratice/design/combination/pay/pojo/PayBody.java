package tech.wedev.pratice.design.combination.pay.pojo;

import lombok.Data;

/**
 * @Description: 属性的类型这里都是简写，实战项目肯定不会写这么粗糙，这里主要是写设计模式相关，细节就不抠了。
 */

@Data
public class PayBody {
    //账号
    private String account;
    //支付类型
    private int type;
    //产品信息
    private String product;
    //金额
    private int amount;
}

package tech.wedev.pratice.design.combination.pay.strategyEnum;

/**
 * @Description: 准备使用反射
 */

public enum StrategyEnum {
    ZfbPayStrategy("tech.wedev.pratice.design.combination.pay.strategy.ZfbPayStrategy"),
    WxPayStrategy("tech.wedev.pratice.design.combination.pay.strategy.WxPayStrategy"),
    BankPayStrategy("tech.wedev.pratice.design.combination.pay.strategy.BankPayStrategy");

    String value = "";

    StrategyEnum(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
}

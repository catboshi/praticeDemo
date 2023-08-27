package tech.wedev.pratice.design.combination.pojo;

/**
 * @Description: 属性的类型这里都是简写，实战项目肯定不会写这么粗糙，这里主要是写设计模式相关，细节就不抠了。
 */

public class PayBody {
    //账号
    private String account;
    //支付类型
    private int type;
    //产品信息
    private String product;
    //金额
    private int amcount;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getAmcount() {
        return amcount;
    }

    public void setAmcount(int amcount) {
        this.amcount = amcount;
    }
}

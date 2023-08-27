package tech.wedev.pratice.design.combination.items.node;
/**
 * @Author: zhiwei Liao
 * @Date: 2022/9/29 21:29
 * @Description:
 */
public abstract class AbstractProductItem {
    public abstract void removeChild(AbstractProductItem item);
    public abstract void addChild(AbstractProductItem item);
}

package tech.wedev.pratice.design.combination.items.visitor;

import org.springframework.stereotype.Component;
import tech.wedev.pratice.design.combination.MockDb;
import tech.wedev.pratice.design.combination.items.node.ProductItem;

@Component
public class DelItemVisitor implements ItemVisitor<ProductItem>{
    // 入参是 id 2, pid为 1
    @Override
    public ProductItem visitor(ProductItem productItem) {
        ProductItem currentItem = MockDb.ProductItem; //  从缓存来的 to do
        if(productItem.getId() == currentItem.getId()) {
            throw new UnsupportedOperationException("根节点不能删。");
        }
        if(productItem.getPid() == currentItem.getId()) {
            currentItem.removeChild(productItem);
            return currentItem;
        }
        delChild(productItem, currentItem);
        return currentItem;
    }

    private void delChild(ProductItem productItem, ProductItem currentItem) {
        for(ProductItem item : currentItem.getChild()) {
            if(item.getId() == productItem.getPid()) {
                item.removeChild(productItem);
                break;
            } else {
                delChild(productItem, item);
            }
        }
    }
}

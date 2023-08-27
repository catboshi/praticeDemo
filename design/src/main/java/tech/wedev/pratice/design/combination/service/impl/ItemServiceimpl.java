package tech.wedev.pratice.design.combination.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wedev.pratice.design.combination.MockDb;
import tech.wedev.pratice.design.combination.items.node.ProductItem;
import tech.wedev.pratice.design.combination.items.visitor.AddItemVisitor;
import tech.wedev.pratice.design.combination.items.visitor.DelItemVisitor;
import tech.wedev.pratice.design.combination.service.ItemService;

@Service
public class ItemServiceimpl implements ItemService {
    @Autowired
    private DelItemVisitor delItemVisitor;

    @Autowired
    private AddItemVisitor addItemVisitor;

    //这部分只有初始化的时候获取一次 或者 直接预热到缓存中
    public ProductItem getItem() {
        System.out.println("从DB 获取所有的目录");
        System.out.println("将数据组装为 ProductItem");
        System.out.println("将组装好的 ProductItem 放入缓存中，永不过期 ");
        return MockDb.ProductItem;
    }

    public ProductItem delItem(ProductItem productItem) {
        ProductItem item = delItemVisitor.visitor(productItem);
        MockDb.ProductItem = item;
        System.out.println("update db");
        return item;
    }

    public ProductItem addItem(ProductItem productItem) {
        ProductItem item = addItemVisitor.visitor(productItem);
        MockDb.ProductItem = item;
        System.out.println("update db");
        return item;
    }
}

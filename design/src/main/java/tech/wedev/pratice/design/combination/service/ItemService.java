package tech.wedev.pratice.design.combination.service;

import tech.wedev.pratice.design.combination.items.node.ProductItem;

public interface ItemService {

    ProductItem getItem();

    ProductItem delItem(ProductItem productItem);

    ProductItem addItem(ProductItem productItem);

}

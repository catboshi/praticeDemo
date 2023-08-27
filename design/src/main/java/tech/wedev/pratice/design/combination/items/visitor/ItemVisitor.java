package tech.wedev.pratice.design.combination.items.visitor;

import tech.wedev.pratice.design.combination.items.node.ProductItem;

public interface ItemVisitor<T> {
    T visitor(ProductItem productItem);
}

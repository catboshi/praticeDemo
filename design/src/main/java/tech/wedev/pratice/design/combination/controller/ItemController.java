package tech.wedev.pratice.design.combination.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tech.wedev.pratice.design.combination.items.node.ProductItem;
import tech.wedev.pratice.design.combination.service.ItemService;

@RestController
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("get")
    public ProductItem getItem() {
        return itemService.getItem();
    }

    @PostMapping("del")
    public ProductItem delItem(@RequestBody ProductItem productItem) {
        return itemService.delItem(productItem);
    }

    @PostMapping("add")
    public ProductItem addItem(@RequestBody ProductItem productItem) {
        return itemService.addItem(productItem);
    }

}

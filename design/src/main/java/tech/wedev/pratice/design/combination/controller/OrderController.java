package tech.wedev.pratice.design.combination.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.wedev.pratice.design.combination.order.pojo.Order;
import tech.wedev.pratice.design.combination.pay.pojo.PayBody;
import tech.wedev.pratice.design.combination.service.OrderService;

/**
 * @Description: 订单管理，这里简单写写，主要是设计模式，别抠细节
 */
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("mkOrder")
    public Order createOrder(@RequestParam Integer oid) {
        return orderService.createOrder(oid);
    }

    @PostMapping("/pay")
    public Order payOrder(@RequestBody PayBody payBody){
        return orderService.pay(payBody);
    }

    @GetMapping("/send")
    public Order send(@RequestParam Integer oid) {
        return orderService.send(oid);
    }

    @GetMapping("/receive")
    public Order receive(@RequestParam Integer oid) {
        return orderService.receive(oid);
    }
}

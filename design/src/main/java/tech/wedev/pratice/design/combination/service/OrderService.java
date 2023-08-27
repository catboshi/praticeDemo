package tech.wedev.pratice.design.combination.service;

import tech.wedev.pratice.design.combination.order.pojo.Order;
import tech.wedev.pratice.design.combination.pay.pojo.PayBody;

/**
 * @Author: zhiwei Liao
 * @Date: 2022/9/25 9:28
 * @Description:
 */
public interface OrderService {

    Order createOrder(Integer oid);

    Order pay(PayBody payBody);

    Order send(Integer oid);

    Order receive(Integer oid);
}

package tech.wedev.pratice.design.combination.order.pojo;
/**
 * @Description:订单状态操作
 */
public enum OrderStateChangeAction {
    PAY_ORDER, // 支付操作
    SEND_ORDER, // 发货操作
    RECEIVE_ORDER; // 收货操作
}

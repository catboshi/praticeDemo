package tech.wedev.pratice.design.combination.order.pojo;
/**
 * @Description:订单状态
 */
public enum  OrderState {
    ORDER_WAIT_PAY, // 待支付
    ORDER_WAIT_SEND, // 待发货
    ORDER_WAIT_RECEIVE, // 待收货
    ORDER_FINISH; // 完成订单
}

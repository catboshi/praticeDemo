package tech.wedev.pratice.design.combination.order.listener;

import org.springframework.messaging.Message;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;
import org.springframework.stereotype.Component;
import tech.wedev.pratice.design.combination.order.pojo.Order;
import tech.wedev.pratice.design.combination.order.pojo.OrderState;
import tech.wedev.pratice.design.combination.order.pojo.OrderStateChangeAction;

/**
 * @Description:监听器是监听到 action 后进行状态的一个变更。
 */
@Component("orderStateListener")
@WithStateMachine(name="orderStateMachine")
public class OrderStateListener {
    @OnTransition(source = "ORDER_WAIT_PAY", target = "ORDER_WAIT_SEND")
    public boolean payToSend(Message<OrderStateChangeAction> message){
        Order order = (Order) message.getHeaders().get("order");
        order.setOrderState(OrderState.ORDER_WAIT_SEND);
        return true;
    }
    @OnTransition(source = "ORDER_WAIT_SEND", target = "ORDER_WAIT_RECEIVE")
    public boolean sendToReceive(Message<OrderStateChangeAction> message){
        Order order = (Order) message.getHeaders().get("order");
        order.setOrderState(OrderState.ORDER_WAIT_RECEIVE);
        return true;
    }
    @OnTransition(source = "ORDER_WAIT_RECEIVE", target = "ORDER_FINISH")
    public boolean receiveToFinish(Message<OrderStateChangeAction> message){
        Order order = (Order) message.getHeaders().get("order");
        order.setOrderState(OrderState.ORDER_FINISH);
        return true;
    }

}

package tech.wedev.pratice.design.combination.order.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateMachineContext;
import org.springframework.statemachine.StateMachinePersist;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.persist.DefaultStateMachinePersister;
import org.springframework.statemachine.support.DefaultStateMachineContext;
import tech.wedev.pratice.design.combination.order.pojo.Order;
import tech.wedev.pratice.design.combination.order.pojo.OrderState;
import tech.wedev.pratice.design.combination.order.pojo.OrderStateChangeAction;

import java.util.EnumSet;
@Configuration
@EnableStateMachine(name="orderStateMachine")
public class OrderStateMachineConfig extends StateMachineConfigurerAdapter<OrderState, OrderStateChangeAction> {
    public void configure(StateMachineStateConfigurer<OrderState, OrderStateChangeAction> states) throws Exception {
        states.withStates().initial(OrderState.ORDER_WAIT_PAY)
                .states(EnumSet.allOf(OrderState.class));
    }

    public void configure(StateMachineTransitionConfigurer<OrderState, OrderStateChangeAction> transitions) throws Exception {
        transitions.withExternal().source(OrderState.ORDER_WAIT_PAY)
                .target(OrderState.ORDER_WAIT_SEND)
                .event(OrderStateChangeAction.PAY_ORDER)
                .and()
                .withExternal().source(OrderState.ORDER_WAIT_SEND)
                .target(OrderState.ORDER_WAIT_RECEIVE)
                .event(OrderStateChangeAction.SEND_ORDER)
                .and()
                .withExternal().source(OrderState.ORDER_WAIT_RECEIVE)
                .target(OrderState.ORDER_FINISH)
                .event(OrderStateChangeAction.RECEIVE_ORDER);
    }

    // 配置状态机持久化
    @Bean
    public DefaultStateMachinePersister machinePersister() {
        return new DefaultStateMachinePersister<>(new StateMachinePersist<Object, Object, Order>() {

            @Override
            public void write(StateMachineContext<Object, Object> stateMachineContext, Order order) throws Exception {
                //持久化操作。可以通过任何形式进行持久化。redis 、 mongodb、mysql，ecache
            }

            @Override
            public StateMachineContext<Object, Object> read(Order order) throws Exception {
                // 本来是应该从持久化组件里进行读取的。但是没做持久化
                return new DefaultStateMachineContext(order.getOrderState(), null, null, null);
            }
        });
    }
}

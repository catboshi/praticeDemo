package tech.wedev.pratice.design.responsibility;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import tech.wedev.pratice.design.responsibility.abstracts.AbstractIHandle;

@Component
@Order(value = 4)
public class PostHandle extends AbstractIHandle {
    @Override
    public boolean doHandle() {
        System.out.println("后置处理...");
        return true;
    }
}

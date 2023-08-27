package tech.wedev.pratice.design.responsibility;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import tech.wedev.pratice.design.responsibility.abstracts.AbstractIHandle;

@Component
@Order(value = 3)
public class ServiceHandle extends AbstractIHandle {
    @Override
    public boolean doHandle() {
        System.out.println("业务处理...");
        return true;
    }
}

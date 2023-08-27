package tech.wedev.pratice.design.responsibility;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import tech.wedev.pratice.design.responsibility.abstracts.AbstractIHandle;

@Component
@Order(value = 1)
public class PreHandle extends AbstractIHandle {
    @Override
    public boolean doHandle() {
        System.out.println("前置检查...");
        return true;
    }
}

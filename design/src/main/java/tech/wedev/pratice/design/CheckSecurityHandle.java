package tech.wedev.pratice.design;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import tech.wedev.pratice.design.abstracts.AbstractIHandle;

@Component
@Order(value = 2)
public class CheckSecurityHandle extends AbstractIHandle {
    @Override
    public boolean doHandle() {
        System.out.println("安全检查...");
        return true;
    }
}

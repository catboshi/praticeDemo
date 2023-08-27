package tech.wedev.pratice.design.combination.order.auditlog;

import org.springframework.stereotype.Component;
import tech.wedev.pratice.design.combination.order.auditlog.pojo.AuditLog;

@Component
public class OrderLogProcessor extends AbstractAuditLogProcessor{
    @Override
    protected AuditLog buildDetails(AuditLog auditLog) {
        String orderId = auditLog.getOrderId();
        String productDetails = "通过 orderId 获取";
        auditLog.setDetails(productDetails);
        System.out.println(auditLog);
        return auditLog;
    }
}

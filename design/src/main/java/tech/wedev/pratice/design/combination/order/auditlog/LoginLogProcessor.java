package tech.wedev.pratice.design.combination.order.auditlog;

import org.springframework.stereotype.Component;
import tech.wedev.pratice.design.combination.order.auditlog.pojo.AuditLog;

@Component
public class LoginLogProcessor extends AbstractAuditLogProcessor{
    @Override
    protected AuditLog buildDetails(AuditLog auditLog) {
        return auditLog;
    }
}

package tech.wedev.pratice.design.combination.order.auditlog;

import org.springframework.stereotype.Component;
import tech.wedev.pratice.design.combination.order.auditlog.pojo.AuditLog;

/**
 * @Author: zhiwei Liao
 * @Date: 2022/9/26 21:29
 * @Description:
 */
@Component
public class PayLogProcessor extends AbstractAuditLogProcessor{
    @Override
    protected AuditLog buildDetails(AuditLog auditLog) {
        String orderId = auditLog.getOrderId();
        String allDetails = "通过 orderId 或者是参数 获取产品信息，金额，支付方式";
        auditLog.setDetails(allDetails);
        System.out.println(auditLog);
        return auditLog;
    }
}

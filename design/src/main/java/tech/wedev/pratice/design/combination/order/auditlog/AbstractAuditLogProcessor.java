package tech.wedev.pratice.design.combination.order.auditlog;

import tech.wedev.pratice.design.combination.order.auditlog.pojo.AuditLog;

import java.util.Date;
/**
 * @Author: zhiwei Liao
 * @Date: 2022/9/26 21:29
 * @Description:
 */
public abstract class AbstractAuditLogProcessor {
    // 创建我们的 AuditLog (基础部分）
    public final AuditLog buildAuditLog(String account, String action, String orderId){
        AuditLog auditLog = new AuditLog();
        auditLog.setAccount(account);
        auditLog.setAction(action);
        auditLog.setOrderId(orderId);
        auditLog.setDate(new Date());
        return auditLog;
    }

    protected abstract AuditLog buildDetails(AuditLog auditLog);

    public final void sendToQueue(AuditLog auditLog) {
        //send toQueue(auditLog)
    }

    public final void processAuditLog(String account, String action, String orderId) {
        this.sendToQueue(buildDetails(buildAuditLog(account, action, orderId)));
    }
}

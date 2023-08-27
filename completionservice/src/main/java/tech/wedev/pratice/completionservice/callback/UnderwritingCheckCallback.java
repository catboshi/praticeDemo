package tech.wedev.pratice.completionservice.callback;

import tech.wedev.pratice.completionservice.model.Insured;
import tech.wedev.pratice.completionservice.model.PolicyModel;
import tech.wedev.pratice.completionservice.model.TaskResponseModel;
import tech.wedev.pratice.completionservice.service.UnderwritingCheckService;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.Callable;

/**
 * @description: 核保校验线程
 **/
@Data
@AllArgsConstructor
public class UnderwritingCheckCallback implements Callable<TaskResponseModel<Object>> {
    private String key;
    private PolicyModel policyModel;
    private final UnderwritingCheckService underwritingCheckService;
    @Override
    public TaskResponseModel<Object> call() throws Exception {
        return underwritingCheckService.underwritingCheck(key, policyModel);
    }
}

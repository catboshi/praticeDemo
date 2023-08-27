package tech.wedev.pratice.completionservice.callback;

import tech.wedev.pratice.completionservice.model.PolicyModel;
import tech.wedev.pratice.completionservice.model.TaskResponseModel;
import tech.wedev.pratice.completionservice.service.InsuranceVerificationService;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.Callable;

/**
 * @description: 投保校验线程
 **/
@Data
@AllArgsConstructor
public class InsuranceVerificationCallback implements Callable<TaskResponseModel<Object>> {
    private String key;
    private PolicyModel policyModel;
    private final InsuranceVerificationService insuranceVerificationService;
    @Override
    public TaskResponseModel<Object> call() throws Exception {
        return insuranceVerificationService.insuranceCheck(key, policyModel);
    }
}

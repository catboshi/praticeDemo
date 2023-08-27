package tech.wedev.pratice.completionservice.service;

import tech.wedev.pratice.completionservice.model.PolicyModel;
import tech.wedev.pratice.completionservice.model.TaskResponseModel;

public interface InsuranceVerificationService {
    TaskResponseModel<Object> insuranceCheck(String key, PolicyModel policyModel);
}

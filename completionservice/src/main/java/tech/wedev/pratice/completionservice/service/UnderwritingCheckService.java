package tech.wedev.pratice.completionservice.service;

import tech.wedev.pratice.completionservice.model.Insured;
import tech.wedev.pratice.completionservice.model.PolicyModel;
import tech.wedev.pratice.completionservice.model.TaskResponseModel;

/**
 * @description: 核保校验
 **/

public interface UnderwritingCheckService {
    TaskResponseModel<Object> underwritingCheck(String key, PolicyModel policyModel);
}

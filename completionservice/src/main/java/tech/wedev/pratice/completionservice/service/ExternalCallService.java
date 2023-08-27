package tech.wedev.pratice.completionservice.service;

import tech.wedev.pratice.completionservice.model.Insured;
import tech.wedev.pratice.completionservice.model.PolicyModel;
import tech.wedev.pratice.completionservice.model.TaskResponseModel;

public interface ExternalCallService {
    TaskResponseModel<Object> externalCall(String key, Insured insured);
}

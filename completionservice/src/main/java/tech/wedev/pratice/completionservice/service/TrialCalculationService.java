package tech.wedev.pratice.completionservice.service;

import tech.wedev.pratice.completionservice.model.PolicyModel;
import tech.wedev.pratice.completionservice.model.Risk;
import tech.wedev.pratice.completionservice.model.TaskResponseModel;

public interface TrialCalculationService {
    TaskResponseModel<Object> trialCalc(String key, Risk risk);
}

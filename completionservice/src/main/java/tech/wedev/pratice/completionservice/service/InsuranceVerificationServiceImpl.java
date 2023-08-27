package tech.wedev.pratice.completionservice.service;

import tech.wedev.pratice.completionservice.model.PolicyModel;
import tech.wedev.pratice.completionservice.model.TaskResponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @description: 投保校验
 **/
@Service
public class InsuranceVerificationServiceImpl implements InsuranceVerificationService {
    private static final Logger logger = LoggerFactory.getLogger(InsuranceVerificationServiceImpl.class);
    @Override
    public TaskResponseModel<Object> insuranceCheck(String key, PolicyModel policyModel) {
        TaskResponseModel<Object> taskResponseModel = new TaskResponseModel<>();
        try {
            //假设耗时50ms
            Thread.sleep(50);
            taskResponseModel.setKey(key);
            taskResponseModel.setResultCode("200");
            taskResponseModel.setData(policyModel);
        } catch (InterruptedException e) {
            logger.warn(e.getMessage());
            taskResponseModel.setKey(key);
            taskResponseModel.setResultCode("400");
            taskResponseModel.setResultMessage(e.getMessage());
        } finally {
            return taskResponseModel;
        }
    }
}

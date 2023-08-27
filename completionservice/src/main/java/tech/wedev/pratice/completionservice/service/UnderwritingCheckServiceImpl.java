package tech.wedev.pratice.completionservice.service;

import tech.wedev.pratice.completionservice.model.Insured;
import tech.wedev.pratice.completionservice.model.PolicyModel;
import tech.wedev.pratice.completionservice.model.TaskResponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @description: 核保校验
 **/
@Service
public class UnderwritingCheckServiceImpl implements UnderwritingCheckService {
    private static final Logger logger = LoggerFactory.getLogger(UnderwritingCheckServiceImpl.class);
    @Override
    public TaskResponseModel<Object> underwritingCheck(String key, PolicyModel policyModel) {
        try {
            //假设耗时50ms
            Thread.sleep(50);
            TaskResponseModel<Object> taskResponseModel = new TaskResponseModel<>();
            taskResponseModel.setKey(key);
            taskResponseModel.setResultCode("200");
            taskResponseModel.setData(policyModel);
            return taskResponseModel;
        } catch (InterruptedException e) {
            logger.warn(e.getMessage());
            TaskResponseModel<Object> taskResponseModel = new TaskResponseModel<>();
            taskResponseModel.setKey(key);
            taskResponseModel.setResultCode("400");
            taskResponseModel.setResultMessage(e.getMessage());
            return taskResponseModel;
        }
    }
}

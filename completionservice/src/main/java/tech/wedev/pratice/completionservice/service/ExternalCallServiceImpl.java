package tech.wedev.pratice.completionservice.service;

import tech.wedev.pratice.completionservice.model.ExternalCallResultModel;
import tech.wedev.pratice.completionservice.model.Insured;
import tech.wedev.pratice.completionservice.model.PolicyModel;
import tech.wedev.pratice.completionservice.model.TaskResponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @description: 外网接口调用，比较耗时
 **/
@Service
public class ExternalCallServiceImpl implements ExternalCallService {
    private static final Logger logger = LoggerFactory.getLogger(ExternalCallServiceImpl.class);
    @Override
    public TaskResponseModel<Object> externalCall(String key, Insured insured) {
        try {
            //假设耗时200ms
            Thread.sleep(200);
            TaskResponseModel<Object> taskResponseModel = new TaskResponseModel<>();
            taskResponseModel.setKey(key);
            taskResponseModel.setResultCode("200");
            ExternalCallResultModel externalCallResultModel = new ExternalCallResultModel();
            externalCallResultModel.setIdcard(insured.getIdcard());
            externalCallResultModel.setScore(200);
            taskResponseModel.setData(externalCallResultModel);
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

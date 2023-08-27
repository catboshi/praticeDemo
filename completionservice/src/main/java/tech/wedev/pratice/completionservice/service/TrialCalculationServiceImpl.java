package tech.wedev.pratice.completionservice.service;

import tech.wedev.pratice.completionservice.model.PolicyModel;
import tech.wedev.pratice.completionservice.model.Risk;
import tech.wedev.pratice.completionservice.model.TaskResponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @description: 保费试算
 **/
@Service
public class TrialCalculationServiceImpl implements TrialCalculationService {
    private static final Logger logger = LoggerFactory.getLogger(TrialCalculationServiceImpl.class);
    @Override
    public TaskResponseModel<Object> trialCalc(String key, Risk risk) {
        try {
            //假设耗时50ms
            Thread.sleep(50);
            TaskResponseModel<Object> taskResponseModel = new TaskResponseModel<>();
            taskResponseModel.setKey(key);
            taskResponseModel.setResultCode("200");
            taskResponseModel.setData(risk);
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

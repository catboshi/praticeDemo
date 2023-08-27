package tech.wedev.pratice.completionservice.callback;

import tech.wedev.pratice.completionservice.model.Insured;
import tech.wedev.pratice.completionservice.model.Risk;
import tech.wedev.pratice.completionservice.model.TaskResponseModel;
import tech.wedev.pratice.completionservice.service.ExternalCallService;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.Callable;

/**
 * @description: 外网调用线程
 **/
@Data
@AllArgsConstructor
public class ExternalCallCallback implements Callable<TaskResponseModel<Object>> {
    private String key;
    private Insured insured;
    private final ExternalCallService externalCallService;


    @Override
    public TaskResponseModel<Object> call() throws Exception {
        return externalCallService.externalCall(key, insured);
    }
}

package tech.wedev.pratice.completionservice.callback;

import tech.wedev.pratice.completionservice.model.Risk;
import tech.wedev.pratice.completionservice.model.TaskResponseModel;
import tech.wedev.pratice.completionservice.service.TrialCalculationService;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.Callable;

/**
 * @description: 保费试算线程
 **/
@Data
@AllArgsConstructor
public class TrialCalculationCallback implements Callable<TaskResponseModel<Object>> {
    private String key;
    private Risk risk;
    private final TrialCalculationService trialCalculationService;
    @Override
    public TaskResponseModel<Object> call() throws Exception {
        return trialCalculationService.trialCalc(key, risk);
    }
}

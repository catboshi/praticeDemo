package tech.wedev.pratice.completionservice.controller;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tech.wedev.pratice.completionservice.callback.ExternalCallCallback;
import tech.wedev.pratice.completionservice.callback.InsuranceVerificationCallback;
import tech.wedev.pratice.completionservice.callback.TrialCalculationCallback;
import tech.wedev.pratice.completionservice.callback.UnderwritingCheckCallback;
import tech.wedev.pratice.completionservice.model.Insured;
import tech.wedev.pratice.completionservice.model.PolicyModel;
import tech.wedev.pratice.completionservice.model.Risk;
import tech.wedev.pratice.completionservice.model.TaskResponseModel;
import tech.wedev.pratice.completionservice.service.ExternalCallService;
import tech.wedev.pratice.completionservice.service.InsuranceVerificationService;
import tech.wedev.pratice.completionservice.service.TrialCalculationService;
import tech.wedev.pratice.completionservice.service.UnderwritingCheckService;
import tech.wedev.pratice.completionservice.task.TaskExecutor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@RestController
public class CompletionServiceController {
    //投保key
    private static final String INSURANCE_KEY = "insurance_";
    //核保key
    private static final String UNDERWRITING_KEY = "underwriting_";
    //外部调用key
    private static final String EXTERNALCALL_KEY = "externalcall_";
    //试算key
    private static final String TRIA_KEY = "trial_";

    private static final Logger logger = LoggerFactory.getLogger(CompletionServiceController.class);
    
    private final ExternalCallService externalCallService;
    private final InsuranceVerificationService insuranceVerificationService;
    private final TrialCalculationService trialCalculationService;
    private final UnderwritingCheckService underwritingCheckService;
    private final TaskExecutor taskExecutor;

    public CompletionServiceController(ExternalCallService externalCallService, InsuranceVerificationService insuranceVerificationService, TrialCalculationService trialCalculationService, UnderwritingCheckService underwritingCheckService, TaskExecutor taskExecutor) {
        this.externalCallService = externalCallService;
        this.insuranceVerificationService = insuranceVerificationService;
        this.trialCalculationService = trialCalculationService;
        this.underwritingCheckService = underwritingCheckService;
        this.taskExecutor = taskExecutor;
    }

    //多线程异步并发接口
    @PostMapping(value = "/async", headers = "Content-Type=application/json;charset=UTF-8")
    public String asyncExec(@RequestBody PolicyModel policyModel) {
        long start = System.currentTimeMillis();

        asyncExecute(policyModel);
        logger.info("异步总共耗时：" + (System.currentTimeMillis() - start));
        return "ok";
    }

    //串行调用接口
    @PostMapping(value = "/sync", headers = "Content-Type=application/json;charset=UTF-8")
    public String syncExec(@RequestBody PolicyModel policyModel) {
        long start = System.currentTimeMillis();
        syncExecute(policyModel);
        logger.info("同步总共耗时：" + (System.currentTimeMillis() - start));
        return "ok";
    }
    private void asyncExecute(PolicyModel policyModel) {
        List<Callable<TaskResponseModel<Object>>> baseTaskCallbackList = new ArrayList<>();
        //根据被保人外部接口调用
        for (Insured insured : policyModel.getInsuredList()) {
            ExternalCallCallback externalCallCallback = new ExternalCallCallback(EXTERNALCALL_KEY + insured.getIdcard(), insured, externalCallService);
            baseTaskCallbackList.add(externalCallCallback);
        }
        //投保校验
        InsuranceVerificationCallback insuranceVerificationCallback = new InsuranceVerificationCallback(INSURANCE_KEY, policyModel, insuranceVerificationService);
        baseTaskCallbackList.add(insuranceVerificationCallback);
        //核保校验
        UnderwritingCheckCallback underwritingCheckCallback = new UnderwritingCheckCallback(UNDERWRITING_KEY, policyModel, underwritingCheckService);
        baseTaskCallbackList.add(underwritingCheckCallback);
        //根据险种进行保费试算
        for(Risk risk : policyModel.getRiskList()) {
            TrialCalculationCallback trialCalculationCallback = new TrialCalculationCallback(TRIA_KEY + risk.getRiskcode(), risk, trialCalculationService);
            baseTaskCallbackList.add(trialCalculationCallback);
        }
        List<TaskResponseModel<Object>> results = taskExecutor.execute(baseTaskCallbackList);
        for (TaskResponseModel<Object> t : results) {
            logger.info(t.toString());
        }

    }
    private void syncExecute(PolicyModel policyModel) {
        //根据被保人外部接口调用
        for (Insured insured : policyModel.getInsuredList()) {
            TaskResponseModel<Object> externalCall = externalCallService.externalCall(insured.getIdcard(), insured);
            logger.info(externalCall.toString());
        }
        //投保校验
        TaskResponseModel<Object> insurance = insuranceVerificationService.insuranceCheck(INSURANCE_KEY, policyModel);
        logger.info(insurance.toString());
        //核保校验
        TaskResponseModel<Object> underwriting = underwritingCheckService.underwritingCheck(UNDERWRITING_KEY, policyModel);
        logger.info(underwriting.toString());
        //根据险种进行保费试算
        for(Risk risk : policyModel.getRiskList()) {
            TaskResponseModel<Object> riskTrial = trialCalculationService.trialCalc(risk.getRiskcode(), risk);
            logger.info(riskTrial.toString());
        }

    }

    public static void main(String[] args) {
        List<Risk> riskList = new ArrayList<>();
        Risk risk1 = new Risk();
        risk1.setMainFlag(1);
        risk1.setPremium(new BigDecimal("300"));
        risk1.setRiskcode("risk001");
        risk1.setRiskname("险种一");
        riskList.add(risk1);

        Risk risk2 = new Risk();
        risk2.setMainFlag(0);
        risk2.setPremium(new BigDecimal("400"));
        risk2.setRiskcode("risk002");
        risk2.setRiskname("险种二");
        riskList.add(risk2);

        List<Insured> insuredList = new ArrayList<>();
        Insured insured1 = new Insured("320106", "张三");
        insuredList.add(insured1);
        Insured insured2 = new Insured("120102", "李四");
        insuredList.add(insured2);

        PolicyModel policyModel = new PolicyModel();
        policyModel.setInsuredList(insuredList);
        policyModel.setRiskList(riskList);
        policyModel.setPolicyNo("345000987");
        policyModel.setPolicyHolder("王五");
        System.out.println(JSONObject.toJSONString(policyModel));
    }
}

package tech.wedev.pratice.design.combination.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wedev.pratice.design.combination.pay.pojo.PayBody;
import tech.wedev.pratice.design.combination.service.PayService;

@RestController
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private PayService payService;

    @PostMapping("/dopay")
    public Boolean dopay(@RequestBody PayBody payBody){
        return payService.pay(payBody);
    }

}

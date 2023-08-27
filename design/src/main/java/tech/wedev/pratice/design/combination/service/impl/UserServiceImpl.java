package tech.wedev.pratice.design.combination.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wedev.pratice.design.combination.handler.SuggestRequirementHandlerProcess;
import tech.wedev.pratice.design.combination.implementor.LoginFunc;
import tech.wedev.pratice.design.combination.implementor.WbLoginFunc;
import tech.wedev.pratice.design.combination.implementor.abstractlogin.AbstractLoginProcessor;
import tech.wedev.pratice.design.combination.implementor.abstractlogin.ThirdPartLogin;
import tech.wedev.pratice.design.combination.pojo.TicketParam;
import tech.wedev.pratice.design.combination.pojo.UserInfo;
import tech.wedev.pratice.design.combination.service.UserService;
import tech.wedev.pratice.design.combination.ticket.builder.CompanyTicketBuilder;
import tech.wedev.pratice.design.combination.ticket.builder.PersonalTicketBuilder;
import tech.wedev.pratice.design.combination.ticket.builder.TicketBuilder;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SuggestRequirementHandlerProcess suggestRequirementHandlerProcess;

    @Override
    public List<String> suggestRequirement(String username) {
        //获取用户信息。因为用户已经登录了，那么user的信息是保存在我们的缓存里的。
        UserInfo userInfo = getUserInfo(username);
        List<String> results = new ArrayList<>();
        //可以发现，调用方无需关心任何 handler。完全对其屏蔽的。而且是完全解耦
        suggestRequirementHandlerProcess.process(userInfo, results);
        return results;
    }

    //因为这部分是需要查询 缓存（如果缓存没有，需要查库）不应该写到 service层，但是为了代码书写简便
    //这部分我模拟在service 层。
    private UserInfo getUserInfo(String username) {
        return new UserInfo();
    }

    public Object getTicket(TicketParam ticketParam) {
        TicketBuilder builder = null;
        String bankInfo = null;
        if(ticketParam.getBankInfo() != null) {
            bankInfo = "from 3rd party interface check.";
            builder = new CompanyTicketBuilder();
        } else {
            builder = new PersonalTicketBuilder();
        }
        builder.setParam(ticketParam.getAccount(), ticketParam.getTitle());
        String content = "from config center";
        String product = "from db";
        builder.setContent(content);
        builder.setProduct(product);
        builder.setBankInfo(bankInfo);
        // 详细的逻辑细节控制以及从配置中心或者是db中获取的逻辑步骤就是简单的 crud，自己明白即可
        return  builder.buildTicket();
    }

    public Boolean login(String name, String pwd, String type) {

        // 这部分我就不进行封装了，直接在 service里做了。小伙伴可以自行实现封装，类似享元。
        // 这部分是桥接模式的实现。
        if(type.equals("wb")) {
            LoginFunc func = new WbLoginFunc();
            AbstractLoginProcessor processor = new ThirdPartLogin(func);
            return processor.loginExecute(name, pwd, type);
        }

        return true;
    }
}

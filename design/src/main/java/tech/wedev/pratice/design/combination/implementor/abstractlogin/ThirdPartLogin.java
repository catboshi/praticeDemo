package tech.wedev.pratice.design.combination.implementor.abstractlogin;

import tech.wedev.pratice.design.combination.implementor.LoginFunc;

public class ThirdPartLogin extends AbstractLoginProcessor{

    public ThirdPartLogin(LoginFunc loginFunc) {
        super(loginFunc);
    }

    @Override
    public boolean loginExecute(String name, String pwd, String type) {
        return super.loginFunc.login(name, pwd, type);
    }
}

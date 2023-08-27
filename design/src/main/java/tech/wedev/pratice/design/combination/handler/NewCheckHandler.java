package tech.wedev.pratice.design.combination.handler;

import tech.wedev.pratice.design.combination.pojo.UserInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:新用户首次购买投放指定业务
 */
public class NewCheckHandler extends AbstractSuggestRequirementHandler{
    @Override
    public void processHandler(UserInfo userInfo, List<String> suggestLists) {
        //通过获取 userinfo 的 buyProducts 属性
        boolean newUser = userInfo.isNewUser();
        if(newUser) {
            suggestLists = new ArrayList<>(); // 特定的新用户奖励
        }
    }
}

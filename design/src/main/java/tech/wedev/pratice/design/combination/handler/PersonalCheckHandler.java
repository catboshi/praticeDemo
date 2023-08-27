package tech.wedev.pratice.design.combination.handler;

import tech.wedev.pratice.design.combination.pojo.UserInfo;

import java.util.List;
/**
 * @Description:用户资质是否满足业务投放资质
 */
public class PersonalCheckHandler extends AbstractSuggestRequirementHandler{
    @Override
    public void processHandler(UserInfo userInfo, List<String> suggestLists) {
        // 通过个人资质的check，我们找到了 4 个可以投放的业务。放到 suggestLists 中。
        suggestLists.add("1");
        suggestLists.add("2");
        suggestLists.add("3");
        suggestLists.add("4");
    }
}

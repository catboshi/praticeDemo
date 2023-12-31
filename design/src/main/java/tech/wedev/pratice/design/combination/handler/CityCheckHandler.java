package tech.wedev.pratice.design.combination.handler;

import tech.wedev.pratice.design.combination.pojo.UserInfo;

import java.util.List;

/**
 * @Description:用户所在城市是否满足业务投放城市
 */
public class CityCheckHandler extends AbstractSuggestRequirementHandler{
    @Override
    public void processHandler(UserInfo userInfo, List<String> suggestLists) {
        //通过获取 userinfo 的 city 属性
        String city = userInfo.getCity();

        // 通过city 和 之前保留的 4 个 业务信息进行对比。然后筛选出剩余的 3 个 业务投放
        suggestLists.remove("1");
    }
}

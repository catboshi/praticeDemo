package tech.wedev.pratice.design.combination.handler;

import tech.wedev.pratice.design.combination.pojo.UserInfo;

import java.util.List;

/**
 * @Description:用户近期购买的商品是否符合投放的人群
 */
public class RecentCheckHandler extends AbstractSuggestRequirementHandler{
    @Override
    public void processHandler(UserInfo userInfo, List<String> suggestLists) {
        //通过获取 userinfo 的 buyProducts 属性
        List<String> buyProducts = userInfo.getBuyProducts();

        // buyProducts 和 之前保留的 3 个 业务信息进行对比。然后筛选出剩余的 2 个 业务投放
        suggestLists.remove("2");
    }
}

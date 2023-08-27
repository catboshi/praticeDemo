package tech.wedev.pratice.design.combination.handler;

import tech.wedev.pratice.design.combination.pojo.UserInfo;

import java.util.List;

public abstract class AbstractSuggestRequirementHandler {
    abstract void processHandler(UserInfo userInfo, List<String> suggestLists);
}

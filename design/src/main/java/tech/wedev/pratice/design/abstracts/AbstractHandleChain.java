package tech.wedev.pratice.design.abstracts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import tech.wedev.pratice.design.service.IHandle;
import tech.wedev.pratice.design.service.IHandleChain;

import javax.annotation.PostConstruct;
import java.util.List;

public abstract class AbstractHandleChain implements IHandleChain {
    @Autowired
    List<IHandle> handlers;

    IHandle handler;

    @PostConstruct
    public void postHandlers(){
        if(CollectionUtils.isEmpty(handlers)){
            throw new RuntimeException("handlers should not be null or empty.");
        }
        System.out.println("开始执行postHandlers...");
        IHandle currentHandler;
        IHandle nextHandler;
        for (int i = 0; i < handlers.size(); i++) {
            if(i == 0){
                handler = handlers.get(0);
            }else{
                currentHandler = handlers.get(i-1);
                nextHandler = handlers.get(i);
                currentHandler.setNextIHandle(nextHandler);
            }
        }
        System.out.println("handleChain:"+handler);
    }

    protected boolean handle(){
        if(null == this.handler){
            throw new RuntimeException("handler should not be null.");
        }
        return this.handler.handle();
    }
}

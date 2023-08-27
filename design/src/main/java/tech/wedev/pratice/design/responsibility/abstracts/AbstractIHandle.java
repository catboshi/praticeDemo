package tech.wedev.pratice.design.responsibility.abstracts;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import tech.wedev.pratice.design.responsibility.service.IHandle;

public abstract class AbstractIHandle implements IHandle {
    IHandle nextIHandle;

    @Override
    public void setNextIHandle(IHandle iHandle) {
        this.nextIHandle = iHandle;
    }

    @Override
    public IHandle getNextIHandle() {
        return this.nextIHandle;
    }

    @Override
    public boolean handle() {
        boolean res = this.doHandle();
        if(res){
            if(null != getNextIHandle()){
                return getNextIHandle().handle();
            }
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}

package tech.wedev.pratice.design;

import org.springframework.stereotype.Component;
import tech.wedev.pratice.design.abstracts.AbstractHandleChain;

@Component
public class HandleChainClient extends AbstractHandleChain {
    @Override
    public boolean handleChain() {
        boolean res;
        if(res = this.handle()){
            System.out.println("全部业务处理成功!");
        }else{
            System.out.println("事务中途处理失败!!!");
        }
        return res;
    }
}

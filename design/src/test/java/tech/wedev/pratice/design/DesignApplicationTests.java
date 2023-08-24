package tech.wedev.pratice.design;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = DesignDemoApplication.class)
@RunWith(SpringRunner.class)
public class DesignApplicationTests {
    @Autowired
    HandleChainClient client;

    @Test
    public void test0(){
        boolean b = client.handleChain();
        System.out.println("结果为:" + b);
    }
}

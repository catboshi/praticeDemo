package tech.wedev.pratice.intern;

/**
 * @url <a href="https://blog.csdn.net/wang0112233/article/details/103353399/">Strings1=newString("1")+newString("1"),new String 面试</a>
 */
public class InternTest {

    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1(){
        String s = new String("1");
        s.intern();
        String s2 = "1";
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);
    }

    public static void test2(){
        String s = new String("1");
        String s2 = "1";
        s.intern();
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        String s4 = "11";
        s3.intern();
        System.out.println(s3 == s4);
    }
}

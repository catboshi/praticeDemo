package tech.wedev.pratice.intern;

public class Test {

    /**
     * https://blog.csdn.net/superlover_/article/details/93719290
     * @param args
     */
    public static void main(String[] args) {
        String str1 = new String("A")+ new String("B");
        System.out.println(str1 == str1.intern());
        System.out.println(str1 == "AB");

        String str2 = "CD";
        String str3 = new String("C")+ new String("D");
        System.out.println(str3 == str3.intern());
        System.out.println(str3 == "CD");

        //深入了解intern()方法
        System.out.println("---------");
        String s = new String("1");
        s.intern();
        String s2 = "1";
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);

        String s_ = new String("1");
        String s2_ = "1";
        s_.intern();
        System.out.println(s_ == s2_);

        String s3_ = new String("1") + new String("1");
        String s4_ = "11";
        s3_.intern();
        System.out.println(s3_ == s4_);

        System.out.println("---------");
        String s7 = new String("s7");
        System.out.println(s7.intern() == s7);

        String s8 = new String("s8") + new String("s8");
        System.out.println(s8.intern() == s8);

        String s9 = "s9" + new String("s9");
        System.out.println(s9.intern() == s9);

    }
}

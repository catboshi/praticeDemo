package tech.wedev.wecom.monad;

import lombok.var;

@FunctionalInterface
interface Functional {
    String goodbye(String arg);
}

interface FunctionalNoAnn {
    String goodbye(String arg);
}

/*
@FunctionalInterface
interface NotFunctional {
  String goodbye(String arg);
  String hello(String arg);
}
产生错误信息:
NotFunctional is not a functional interface
multiple non-overriding abstract methods
found in interface NotFunctional
*/

public class FunctionalAnnotation {
    public String goodbyee(String arg) {
        return "Goodbye, " + arg;
    }
    public static void main(String[] args) {
        FunctionalAnnotation fa =
                new FunctionalAnnotation();
        Functional f = fa::goodbyee;
        Functional f1 = a->fa.goodbyee(a);
        FunctionalNoAnn fna = fa::goodbyee;
        FunctionalNoAnn fna1 = a->fa.goodbyee(a);

        // Functional fac = fa; // Incompatible
        Functional fl = a -> "Goodbye, " + a;
        FunctionalNoAnn fnal = a -> "Goodbye, " + a;

        var goodbye = f1.goodbye("1");
        System.out.println(goodbye);//Goodbye, 1
    }
}

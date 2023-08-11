package tech.wedev.wecom.monad;

import java.util.function.*;

class I {
    @Override
    public String toString() { return "I"; }
}

class O {
    @Override
    public String toString() { return "O"; }
}

public class TransformFunction {
    static Function<I,O> transform(Function<I,O> in) {
        Function<O, O> function = o -> {
            System.out.println(o);
            return o;
        };
        return in.andThen(function);
    }
    public static void main(String[] args) {
        Function<I,O> f2 = transform(i -> {
            System.out.println(i);
            return new O();
        });
        O o = f2.apply(new I());
    }
}
package tech.wedev.pratice.design.flyweight;

/**
 * @see <a href="https://juejin.cn/post/7222900960790855736#comment">...</a>
 * @description 使用享元模式要注意线程安全问题，个人认为线程不安全会造成重复创建对象，与享元模式减少创建对象数量的理念相悖
 */
public class FlyweightPatternThreadDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                Circle circle1 = (Circle) ShapeFactory.getCircle("红");
                Circle circle2 = (Circle) ShapeFactory.getCircle("红");
                Circle circle3 = (Circle) ShapeFactory.getCircle("红");
                Circle circle4 = (Circle) ShapeFactory.getCircle("红");
                Circle circle5 = (Circle) ShapeFactory.getCircle("红");
                System.out.println(circle1 == circle2);
                System.out.println(circle1 == circle3);
                System.out.println(circle1 == circle4);
                System.out.println(circle1 == circle5);
            }).start();
        }
    }
}

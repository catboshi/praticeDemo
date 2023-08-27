package tech.wedev.pratice.design.flyweight;

public class FlyweightPatternDemo {
    public static void main(String[] args) {Circle circle1 = (Circle) ShapeFactory.getCircle("红");
        circle1.draw(new Location(1, 1, 1));

        Circle circle2 = (Circle) ShapeFactory.getCircle("绿");
        circle2.draw(new Location(2, 2, 2));

        // 复用
        Circle circle3 = (Circle) ShapeFactory.getCircle("红");
        circle3.draw(new Location(3, 3, 3));
    }
}

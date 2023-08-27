package tech.wedev.pratice.design.flyweight;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ShapeFactory {
//    private static Map<String, IShape> circleMap = new HashMap<>();
    private static Map<String, IShape> circleMap = new ConcurrentHashMap<>();


    public static synchronized IShape getCircle(String color) {
        /*Circle circle;
        if (circleMap.containsKey(color)) {
            circle = (Circle) circleMap.get(color);
        } else {
            circle = new Circle(color);
            System.out.println("*创建" + color + "色圆*");
            circleMap.put(color, circle);
        }
        return circle;*/
        IShape circle = circleMap.putIfAbsent(color, new Circle(color));
        if (circle == null) {
            return circleMap.get(color);
        }
        return circle;
    }
}

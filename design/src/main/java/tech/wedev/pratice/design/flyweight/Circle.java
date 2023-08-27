package tech.wedev.pratice.design.flyweight;

/**
 * @see <a href="https://juejin.cn/post/7222900960790855736">...</a>
 */
// 具体享元（Concrete Flyweight）
public class Circle implements IShape {private String color;

    public Circle(String color) {
        this.color = color;
    }

    @Override
    public void draw(Location location) {
        System.out.printf("画第%d个圆: %s色, [x, y] = [%d, %d]\n", location.getNum(), color, location.getX(), location.getY());
    }
}

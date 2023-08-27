package tech.wedev.pratice.design.flyweight;

public class Location {

    private int num, x, y;

    public Location(int num, int x, int y) {
        this.num = num;
        this.x = x;
        this.y = y;
    }

    public int getNum() {
        return num;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}

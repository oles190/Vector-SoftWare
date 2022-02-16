package task4.shapes;

import task4.Shape;

public class Rectangle implements Shape {

    private int base;
    private int width;


    public Rectangle(int base, int width) {
        this.base = base;
        this.width = width;
    }

    @Override
    public double area() {
        return base * width;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "base=" + base +
                ", width=" + width +
                '}';
    }


}

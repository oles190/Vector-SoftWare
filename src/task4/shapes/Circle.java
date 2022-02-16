package task4.shapes;

import task4.Shape;

public class Circle implements Shape {


    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }


    @Override
    public double area() {
        return radius * Math.PI;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }


}

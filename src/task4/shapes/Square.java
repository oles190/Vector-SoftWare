package task4.shapes;

import task4.Shape;

public class Square implements Shape {
    private int side;

    public Square(int side) {
        this.side = side;
    }

    @Override
    public double area() {
        return side * side;
    }


    @Override
    public String toString() {
        return "Square{" +
                "side=" + side +
                '}';
    }
}

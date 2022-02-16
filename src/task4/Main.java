package task4;

import task4.shapes.Circle;
import task4.shapes.Rectangle;
import task4.shapes.Square;
import task4.shapes.Triangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Circle circle = new Circle(31);
        Rectangle rectangle = new Rectangle(23, 5);
        Square square = new Square(21);
        Triangle triangle = new Triangle(52, 5);
        List<Shape> list = new ArrayList<>(Arrays.asList(circle, rectangle, square, triangle));
        ShapesComparator shapesComparator = new ShapesComparator();
        list.sort(shapesComparator);

        //TESTING
        for (Shape one : list) {
            System.out.println(one.area());
        }

        for (Shape one : list) {
            System.out.println(one.toString());
        }


    }
}

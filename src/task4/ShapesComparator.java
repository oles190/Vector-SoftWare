package task4;

import java.util.Comparator;

public class ShapesComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape o1, Shape o2) {
        return Double.compare(o1.area(), o2.area());
    }
}

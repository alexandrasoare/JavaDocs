package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Alexandra.Soare on 7/4/2017.
 */
public class Square extends Shape {
    private int side;

    public Square() {
        side = 0;
    }

    public Square(int side) {
        this.side = side;
    }

    @Override
    public double area() {
        return side*side;
    }
}

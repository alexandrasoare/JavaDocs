package ro.teamnet.zerotohero.oop.graphicshape;
import static java.lang.Math.PI;

/**
 * Created by Alexandra.Soare on 7/4/2017.
 */
public class Circle extends Shape {
    private int xPos, yPos, radius;

    public Circle() {
        xPos = 0;
        yPos = 0;
        radius = 0;
    }

    public Circle(int radius) {
        this.radius = radius;
    }

    public Circle(int xPos, int radius) {
        this.xPos = xPos;
        this.radius = radius;
    }

    public Circle(int xPos, int yPos, int radius) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.radius = radius;
    }

    @Override
    public double area() {
        return 2*Math.PI*radius*radius;
    }

    @Override
    public String toString() {
        return "center = (" + xPos + ", " + yPos + ") and radius = " + radius;
    }

    public void fillColor() {
        System.out.println("The default color is " + super.getColor());
    }

    public void fillColor(int color) {
        super.setColor(color);
        System.out.println("The circle color is now " + color);
    }

    public void fillColor(float saturation) {
        super.setSaturation(saturation);
        System.out.println("The saturation is now " + saturation);
    }

}

package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Alexandra.Soare on 7/4/2017.
 */
public class Circles {

    public double getAreaPub() {
        Circle circle = new Circle();

        return circle.area();
    }

    public void getAreaDef() {
        Circle circle = new Circle();
        int newColor = 2;
        float newSaturation = 3.6f;

        circle.fillColor();
        circle.fillColor(newColor);
        circle.fillColor(newSaturation);
    }
}

package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Alexandra.Soare on 7/4/2017.
 */
public class Shape extends AbstractShape implements ShapeBehaviour {
    protected int color;
    protected float saturation;
    double defaultArea = 0.0;

    public double area() {
        return defaultArea;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public float getSaturation() {
        return saturation;
    }

    public void setSaturation(float saturation) {
        this.saturation = saturation;
    }
}

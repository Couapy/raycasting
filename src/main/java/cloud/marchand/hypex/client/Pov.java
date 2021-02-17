package cloud.marchand.hypex.client;

public class Pov extends Point {

    /**
     * Angle of vision.
     */
    public double angle;

    /**
     * Field of view.
     */
    public double fov;

    public Pov(double x, double y, double angle) {
        super(x, y);
        this.angle = angle;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%f.02 °radians", angle);
    }
    
}

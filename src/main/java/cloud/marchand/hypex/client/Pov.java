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

    public Pov(double x, double y, double angle, double fov) {
        super(x, y);
        this.angle = angle;
        this.fov = fov;
    }

    public Pov(Point point) {
        super(point.x, point.y);
        angle = 0d;
        fov = Math.PI / 2;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%f.02 °radians", angle);
    }
    
}

package cloud.marchand.hypex.client;

public class Point {

    public double x;
    public double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

	public double distanceFrom(Point point) {
		return Math.sqrt(Math.pow(x - point.x, 2) + Math.pow(y - point.y, 2));
	}

    @Override
    public String toString() {
        return String.format("(%.02f, %.02f)", x, y);
    }

}

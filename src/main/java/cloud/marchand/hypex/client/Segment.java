package cloud.marchand.hypex.client;

public class Segment {

    public Point a;
    public Point b;

    public Segment(Point a, Point b) {
        this.a = a;
        this.b = b;
    }

	public Point intersect(Segment ray) {
        // Avoid parallel segments
        Point vr = ray.getVertex();
        Point vs = this.getVertex();
        double dotProduct = vr.x * vs.y - vr.y * vs.x;
        if (dotProduct == 0d) {
            return null;
        }

        double t2 = (vr.x * (a.y - ray.a.y) + vr.y * (ray.a.x - a.x)) / (vs.x * vr.y - vs.y * vr.x);
        double t1 = (a.x + vs.x * t2 - ray.a.x) / vr.x;
        if (t1 < 0 || t2 < 0 || t2 > 1) {
            return null;
        }

		return new Point(ray.a.x + vr.x * t1, ray.a.y + vr.y * t1);
	}

    public Point getVertex() {
        return new Point(b.x - a.x, b.y - a.y);
    }

    @Override
    public String toString() {
        return "[" + a + ", " + b + "]";
    }

}

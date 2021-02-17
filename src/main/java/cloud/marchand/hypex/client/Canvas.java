package cloud.marchand.hypex.client;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Canvas extends JPanel {

    public static final int POV_WIDTH = 10;
    public static final int POV_ANGLE_LENGTH = 50;
    public static final double ANGLE_THRESHOLD = 0.0001;

    private Map map;
    public Pov pov;

    public Canvas(Map map, Pov pov) {
        this.map = map;
        this.pov = pov;
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        setBackground(Color.BLACK);

        // Draw segments
        graphics.setColor(Color.GRAY);
        for (Segment segment : map.segments) {
            graphics.drawLine((int) segment.a.x, (int) segment.a.y, (int) segment.b.x, (int) segment.b.y);
        }

        for (Point point : map.points) {
            Segment seg = new Segment(pov, point);
            double angle = seg.getAngle();
            drawRay(graphics, point);
            drawRay(graphics, angle + ANGLE_THRESHOLD);
            drawRay(graphics, angle - ANGLE_THRESHOLD);
        }
        // Draw pov
        graphics.setColor(Color.GREEN);
        graphics.drawLine((int) pov.x, (int) pov.y, (int) (pov.x + Math.cos(pov.angle) * POV_ANGLE_LENGTH),
                (int) (pov.y + Math.sin(pov.angle) * POV_ANGLE_LENGTH));
        graphics.setColor(Color.RED);
        graphics.fillOval((int) (pov.x - POV_WIDTH / 2d), (int) (pov.y - POV_WIDTH / 2d), POV_WIDTH, POV_WIDTH);
    }

    private void drawRay(Graphics graphics, double angle) {
        Point point = new Point(pov.x + Math.cos(angle), pov.y + Math.sin(angle));
        drawRay(graphics, point);
    }

    private void drawRay(Graphics graphics, Point point) {
        Segment ray = new Segment(pov, point);
        Point closest = null;

        for (Segment segment : map.segments) {
            Point intersect = segment.intersect(ray);
            if (intersect == null) {
                continue;
            }
            if (closest == null || intersect.distance(pov) < closest.distance(pov)) {
                closest = intersect;
            }
        }
        if (closest != null) {
            graphics.setColor(Color.RED);
            graphics.drawLine((int) (pov.x), (int) (pov.y), (int) (closest.x), (int) (closest.y));
        }
    }

}

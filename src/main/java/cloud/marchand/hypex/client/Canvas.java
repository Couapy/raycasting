package cloud.marchand.hypex.client;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Canvas extends JPanel {

    public static final int POINT_WIDTH = 10;
    public static final double ANGLE_THRESHOLD = 0.0001;

    public Point mouse = null;
    private Map map;

    public Canvas(Map map) {
        this.mouse = new Point(getWidth() / 2d, getHeight() / 2d);
        this.map = map;
        addMouseMotionListener(new MouseListener(this));
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
            Segment seg = new Segment(mouse, point);
            double angle = seg.getAngle();
            drawRay(graphics, point);
            drawRay(graphics, angle + ANGLE_THRESHOLD);
            drawRay(graphics, angle - ANGLE_THRESHOLD);
        }
        // Draw mouse
        graphics.setColor(Color.RED);
        graphics.fillOval((int) (mouse.x - POINT_WIDTH / 2d), (int) (mouse.y - POINT_WIDTH / 2d), POINT_WIDTH,
                POINT_WIDTH);
    }

    private void drawRay(Graphics graphics, double angle) {
        Point point = new Point(mouse.x + Math.cos(angle), mouse.y + Math.sin(angle));
        drawRay(graphics, point);
    }

    private void drawRay(Graphics graphics, Point point) {
        Segment ray = new Segment(mouse, point);
        Point closest = null;
        
        for (Segment segment : map.segments) {
            Point intersect = segment.intersect(ray);
            if (intersect == null) {
                continue;
            }
            if (closest == null || intersect.distance(mouse) < closest.distance(mouse)) {
                closest = intersect;
            }
        }
        if (closest != null) {
            graphics.setColor(Color.RED);
            graphics.drawLine((int) (mouse.x), (int) (mouse.y), (int) (closest.x), (int) (closest.y));
        }
    }

}

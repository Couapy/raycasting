package cloud.marchand.hypex.client;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Canvas extends JPanel {

    public static final int POINT_WIDTH = 10;

    public Point mouse = null;
    private Map map;

    public Canvas(Map map) {
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

        if (mouse != null) {
            Point point = new Point(320, 180);
            Segment ray = new Segment(point, mouse);
            Point closest = null;
            Segment closestB = null;
            for (Segment segment : map.segments) {
                Point intersect = segment.intersect(ray);
                if (intersect == null) {
                    continue;
                }
                if (closest == null || intersect.distance(point) < closest.distance(point)) {
                    closest = intersect;
                    closestB = segment;
                }
            }
            if (closest != null) {
                graphics.setColor(Color.RED);
                graphics.drawLine((int) closestB.a.x, (int) closestB.a.y, (int) closestB.b.x, (int) closestB.b.y);
                // Draw projection
                graphics.drawLine((int) (point.x), (int) (point.y), (int) (closest.x), (int) (closest.y));
                // Draw point
                graphics.fillOval((int) (point.x - POINT_WIDTH / 2d), (int) (point.y - POINT_WIDTH / 2d), POINT_WIDTH,
                        POINT_WIDTH);
            }
        }
    }

}

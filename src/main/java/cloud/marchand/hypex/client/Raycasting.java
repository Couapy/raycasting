package cloud.marchand.hypex.client;

import java.awt.Dimension;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Raycasting extends JFrame {

    private Canvas canvas;

    private Map map;

    public Raycasting() {
        createMap();

        setSize(new Dimension(960, 720));
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        canvas = new Canvas(map);
        add(canvas);
    }

    private void createMap() {
        this.map = new Map();
        map.points.add(new Point(0d, 0d));
        map.points.add(new Point(640d, 0d));
        map.points.add(new Point(640d, 360d));
        map.points.add(new Point(0d, 360d));

        map.points.add(new Point(100d, 150d));
        map.points.add(new Point(120d, 50d));
        map.points.add(new Point(200d, 80d));
        map.points.add(new Point(140d, 210d));

        map.points.add(new Point(100d, 200d));
        map.points.add(new Point(120d, 250d));
        map.points.add(new Point(60d, 300d));

        map.points.add(new Point(200d, 260d));
        map.points.add(new Point(220d, 150d));
        map.points.add(new Point(300d, 200d));
        map.points.add(new Point(350d, 320d));

        map.points.add(new Point(340d, 60d));
        map.points.add(new Point(360d, 40d));
        map.points.add(new Point(370d, 70d));

        map.points.add(new Point(450d, 190d));
        map.points.add(new Point(560d, 170d));
        map.points.add(new Point(540d, 270d));
        map.points.add(new Point(430d, 290d));

        map.points.add(new Point(400d, 95d));
        map.points.add(new Point(580d, 50d));
        map.points.add(new Point(480d, 150d));


        // Border
        map.segments.add(new Segment(map.points.get(0), map.points.get(1)));
        map.segments.add(new Segment(map.points.get(1), map.points.get(2)));
        map.segments.add(new Segment(map.points.get(2), map.points.get(3)));
        map.segments.add(new Segment(map.points.get(3), map.points.get(0)));

        // Polygon #1
        map.segments.add(new Segment(map.points.get(4), map.points.get(5)));
        map.segments.add(new Segment(map.points.get(5), map.points.get(6)));
        map.segments.add(new Segment(map.points.get(6), map.points.get(7)));
        map.segments.add(new Segment(map.points.get(7), map.points.get(4)));

        // Polygon #2
        map.segments.add(new Segment(map.points.get(8), map.points.get(9)));
        map.segments.add(new Segment(map.points.get(9), map.points.get(10)));
        map.segments.add(new Segment(map.points.get(10), map.points.get(8)));

        // Polygon #3
        map.segments.add(new Segment(map.points.get(11), map.points.get(12)));
        map.segments.add(new Segment(map.points.get(12), map.points.get(13)));
        map.segments.add(new Segment(map.points.get(13), map.points.get(14)));
        map.segments.add(new Segment(map.points.get(14), map.points.get(11)));

        // Polygon #4
        map.segments.add(new Segment(map.points.get(15), map.points.get(16)));
        map.segments.add(new Segment(map.points.get(16), map.points.get(17)));
        map.segments.add(new Segment(map.points.get(17), map.points.get(15)));

        // Polygon #5
        map.segments.add(new Segment(map.points.get(18), map.points.get(19)));
        map.segments.add(new Segment(map.points.get(19), map.points.get(20)));
        map.segments.add(new Segment(map.points.get(20), map.points.get(21)));
        map.segments.add(new Segment(map.points.get(21), map.points.get(18)));

        // Polygon #6
        map.segments.add(new Segment(map.points.get(22), map.points.get(23)));
        map.segments.add(new Segment(map.points.get(23), map.points.get(24)));
        map.segments.add(new Segment(map.points.get(24),map.points.get(22)));
    }

    public static void main(String[] args) {
        new Raycasting();
    }

}

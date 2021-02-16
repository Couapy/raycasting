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
        // Border
        map.segments.add(new Segment(new Point(0d, 0d), new Point(640d, 0d)));
        map.segments.add(new Segment(new Point(640d, 0d), new Point(640d, 360d)));
        map.segments.add(new Segment(new Point(640d, 360d), new Point(0d, 360d)));
        map.segments.add(new Segment(new Point(0d, 360d), new Point(0d, 0d)));

        // Polygon #1
        map.segments.add(new Segment(new Point(100d, 150d), new Point(120d, 50d)));
        map.segments.add(new Segment(new Point(120d, 50d), new Point(200d, 80d)));
        map.segments.add(new Segment(new Point(200d, 80d), new Point(140d, 210d)));
        map.segments.add(new Segment(new Point(140d, 210d), new Point(100d, 150d)));

        // Polygon #2
        map.segments.add(new Segment(new Point(100d, 200d), new Point(120d, 250d)));
        map.segments.add(new Segment(new Point(120d, 250d), new Point(60d, 300d)));
        map.segments.add(new Segment(new Point(60d, 300d), new Point(100d, 200d)));

        // Polygon #3
        map.segments.add(new Segment(new Point(200d, 260d), new Point(220d, 150d)));
        map.segments.add(new Segment(new Point(220d, 150d), new Point(300d, 200d)));
        map.segments.add(new Segment(new Point(300d, 200d), new Point(350d, 320d)));
        map.segments.add(new Segment(new Point(350d, 320d), new Point(200d, 260d)));

        // Polygon #4
        map.segments.add(new Segment(new Point(340d, 60d), new Point(360d, 40d)));
        map.segments.add(new Segment(new Point(360d, 40d), new Point(370d, 70d)));
        map.segments.add(new Segment(new Point(370d, 70d), new Point(340d, 60d)));

        // Polygon #5
        map.segments.add(new Segment(new Point(450d, 190d), new Point(560d, 170d)));
        map.segments.add(new Segment(new Point(560d, 170d), new Point(540d, 270d)));
        map.segments.add(new Segment(new Point(540d, 270d), new Point(430d, 290d)));
        map.segments.add(new Segment(new Point(430d, 290d), new Point(450d, 190d)));

        // Polygon #6
        map.segments.add(new Segment(new Point(400d, 95d), new Point(580d, 50d)));
        map.segments.add(new Segment(new Point(580d, 50d), new Point(480d, 150d)));
        map.segments.add(new Segment(new Point(480d, 150d), new Point(400d, 95d)));
    }

    public static void main(String[] args) {
        new Raycasting();
    }

}

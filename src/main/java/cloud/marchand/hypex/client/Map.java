package cloud.marchand.hypex.client;

import java.util.ArrayList;
import java.util.List;

public class Map {

    public List<Point> points;
    public List<Segment> segments;

    public Map() {
        points = new ArrayList<>();
        segments = new ArrayList<>();
    }

    public Map(List<Point> points, List<Segment> segments) {
        this.points = points;
        this.segments = segments;
    }

}
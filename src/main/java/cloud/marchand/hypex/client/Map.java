package cloud.marchand.hypex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import cloud.marchand.hypex.client.util.FileUtil;

public class Map {

    public List<Point> points;
    public List<Segment> segments;

    protected Map() {
        points = new ArrayList<>();
        segments = new ArrayList<>();
    }

    public Map(List<Point> points, List<Segment> segments) {
        this.points = points;
        this.segments = segments;
    }

    public static Map fromFile(String filepath) throws IOException {
        String content = FileUtil.readFile(filepath);
        Map map = new Map();

        String[] lines = content.split("\n");

        for (int i = 0; i < lines.length; i++) {
            String[] line = lines[i].split(":");
            String indicator = line[0];
            String[] arguments = line[1].split(";");
            if (indicator.equals("p")) {
                map.points.add(new Point(Integer.parseInt(arguments[0]), Integer.parseInt(arguments[1])));
            } else if (indicator.equals("s")) {
                map.segments.add(new Segment(map.points.get(Integer.parseInt(arguments[0])),
                        map.points.get(Integer.parseInt(arguments[1]))));
            }
        }

        return map;
    }

}
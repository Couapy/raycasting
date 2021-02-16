package cloud.marchand.hypex.client;

import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Raycasting extends JFrame {

    private Canvas canvas;

    private Map map;

    public Raycasting() {
        try {
            map = Map.fromFile("map.txt");
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        setSize(new Dimension(960, 720));
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        canvas = new Canvas(map);
        add(canvas);
    }

    public static void main(String[] args) {
        new Raycasting();
    }

}

package cloud.marchand.hypex.client;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.JFrame;

import cloud.marchand.hypex.client.listener.KeyBoardListener;
import cloud.marchand.hypex.client.listener.MouseListener;

@SuppressWarnings("serial")
public class App extends JFrame implements Runnable {

    private Canvas canvas;

    private Map map;

    public Pov pov;

    public java.util.Map<Integer, Boolean> keyboard = new HashMap<>();

    public App() {
        try {
            map = Map.fromFile("map.txt");
            pov = new Pov(320, 180, -Math.PI / 3);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        setSize(new Dimension(960, 720));
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        canvas = new Canvas(map, pov);
        add(canvas);

        addKeyListener(new KeyBoardListener(this));
        addMouseMotionListener(new MouseListener(this));

        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        double velocity = 4;
        double angleVelocity = 0.1;
        while (isVisible()) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                setVisible(false);
                e.printStackTrace();
            }
            if (Boolean.TRUE.equals(keyboard.get(KeyEvent.VK_Z))) {
                pov.x += Math.cos(pov.angle) * velocity;
                pov.y += Math.sin(pov.angle) * velocity;
            }
            if (Boolean.TRUE.equals(keyboard.get(KeyEvent.VK_S))) {
                pov.x -= Math.cos(pov.angle) * velocity;
                pov.y -= Math.sin(pov.angle) * velocity;
            }
            if (Boolean.TRUE.equals(keyboard.get(KeyEvent.VK_Q))) {
                pov.x += Math.sin(pov.angle) * velocity;
                pov.y -= Math.cos(pov.angle) * velocity;
            }
            if (Boolean.TRUE.equals(keyboard.get(KeyEvent.VK_D))) {
                pov.x -= Math.sin(pov.angle) * velocity;
                pov.y += Math.cos(pov.angle) * velocity;
            }
            if (Boolean.TRUE.equals(keyboard.get(KeyEvent.VK_J))) {
                pov.angle += angleVelocity;
            }
            if (Boolean.TRUE.equals(keyboard.get(KeyEvent.VK_M))) {
                pov.angle -= angleVelocity;
            }
            revalidate();
            repaint();
        }
    }

    public static void main(String[] args) {
        new App();
    }

}

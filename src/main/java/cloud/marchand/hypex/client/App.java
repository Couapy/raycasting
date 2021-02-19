package cloud.marchand.hypex.client;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;

import cloud.marchand.hypex.client.listener.KeyBoardListener;
import cloud.marchand.hypex.client.listener.MouseListener;

@SuppressWarnings("serial")
public class App extends JFrame implements Runnable {

    protected JPanel canvas;

    protected Map map;

    public Pov pov;

    public java.util.Map<Integer, Boolean> keyboard = new HashMap<>();

    public App() {
        try {
            map = Map.fromFile("maps/map.txt");
            if (map.origin != null) {
                pov = new Pov(map.origin);
            }
            else {
                pov = new Pov(0d, 0d, -Math.PI / 3, Math.PI / 3);
            }
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
        while (isVisible()) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                setVisible(false);
                e.printStackTrace();
            }
            handleMovements();
            revalidate();
            repaint();
        }
    }

    private void handleMovements() {
        double velocity = 1;
        double angleVelocity = 0.02;
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
            double angle = pov.angle - angleVelocity;
            pov.angle = Math.atan2(Math.sin(angle), Math.cos(angle));
        }
        if (Boolean.TRUE.equals(keyboard.get(KeyEvent.VK_M))) {
            double angle = pov.angle + angleVelocity;
            pov.angle = Math.atan2(Math.sin(angle), Math.cos(angle));
        }
        if (Boolean.TRUE.equals(keyboard.get(KeyEvent.VK_ESCAPE))) {
            System.exit(0);
        }
    }


    public static void main(String[] args) {
        new App();
    }

}

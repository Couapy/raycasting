package cloud.marchand.hypex.client;

@SuppressWarnings("serial")
public class App3D extends App {

    public App3D(Map map, Pov pov, java.util.Map<Integer, Boolean> keyboard) {
        super();

        this.map = map;
        this.pov = pov;
        this.keyboard = keyboard;

        remove(canvas);
        canvas = new Canvas3D(map, pov);
        add(canvas);
    }

    public static void main(String[] args) {
        App app2D = new App();
        new App3D(app2D.map, app2D.pov, app2D.keyboard);
        // app2D.setVisible(false);
    }

}

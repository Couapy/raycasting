package cloud.marchand.hypex.client.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import cloud.marchand.hypex.client.App;

public class MouseListener implements MouseMotionListener {

    private App app;

    public MouseListener(App app) {
        this.app = app;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        updateMouse(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // updateMouse(e);
    }
    
    private void updateMouse(MouseEvent e) {
        app.pov.x = e.getX();
        app.pov.y = e.getY();
    }
    
}

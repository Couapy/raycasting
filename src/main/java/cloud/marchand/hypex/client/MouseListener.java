package cloud.marchand.hypex.client;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseListener implements MouseMotionListener {

    private Canvas canvas;

    public MouseListener(Canvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        updateMouse(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        updateMouse(e);
    }
    
    private void updateMouse(MouseEvent e) {
        if (canvas.mouse == null) {
            canvas.mouse = new Point(0d, 0d);
        }
        canvas.mouse.x = e.getX();
        canvas.mouse.y = e.getY();

        canvas.revalidate();
        canvas.repaint();
    }
    
}

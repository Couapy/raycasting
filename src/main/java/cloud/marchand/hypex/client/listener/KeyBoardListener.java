package cloud.marchand.hypex.client.listener;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import cloud.marchand.hypex.client.App;

public class KeyBoardListener extends KeyAdapter {

    private App app; 

    public KeyBoardListener(App app) {
        this.app = app;
	}

    @Override
    public void keyPressed(KeyEvent e) {
        app.keyboard.put(e.getKeyCode(), Boolean.TRUE);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        app.keyboard.put(e.getKeyCode(), Boolean.FALSE);
    }
    
}

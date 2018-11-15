package GUI;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Clavier  implements KeyListener{
    private final static int numTouches = 120;
    private final boolean[] touches = new boolean[numTouches];
    
    public boolean up, down, left, right;
    
    public void update(){
        up = touches[KeyEvent.VK_W];
        down = touches[KeyEvent.VK_S];
        left = touches[KeyEvent.VK_A];
        right = touches[KeyEvent.VK_D];
    }
    
    
    
    @Override
    public void keyTyped(KeyEvent e) {
        }

    @Override
    public void keyPressed(KeyEvent e) {
        touches[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        touches[e.getKeyCode()] = false;
    }
    
}

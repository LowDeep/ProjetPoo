/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Alex Molinares
 */
public class Clavier  implements KeyListener{
    private final static int numTouches = 120;
    private static final boolean[] touches = new boolean[numTouches];
    
    public static boolean up, down, left, right;
    
    public static void update(){
        up = touches[KeyEvent.VK_Z];
        down = touches[KeyEvent.VK_S];
        left = touches[KeyEvent.VK_Q];
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
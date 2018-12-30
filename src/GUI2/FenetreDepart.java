/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI2;

import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author dioxo
 */
public class FenetreDepart extends  JFrame{
    private final int WIDTH = 790, HEIGHT = 600;

    public FenetreDepart() {
        setBackground(Color.yellow);
        setTitle("Les aventures de Taha");
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
    
    }
    
    
    
}

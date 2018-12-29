/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI2;

import javax.swing.JFrame;

/**
 *
 * @author dioxo
 */
public class Fenetre extends JFrame{

    private final int WIDTH=790, HEIGHT=600;
    private TableauJeu tableauJeu;
    
    public Fenetre() {
        setTitle("Les aventures de Taha");
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        tableauJeu = new TableauJeu();
        add(tableauJeu);
    }
    
    
}

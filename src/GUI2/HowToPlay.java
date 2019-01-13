/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI2;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import java.awt.Rectangle;

/**
 *
 * @author dioxo
 */
public class HowToPlay extends JFrame {
    private final int WIDTH = 790, HEIGHT = 600;
    Thread2 thread2;
    HowToPlayPanel panel;
    
     
    public HowToPlay(){
        setTitle("Les aventures de Mr Rick");
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        panel =  new  HowToPlayPanel();
        
        
        JLabel lblMedecin = new JLabel("<html>Le medecin, te mets tous tes points de vie au maximum</html>");
        lblMedecin.setBounds(150, 50, 400, 100);
        lblMedecin.setFont(new Font("Arial", 2, 25));
        
        
        JLabel lblMagicien = new JLabel("<html>Le magicien, te donne une armure contre les ennemis</html>");
        lblMagicien.setBounds(150, 150, 400, 100);
        lblMagicien.setFont(new Font("Arial", 2, 25));
        
        
        JLabel lblCuisinier = new JLabel("<html>La cuisiniere, te cuisine de bons plats pour regenerer ta force</html>");
        lblCuisinier.setBounds(150, 250, 400, 100);
        lblCuisinier.setFont(new Font("Arial", 2, 25));
        
        JLabel lblJoueur = new JLabel("<html>Le joueur se deplace avec les touches UP,DOWN,LEFT,RIGHT</html>");
        lblJoueur.setBounds(150, 350, 400, 100);
        lblJoueur.setFont(new Font("Arial", 2, 25));
        
        getContentPane().add(lblMedecin);
        getContentPane().add(lblMagicien);
        getContentPane().add(lblCuisinier);
        getContentPane().add(lblJoueur);
        
        getContentPane().add(panel);
        
        JButton continuer = new JButton("Jouer");
        panel.add(continuer);
        continuer.setBounds(600, 550, 200, 20);
        
        continuer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);

                Fenetre fenetre = new Fenetre();
                fenetre.setVisible(true);
                fenetre.setDefaultCloseOperation(EXIT_ON_CLOSE);
            }
        });
        
        
        
    }
    
    
    
}

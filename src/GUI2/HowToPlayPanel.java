/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI2;

import codeJeu.Cuisinier;
import codeJeu.Joueur;
import codeJeu.Magicien;
import codeJeu.Medecin;
import codeJeu.Monstre;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author dioxo
 */
class HowToPlayPanel extends JPanel{
    Cuisinier cuisinier;
    Magicien magicien;
    Medecin medecin;
    Joueur joueur;
    Monstre monstreGhost;
    Monstre monstreMinotaure;
    
    
    public HowToPlayPanel() {
        setPreferredSize(new Dimension(790, 600));
        //setBackground(Color.BLACK);
        
        medecin = new Medecin(100, 50);
        magicien = new Magicien(100, 160);
        cuisinier = new Cuisinier(100,260);
        joueur = new Joueur(95, 350);
        
        joueur.PlayerAnimationDown.runAnimation();

    }

    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.red);
        Graphics2D g2 = (Graphics2D) g;
        //g2.fill(new Rectangle2D.Double(0, 0, 40, 30));

        dessiner(g2);
        //actualiser(g2);
        
    }

    private void dessiner(Graphics2D g2) {
        //Dessiner personnages
        cuisinier.dessiner(g2);
        magicien.dessiner(g2);
        medecin.dessiner(g2);
        joueur.dessiner(g2);
    }
    
}

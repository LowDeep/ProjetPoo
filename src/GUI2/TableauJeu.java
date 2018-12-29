/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI2;

import GUI.Clavier;
import codeJeu.Joueur;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author dioxo
 */
public class TableauJeu extends JPanel {

    private final String bgRoute = "/bg.png";
    Image bg;
    Joueur joueur;

    TableauJeu() {


        try {
            bg = ImageIO.read(TableauJeu.class.getResource(bgRoute));
            //perso =  ImageIO.read(TableauJeu.class.getResource(persoRoute));
            //bg = ImageIO.read(new File("/home/dioxo/Documentos/Universidad/ProjetPoo/src/res/bg.png"));
        } catch (IOException exc) {
            exc.printStackTrace();
        }
        setPreferredSize(new Dimension(790, 600));
        setBackground(Color.WHITE);

        joueur = new Joueur(getWidth() / 2, getHeight() / 2);
        joueur = new Joueur(200, 500);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
        try {
            dessiner(g2);
            actualiser();
            //g2D.drawImage(perso, getWidth() /2  , getHeight() /2, 90, 69, this);
        } catch (IOException ex) {
            Logger.getLogger(TableauJeu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void dessiner(Graphics2D g2) throws IOException {
        /*System.out.println("Person X: " + joueur.getX());       
        System.out.println("Person Y: " + joueur.getY());*/
        g2.drawImage(joueur.getPerso(), joueur.getX(), joueur.getY(), joueur.getHEIGHT(), joueur.getWIDHT(), this);
    }

    public void actualiser() {
        //System.out.println("ACTUALISER");
        Clavier.update();
        joueur.seDeplacer();
        //System.out.println("bounds " + getBounds());
        //System.out.println("position y : " + joueur.getY());
        /*
        clavier.update();
        if (clavier.up) {
            System.out.println("UPPPPPPPPPP");
        }
        if (clavier.down) {
            System.out.println("down");

        }
        if (clavier.left) {
            System.out.println("left");
        }
        if (clavier.right) {
            System.out.println("UPPPPPPPPPP");
        }
            */
    }
    

}

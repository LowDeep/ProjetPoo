/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import GUI.Clavier;
import codeJeu.ConstantesDeJeu;
import codeJeu.Cuisinier;
import codeJeu.Joueur;
import codeJeu.Magicien;
import codeJeu.Medecin;
import codeJeu.Monstre;
import codeJeu.Piece;
import codeJeu.Porte;

/**
 *
 * @author dioxo
 */
public class TableauJeu extends JPanel {

    private final String bgRoute = "/bg.png";
    Image bg;
    Joueur joueur;

    Cuisinier cuisinier;
    Magicien magicien;
    Medecin medecin;

    Porte porteOuverte;
    Porte porteOuverteBas;
    Porte porteOuverteDroite;
    Porte porteOuverteGauche;
    
    Piece passageSecretFirst;
    Piece passageSecretSecond;
    
    //porte porteFermee;


    Monstre monstreGhost;
    Monstre monstreMinotaure;


    /*
    TEMP
     */
    Enemi enemi;
    BufferedImageLoader loader = new BufferedImageLoader();
    static Texture texture;
    int tempX = 0, tempY = 0;

    TableauJeu() {

        bg = loader.loadImage(bgRoute);
        texture = new Texture();
        /*try {
            bg = ImageIO.read(TableauJeu.class.getResource(bgRoute));
            //perso =  ImageIO.read(TableauJeu.class.getResource(persoRoute));
            //bg = ImageIO.read(new File("/home/dioxo/Documentos/Universidad/ProjetPoo/src/res/bg.png"));
        } catch (IOException exc) {
            exc.printStackTrace();
        }*/
        setPreferredSize(new Dimension(790, 600));
        setBackground(Color.WHITE);
        enemi = new Enemi(0, 0);
        joueur = new Joueur(790 / 2, 600 / 2);

        cuisinier = new Cuisinier(300, 300);
        magicien = new Magicien(200, 300);
        medecin = new Medecin(100, 300);

        porteOuverte = new Porte(350,1);
        porteOuverteBas = new Porte(350,499);
        porteOuverteDroite = new Porte(719,250);
        porteOuverteGauche= new Porte(1,250);


        monstreGhost = new Monstre(100, 100, 50, 20, 1);
        monstreMinotaure = new Monstre(500, 500, 50, 20, 0);
        
        passageSecretFirst = new Piece(true);
        passageSecretSecond = new Piece(true);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        //Dessiner escenaire
        g2.drawImage(bg, 0, 0, getWidth(), getHeight(), this);

        //Set color transparent pour les hit Boxs
        g2.setColor(new Color(255,255, 255));

        joueur.PlayerAnimationDown.runAnimation();
        joueur.PlayerAnimationUp.runAnimation();
        joueur.PlayerAnimationLeft.runAnimation();
        joueur.PlayerAnimationRight.runAnimation();
        
        monstreGhost.MonstreAnimationDown.runAnimation();
        monstreGhost.MonstreAnimationLeft.runAnimation();
        monstreGhost.MonstreAnimationRight.runAnimation();
        monstreGhost.MonstreAnimationUp.runAnimation();

        monstreMinotaure.MonstreAnimationDown.runAnimation();
        monstreMinotaure.MonstreAnimationLeft.runAnimation();
        monstreMinotaure.MonstreAnimationRight.runAnimation();
        monstreMinotaure.MonstreAnimationUp.runAnimation();
        
        try {
            dessiner(g2);
            actualiser(g2);
            //g2D.drawImage(perso, getWidth() /2  , getHeight() /2, 90, 69, this);
        } catch (IOException ex) {
            Logger.getLogger(TableauJeu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void dessiner(Graphics2D g2) throws IOException {
        //Creer les hitbox du personnages
        g2.fill(joueur.getHitBox());
        g2.fill(cuisinier.getHitBox());
        g2.fill(magicien.getHitBox());
        g2.fill(medecin.getHitBox());
        g2.fill(porteOuverte.getHitBox());
        g2.fill(porteOuverteBas.getHitBox());
        g2.fill(porteOuverteDroite.getHitBox());
        g2.fill(porteOuverteGauche.getHitBox());
        g2.fill(monstreGhost.getHitBox());
        g2.fill(monstreMinotaure.getHitBox());
        g2.fill(passageSecretFirst.getHitBoxFirst());
        g2.fill(passageSecretSecond.getHitBoxSecond());


        //g2.drawImage(joueur.getPerso(), joueur.getX(), joueur.getY(), joueur.getHEIGHT(), joueur.getWIDHT(), this);
        //Dessinner personnages
        cuisinier.dessiner(g2);
        magicien.dessiner(g2);
        medecin.dessiner(g2);
        porteOuverte.dessiner(g2);
        porteOuverteBas.dessinerBas(g2);
        porteOuverteDroite.dessinerDroite(g2);
        porteOuverteGauche.dessinerGauche(g2);
        passageSecretFirst.dessinerFirst(g2);
        passageSecretSecond.dessinerSecond(g2);
        
        
        g2.setColor(Color.red);
        g2.fill(enemi.getEnemi());

    }

    public void actualiser(Graphics2D g2) {
        Clavier.update();

        joueur.seDeplacer(g2);
        //enemi.seDeplacer2(getBounds(), collisionVie(joueur), joueur.getX(), joueur.getY());
        monstreGhost.chercherJoueur(g2,joueur.getX(), joueur.getY());
        monstreMinotaure.chercherJoueur(g2,joueur.getX(), joueur.getY());

        confirmations();

    }

    /**
     * methode fin jeu consiste a afficher un message de fin du jeu avec bouton
     * pour recommencer
     */
    private void endGame() {

        Fenetre.thread.stop();

        // TODO Auto-generated method stub
        /*try {
			Fenetre.thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
        JOptionPane jop1;
        String choices[] = {"Fermer le jeu"};
        jop1 = new JOptionPane();
        /*jop1.showConfirmDialog(null, "Vous avez perdu!", "LOOOSER:)", 
        JOptionPane.YES_NO_OPTION, 
        JOptionPane.QUESTION_MESSAGE);*/
        int i = 0;
        //System.out.println(i);
        jop1.showOptionDialog(this, "Vous avez perdu! ", "LOOOOOSER !", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
        i = JOptionPane.DEFAULT_OPTION;
        //actionPerformed(jop1);
        //System.out.println(i);
        if (i != 0) {

            //setVisible(false);
            //FenetreDepar fenetreDep = new FenetreDepar();
            //fenetreDep.setVisible(true);
            //fenetreDep.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            System.exit(0);

        }
    }

    public boolean collision(Rectangle2D r) {
        return enemi.getEnemi().intersects(r);
    }

    public static Texture getInstance() {
        return texture;
    }

    public boolean collision(Joueur joueur) {
        return enemi.getEnemi().intersects(joueur.getHitBox());
    }

    //getter joueur
    public Joueur getJoueur() {
        return joueur;
    }
    //methode pour si il y a collision 

    public boolean collisionVie(Joueur joueur) {
        if (collision(joueur)) {
            if (Joueur.getArmure() > 0) {
                joueur.setArmure(joueur.getArmure() - 1);
            } else {
                joueur.setPdv(joueur.getPdv() - 1);;
            }
        }
        fenetreObjets.getProgbarArmure().getProgressBar().setValue(joueur.getArmure());
        fenetreObjets.getProgbarVie().getProgressBar().setValue(joueur.getPdv());

        //System.out.println(joueur.getPdv());
        return collision(joueur);
    }

    public void collisionMedecin(Joueur joueur) {
        if (medecin.getHitBox().intersects(joueur.getHitBox())) {
            joueur.setPdv(ConstantesDeJeu.PDVMAX);
        }
    }

    public void collisionCuisinier(Joueur joueur) {
        if (cuisinier.getHitBox().intersects(joueur.getHitBox())) {
            joueur.setForce(ConstantesDeJeu.FORCEMAX);
        }
    }
    public void collisionMagicien(Joueur joueur) {
        if (magicien.getHitBox().intersects(joueur.getHitBox())) {
            magicien.recuperationDoom(joueur);
        }
    }
    
    public void collisionPorteOuverteHaut(Joueur joueur) {
    	//System.out.println("collision non");
        if (porteOuverte.getHitBox().intersects(joueur.getHitBox())) {
           //joueur doit passer en bas 
        	joueur.setX(345);
        	joueur.setY(435);
        	//System.out.println("collision ok");
        }
    }
    
    public void collisionPorteOuverteBas(Joueur joueur) {
    	//System.out.println("collision non");
        if (porteOuverteBas.getHitBox().intersects(joueur.getHitBox())) {
           //joueur doit passer en bas 
        	joueur.setX(350);
        	joueur.setY(65);
        	//System.out.println("collision ok");
        }
    }
    
    public void collisionPorteOuverteDroite(Joueur joueur) {
    	//System.out.println("collision non");
        if (porteOuverteDroite.getHitBox().intersects(joueur.getHitBox())) {
           //joueur doit passer en bas 
        	joueur.setX(66);
        	joueur.setY(250);
        	//System.out.println("collision ok");
        }
    }
    
    public void collisionPorteOuverteGauche(Joueur joueur) {
    	//System.out.println("collision non");
        if (porteOuverteGauche.getHitBox().intersects(joueur.getHitBox())) {
           //joueur doit passer en bas 
        	joueur.setX(650);
        	joueur.setY(250);
        	//System.out.println("collision ok");
        }
    }

    public void collisionPassageSecretFirst(Joueur joueur)
    {
    	if(passageSecretFirst.getHitBoxFirst().intersects(joueur.getHitBox()))
    	{
    		joueur.setX(595);
    		joueur.setY(410);
    	}
    }
    public void collisionPassageSecretSecond(Joueur joueur)
    {
    	if(passageSecretFirst.getHitBoxSecond().intersects(joueur.getHitBox()))
    	{
    		joueur.setX(60);
    		joueur.setY(120);
    	}
    }
    private void confirmations() {
        collisionMedecin(joueur);
        collisionCuisinier(joueur);
        collisionMagicien(joueur);
        collisionPorteOuverteHaut(joueur);
        collisionPorteOuverteBas(joueur);
        collisionPorteOuverteGauche(joueur);
        collisionPorteOuverteDroite(joueur);
        collisionPassageSecretFirst(joueur);
        collisionPassageSecretSecond(joueur);
        if (joueur.getPdv() == 0) {
            endGame();
        }
    }
}

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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.security.auth.callback.ConfirmationCallback;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import codeJeu.Cuisinier;
import codeJeu.Joueur;
import codeJeu.Magicien;
import codeJeu.Medecin;
import codeJeu.Monstre;
import codeJeu.Personnage;
import codeJeu.Piece;
import codeJeu.Princesse;

/**
 *
 * @author dioxo
 */
public class TableauJeu extends JPanel {

    private final String bgRoute = "/bg.png";
    Image bg;
    BufferedImageLoader loader = new BufferedImageLoader();
    static Texture texture;

    //static Piece piece;

    /*Joueur joueur;

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



    Enemi enemi;*/
    //Creation de 2 pieces
    static Piece piece1;
    static Piece piece2;

    //Creation des pieces pour dessiner la piece selon la piece qui contient le personnage
    static int piecesY = 4, piecesX = 5;
    
    
    public static int positionPiecePersonnageX = 0;
    public static int positionPiecePersonnageY= 0;

    static Piece[][] pieces = new Piece[piecesY][piecesX];
    
    static Piece pieceFinale;
    
    static Map map = new Map();

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

        //creation de pieces
        Joueur joueur = new Joueur(790 / 2, 600 / 2);
        Monstre monstreGhost = new Monstre(100, 100, 5, 5, 1);
        Monstre monstreMinotaure = new Monstre(100, 100, 5, 5, 2);
        Cuisinier cuisinier = new Cuisinier(300, 300);
        Medecin medecin = new Medecin(200, 300);
        Monstre monstreDEUX = new Monstre(300, 300, 10, 10, 0);
        

        Princesse princesse = new Princesse(200, 200);

        //joueur.setPdv(joueur.getPdv()+10);
        List<Personnage> personnagesP1 = new ArrayList<Personnage>();
        personnagesP1.add(joueur);
        personnagesP1.add( monstreMinotaure);
        //personnages.add(monstreGhost);
        //personnages.add(cuisinier);
        //personnages.add(medecin);
        //personnages.add(princesse);
        //personnages.add(arg0)
        //piece = new Piece(true, true, true, true, true, personnages);

        List<Personnage> personnagesP2 = new ArrayList<Personnage>();
        personnagesP2.add(joueur);
        personnagesP2.add(monstreGhost);
        personnagesP2.add(monstreDEUX);
        personnagesP2.add(new Magicien(300, 300));

        piece1 = new Piece(false, false, true, false, false, personnagesP1);
        piece2 = new Piece(false, false, false, true, false, personnagesP2);

        pieces[0][0] = piece1;
        pieces[0][1] = piece2;

        //Initialiser le personnage dans la piece en haute et bas
        /*
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
         */
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        //Dessiner escenaire
        g2.drawImage(bg, 0, 0, getWidth(), getHeight(), this);

        //Set color transparent pour les hit Boxs
  


        g2.setColor(new Color(255,255, 255,0));

        //temp
        //piece.dessinerComponents(g2);
        /*
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
         */
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
        /*g2.fill(joueur.getHitBox());
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
<<<<<<< HEAD
*/
    	
    	


        //Selon la piece qui est le personnage, on va la dessiner
        pieces[positionPiecePersonnageX][positionPiecePersonnageY].dessinerComponents(g2);
        
        dessinerMap(g2);
 
    }

    /**
	 * 
	 */
	private void dessinerMap(Graphics2D g2) {
		map.dessinerMap(g2);
	}

	public void actualiser(Graphics2D g2) {
        //Clavier.update();
        //piece.actualiser(g2);
        
        //Selon la piece qui est le personnage, on va la dessiner
        pieces[positionPiecePersonnageX][positionPiecePersonnageY].actualiser(g2);
        map.changerCouleurPiece(g2, positionPiecePersonnageX, positionPiecePersonnageY);
        
        /*joueur.seDeplacer(g2);
        //enemi.seDeplacer2(getBounds(), collisionVie(joueur), joueur.getX(), joueur.getY());
        monstreGhost.chercherJoueur(g2,joueur.getX(), joueur.getY());
        monstreMinotaure.chercherJoueur(g2,joueur.getX(), joueur.getY());

        confirmations();
         */
        if (Piece.confirmationGagnerJeu) {
            endWinGame();
        }
        if (Piece.confirmationPerteJeu) {
            endFailureGame();
        }

    }

    /**
     * methode fin jeu consiste a afficher un message de fin du jeu avec bouton
     * pour recommencer
     */
    public void endFailureGame() {

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

    public void endWinGame() {

        Fenetre.thread.stop();

        // TODO Auto-generated method stub
        /*try {
			Fenetre.thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
        JOptionPane jop1;
        String choices[] = {"BRAVO!!"};
        jop1 = new JOptionPane();
        /*jop1.showConfirmDialog(null, "Vous avez perdu!", "LOOOSER:)", 
        JOptionPane.YES_NO_OPTION, 
        JOptionPane.QUESTION_MESSAGE);*/
        int i = 0;
        //System.out.println(i);
        jop1.showOptionDialog(this, "Vous avez gagner! Cliquez sur le bouton pour fermer le jeu :) ", "WIIIIIIINNER !", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
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

    public static Texture getInstance() {
        return texture;
    }

    //getter joueur
    /*public Joueur getJoueur() {
        return pieces[positionPiecePersonnageX][positionPiecePersonnageY].getJoueur();
    }*/

    /*
    public boolean collision(Rectangle2D r) {
        return enemi.getEnemi().intersects(r);
    }

    public static Texture getInstance() {
        return texture;
    }

    public boolean collision(Joueur joueur) {
        return enemi.getEnemi().intersects(joueur.getHitBox());
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
            endFailureGame();
        }
    }*/
    public Piece getPiece() {
        return pieces[positionPiecePersonnageX][positionPiecePersonnageY];
    }
}

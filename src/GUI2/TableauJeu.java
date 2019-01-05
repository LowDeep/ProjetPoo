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
    static Piece piece3;
    static Piece piece4;
    static Piece piece5;
    static Piece piece6;
    static Piece piece7;
    static Piece piece8;
    static Piece piece9;
    static Piece piece10;
    static Piece piece11;
    static Piece piece12;
    static Piece piece13;
    static Piece piece14;
    static Piece piece15;
    static Piece piece16;
    static Piece piece17;
    static Piece piece18;
    static Piece piece19;
    static Piece piece20Final;

    //Creation des pieces pour dessiner la piece selon la piece qui contient le personnage
    static int piecesY = 4, piecesX = 5;
    
    
    public static int positionPiecePersonnageX = 0;
    public static int positionPiecePersonnageY= 0;

    static Piece[][] pieces = new Piece[piecesY][piecesX];
    

    
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

        Monstre monstreGhost1 = new Monstre(100, 100, 5, 5, 1);
        Monstre monstreGhost2 = new Monstre(400, 400, 5, 5, 1);
        Monstre monstreGhost3 = new Monstre(100, 100, 5, 5, 1);
        Monstre monstreGhost4 = new Monstre(100, 100, 5, 5, 1);
        Monstre monstreGhost5 = new Monstre(100, 100, 5, 5, 1);
        Monstre monstreGhost6 = new Monstre(100, 100, 5, 5, 1);
        Monstre monstreGhost7 = new Monstre(100, 100, 5, 5, 1);
        Monstre monstreGhost8 = new Monstre(100, 100, 5, 5, 1);
        Monstre monstreGhost9 = new Monstre(100, 100, 5, 5, 1);
        Monstre monstreGhost10 = new Monstre(100, 100, 5, 5, 1);
        Monstre monstreGhost11= new Monstre(100, 100, 5, 5, 1);
        Monstre monstreGhost12= new Monstre(400, 300, 5, 5, 1);
        Monstre monstreGhost13 = new Monstre(400, 400, 5, 5, 1);
        Monstre monstreGhost14= new Monstre(400, 400, 5, 5, 1);
        Monstre monstreGhost15 = new Monstre(400, 400, 5, 5, 1);
        
        Monstre monstreMinotaure2 = new Monstre(200, 100, 5, 5, 2);
        Monstre monstreMinotaure3 = new Monstre(400, 100, 5, 5, 2);
        Monstre monstreMinotaure4 = new Monstre(100, 300, 5, 5, 2);
        Monstre monstreMinotaure5 = new Monstre(200, 100, 5, 5, 2);
        Monstre monstreMinotaure6 = new Monstre(400, 100, 5, 5, 2);
        Monstre monstreMinotaure7 = new Monstre(300, 100, 5, 5, 2);
        Monstre monstreMinotaure8= new Monstre(100, 100, 5, 5, 2);
        Monstre monstreMinotaure9 = new Monstre(200, 200, 5, 5, 2);
        Monstre monstreMinotaure10 = new Monstre(100, 100, 5, 5, 2);
        Monstre monstreMinotaure11 = new Monstre(400, 400, 5, 5, 2);
        Monstre monstreMinotaure12 = new Monstre(300, 100, 5, 5, 2);
        Monstre monstreMinotaure16 = new Monstre(200, 400, 5, 5, 2);
        

        Monstre monstreGhost = new Monstre(100, 100, 5, 5, 1);
        Monstre monstreMinotaure = new Monstre(500, 250, 5, 5, 2);

        Cuisinier cuisinier = new Cuisinier(300, 300);
        Medecin medecin = new Medecin(200, 300);
        Monstre monstreMinotor = new Monstre(300, 300, 10, 10, 0);
        Magicien magicien = new Magicien(300,300);
        Princesse princesse = new Princesse(200, 200);
        

        //joueur.setPdv(joueur.getPdv()+10);

       

        //personnages.add(monstreGhost);
        //personnages.add(cuisinier);
        //personnages.add(medecin);
        //personnages.add(princesse);
        //personnages.add(arg0)
        //piece = new Piece(true, true, true, true, true, personnages);

        List<Personnage> JoueurMedecinCuisinierMagicien = new ArrayList<Personnage>();
        JoueurMedecinCuisinierMagicien.add(joueur);
        JoueurMedecinCuisinierMagicien.add(medecin);
        JoueurMedecinCuisinierMagicien.add(cuisinier);
        JoueurMedecinCuisinierMagicien.add(magicien);
        
        
        List<Personnage> JoueurMedecinCuisinier = new ArrayList<Personnage>();
        JoueurMedecinCuisinier.add(joueur);
        JoueurMedecinCuisinier.add(medecin);
        JoueurMedecinCuisinier.add(cuisinier);
        
        List<Personnage> JoueurDoubleGhost = new ArrayList<Personnage>();
        JoueurDoubleGhost.add(joueur);
        JoueurDoubleGhost.add(monstreGhost1);
        JoueurDoubleGhost.add(monstreGhost2);
       

        List<Personnage> JoueurDoubleGhostMinautore = new ArrayList<Personnage>();
        JoueurDoubleGhostMinautore.add(joueur);
        JoueurDoubleGhostMinautore.add(monstreGhost1);
        JoueurDoubleGhostMinautore.add(monstreGhost2);
        JoueurDoubleGhostMinautore.add(monstreMinotaure12);
        
        
        List<Personnage> JoueurGhostPos1 = new ArrayList<Personnage>();
        JoueurGhostPos1.add(joueur);
        JoueurGhostPos1.add(monstreGhost3);
        
        List<Personnage> JoueurGhostPos2 = new ArrayList<Personnage>();
        JoueurGhostPos2.add(joueur);
        JoueurGhostPos2.add(monstreGhost4);
        
        List<Personnage> JoueurGhostPos2Minautaure = new ArrayList<Personnage>();
        JoueurGhostPos2Minautaure.add(joueur);
        JoueurGhostPos2Minautaure.add(monstreGhost4);
        JoueurGhostPos2Minautaure.add(monstreMinotaure7);
        
        List<Personnage> JoueurGhostPos2Cuisinier = new ArrayList<Personnage>();
        JoueurGhostPos2Cuisinier.add(joueur);
        JoueurGhostPos2Cuisinier.add(monstreGhost5);
        JoueurGhostPos2Cuisinier.add(cuisinier);
        
        List<Personnage> JoueurGhostPos2Medecin = new ArrayList<Personnage>();
        JoueurGhostPos2Medecin.add(joueur);
        JoueurGhostPos2Medecin.add(monstreGhost6);
        JoueurGhostPos2Medecin.add(monstreGhost14);
        JoueurGhostPos2Medecin.add(medecin);
        
        List<Personnage> JoueurDoubleGhostMagicien = new ArrayList<Personnage>();
        JoueurDoubleGhostMagicien.add(joueur);
        JoueurDoubleGhostMagicien.add(monstreGhost8);
        JoueurDoubleGhostMagicien.add(monstreGhost13);
        JoueurDoubleGhostMagicien.add(magicien);
        
        List<Personnage> JoueurDoubleGhostPassageSecret = new ArrayList<Personnage>();
        JoueurDoubleGhostPassageSecret.add(joueur);
        JoueurDoubleGhostPassageSecret.add(monstreGhost7);
        JoueurDoubleGhostPassageSecret.add(monstreGhost15);
        JoueurDoubleGhostPassageSecret.add(magicien);
        
        List<Personnage> JoueurDoubleMinautore = new ArrayList<Personnage>();
        JoueurDoubleMinautore.add(joueur);
        JoueurDoubleMinautore.add(monstreMinotaure4);
        JoueurDoubleMinautore.add(monstreMinotaure8);
        
        List<Personnage> JoueurMinautore1 = new ArrayList<Personnage>();
        JoueurMinautore1.add(joueur);
        JoueurMinautore1.add(monstreMinotaure2);
        
        List<Personnage> JoueurMagicien = new ArrayList<Personnage>();
        JoueurMagicien.add(joueur);
        JoueurMagicien.add(magicien);
        
        List<Personnage> JoueurCuisinier = new ArrayList<Personnage>();
        JoueurCuisinier.add(joueur);
        JoueurCuisinier.add(cuisinier);
        
        List<Personnage> JoueurMedecin = new ArrayList<Personnage>();
        JoueurMedecin.add(joueur);
        JoueurMedecin.add(medecin);
        
        
        List<Personnage> JoueurDoubleMinoDoubleGhost = new ArrayList<Personnage>();
        JoueurDoubleMinoDoubleGhost.add(joueur);
        JoueurDoubleMinoDoubleGhost.add(monstreMinotaure6);
        JoueurDoubleMinoDoubleGhost.add(monstreMinotaure5);
        JoueurDoubleMinoDoubleGhost.add(monstreGhost9);
        JoueurDoubleMinoDoubleGhost.add(monstreGhost10);
        
        
        List<Personnage> JoueurDoubleMinoDoubleGhost2 = new ArrayList<Personnage>();
        JoueurDoubleMinoDoubleGhost2.add(joueur);
        JoueurDoubleMinoDoubleGhost2.add(monstreMinotaure16);
        JoueurDoubleMinoDoubleGhost2.add(monstreMinotaure);
        JoueurDoubleMinoDoubleGhost2.add(monstreGhost12);
        JoueurDoubleMinoDoubleGhost2.add(monstreGhost10);
        
        List<Personnage> JoueurDoubleMinoUnGhost = new ArrayList<Personnage>();
        JoueurDoubleMinoUnGhost.add(joueur);
        JoueurDoubleMinoUnGhost.add(monstreMinotaure11);
        JoueurDoubleMinoUnGhost.add(monstreMinotaure10);
        JoueurDoubleMinoUnGhost.add(monstreGhost11);
      
        List<Personnage> FinalSalle = new ArrayList<Personnage>();
        FinalSalle.add(joueur);
        FinalSalle.add(new Princesse(70, 70));
        FinalSalle.add(new Monstre(90, 80, 20, 10, 2));
        FinalSalle.add(new Monstre(500, 70, 20, 10, 1));
        
        
        
        /*
        List<Personnage> personnagesP6= new ArrayList<Personnage>();
        personnagesP6.add(joueur);
        personnagesP6.add(monstreGhost1);
        personnagesP6.add(monstreGhost2);
        
        List<Personnage> personnagesP7 = new ArrayList<Personnage>();
        personnagesP7.add(joueur);
        personnagesP7.add(monstreGhost1);
        personnagesP7.add(monstreGhost2);
        
        List<Personnage> personnagesP8 = new ArrayList<Personnage>();
        personnagesP8.add(joueur);
        personnagesP8.add(monstreGhost1);
        personnagesP8.add(monstreGhost2);
        
        List<Personnage> personnagesP9 = new ArrayList<Personnage>();
        personnagesP9.add(joueur);
        personnagesP9.add(monstreGhost1);
        personnagesP9.add(monstreGhost2);
        
        List<Personnage> personnagesP10 = new ArrayList<Personnage>();
        personnagesP10.add(joueur);
        personnagesP10.add(monstreGhost1);
        personnagesP10.add(monstreGhost2);
		*/
        
        
        
        
        //premiere ligne
        piece1 = new Piece(false, true, true, false, false, JoueurMedecinCuisinier);
        piece2 = new Piece(false, true, true, true, false, JoueurDoubleGhostMinautore);
        piece3 = new Piece(false,true,true,true,false,JoueurGhostPos1);
        piece4 = new Piece(false,true,true,true,false,JoueurGhostPos2Minautaure);
        piece5 = new Piece(false,true,false,true,false,JoueurDoubleMinautore);
        //duexieme ligne
        piece6 = new Piece(true,true,true,false,false,JoueurDoubleGhost);
        piece7 = new Piece(true,true,true,true,false,JoueurMinautore1);
        piece8 = new Piece(true,true,true,true,false,JoueurMedecinCuisinier);
        piece9 = new Piece(true,true,true,true,false,JoueurDoubleMinoUnGhost);
        piece10 = new Piece(true,true,false,true,false,JoueurMagicien);
        //troisieme ligne
        piece11 = new Piece(true,true,true,false,false,JoueurMedecin);
        piece12= new Piece(true,true,true,true,false,JoueurGhostPos2Minautaure);
        piece13 = new Piece(true,true,true,true,false,JoueurGhostPos2Cuisinier);
        piece14 = new Piece(true,true,true,true,false,JoueurGhostPos2);
        piece15 = new Piece(true,false,false,true,false,JoueurDoubleMinoDoubleGhost);
        //quatrieme ligne
        piece16 = new Piece(true,false,true,false,false,JoueurDoubleGhostPassageSecret);
        piece17= new Piece(true,false,true,true,true,JoueurDoubleMinoDoubleGhost2);
        piece18 = new Piece(true,false,true,true,false,JoueurGhostPos2Medecin);
        piece19 = new Piece(true,false,false,true,false,JoueurMagicien);
        piece20Final = new Piece(false,false,false,false,false,FinalSalle);

        
       
        //premiere ligne	
        pieces[0][0] = piece1;
        pieces[0][1] = piece2;
        pieces[0][2] = piece3;
        pieces[0][3] = piece4;
        pieces[0][4] = piece5;
        //deuxieme ligne
        pieces[1][0] = piece6;
        pieces[1][1] = piece7;
        pieces[1][2] = piece8;
        pieces[1][3] = piece9;
        pieces[1][4] = piece10;
        //troisieme ligne
        pieces[2][0] = piece11;
        pieces[2][1] = piece12;
        pieces[2][2] = piece13;
        pieces[2][3] = piece14;
        pieces[2][4] = piece15;
        //quatrieme ligne
        pieces[3][0] = piece16;
        pieces[3][1] = piece17;
        pieces[3][2] = piece18;
        pieces[3][3] = piece19;
        pieces[3][4] = piece20Final;
        

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

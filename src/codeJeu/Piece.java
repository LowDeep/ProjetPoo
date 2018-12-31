package codeJeu;

import GUI.Clavier;
import GUI2.Fenetre;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;

public class Piece {

    private boolean nord;
    private boolean sud;
    private boolean est;
    private boolean ouest;
    private Porte[] porte;

    private boolean passageSecret;

    private List<Personnage> personnages;

    //Creation de joueur pour pouvoir instances les deplacements des monstres selon le joueur
    private Joueur joueur;
    

    public Piece(boolean nord, boolean sud, boolean est, boolean ouest, boolean passageSecret,
            List<Personnage> personnage) {
        super();
        this.nord = nord;
        this.sud = sud;
        this.est = est;
        this.ouest = ouest;
        this.porte = new Porte[4];
        this.passageSecret = passageSecret;
        this.personnages = personnage;
    }
    //savoir si il y'a un passage secret 

    public boolean isPassageSecret() {
        return passageSecret;
    }

    //getters de portes
    /*public void transporterPersonnage() {
		
	}*/
    public List<Personnage> getPersonnage() {
        return personnages;
    }

    public void setPersonnage(List<Personnage> personnage) {
        this.personnages = personnage;
    }

    public boolean isNord() {
        return nord;
    }

    public boolean isSud() {
        return sud;
    }

    public boolean isEst() {
        return est;
    }

    public boolean isOuest() {
        return ouest;
    }

    public Porte[] getPorte() {
        return porte;
    }

    public int nombreMonstresDansLaPiece() {
        int nombreMonstres = 0;
        Iterator<Personnage> iterateur = personnages.iterator();
        while (iterateur.hasNext()) {
            Monstre personnage = (Monstre) personnages;
            if (personnage.getClass().equals("Monstre.java")) {
                nombreMonstres++;
            }
        }
        return nombreMonstres;
    }

    public void transporterPersonnage(Piece[][] toutesLesPieces) {
        for (int i = 0; i < toutesLesPieces.length; i++) {

            for (int j = 0; j < toutesLesPieces[i].length; j++) {
                //si dans la piece il y a un passage secret 
                if (toutesLesPieces[i][j].isPassageSecret()) {

                    //si le personnage principal n'est pas là
                    Iterator<Personnage> iter = personnages.iterator();
                    boolean isPer = false;
                    while (iter.hasNext()) {
                        Personnage per = iter.next();

                        if (per.getClass().equals("codeJeu.Joueur")) {
                            //le personnage principal est  dans la sale
                            isPer = true;
                        }

                    }

                    //changer coordonées x et y de personnagge
                    if (!isPer) {

                        //changerCoordonneesPersonnage();
                    }

                }

            }

        }
    }

    /*private void changerCoordonneesPersonnage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    public void dessinerComponents(Graphics2D g) {

        /*joueur.PlayerAnimationDown.runAnimation();
        joueur.PlayerAnimationUp.runAnimation();
        joueur.PlayerAnimationLeft.runAnimation();
        joueur.PlayerAnimationRight.runAnimation();*/
        Iterator<Personnage> iterator = personnages.iterator();

        while (iterator.hasNext()) {
            Personnage personnage = iterator.next();

            /*System.out.println(personnage.getClass());
            if (personnage.getClass().getName().equals("codeJeu.Joueur") || personnage.getClass().getName().equals("codeJeu.Monstre")) {
                System.out.println("c'est un monstre ou joueur");
            } else {
                System.out.println("AUTRE");

            }*/
            //DESINNER PERSONAGES AVEC ANIMATION
            if (personnage.getClass().getName().equals("codeJeu.Joueur")) {
                joueur = (Joueur) personnage;
                joueur.PlayerAnimationDown.runAnimation();
                joueur.PlayerAnimationUp.runAnimation();
                joueur.PlayerAnimationLeft.runAnimation();
                joueur.PlayerAnimationRight.runAnimation();
            }

            if (personnage.getClass().getName().equals("codeJeu.Monstre")) {
                Monstre monstre = (Monstre) personnage;
                monstre.MonstreAnimationDown.runAnimation();
                monstre.MonstreAnimationLeft.runAnimation();
                monstre.MonstreAnimationRight.runAnimation();
                monstre.MonstreAnimationUp.runAnimation();
            }

            //creer les hitboxs
            g.fill(personnage.getHitBox());

            //Dessiner Personnages immobiles
            if (!personnage.getClass().getName().equals("codeJeu.Monstre") || !personnage.getClass().getName().equals("codeJeu.Joueur")) {
                personnage.dessiner(g);
            }
        }
        
        
        dessinerPortes(g);

    }
    
    private void dessinerPortes(Graphics2D g) {
        if(isNord()){
           porte[0] = new Porte(350,0);
        }
        if(isSud()){
            porte[1] = new Porte(350,500);
        }
        if(isEst()){
            
        }
    }

    public void actualiser(Graphics2D g2) {
        Clavier.update();

        //bouger le joueur
        joueur.seDeplacer(g2);

        //Parcourir liste pour trouver les personnages qui sont monstres pour le faire bouger
        Iterator<Personnage> iterator = personnages.iterator();
        while (iterator.hasNext()) {
            Personnage personnage = iterator.next();

            //Bouger les monstres
            if (personnage.getClass().getName().equals("codeJeu.Monstre")) {
            }
        }

        confirmations();

    }

    private void confirmations() {
        collisionMedecin(joueur);
        collisionCuisinier(joueur);
        collisionMagicien(joueur);
        
        /*if (joueur.getPdv() == 0) {
            
        }*/
    }

    private void collisionMedecin(Joueur joueur) {
        Iterator<Personnage> iterator = personnages.iterator();

        while (iterator.hasNext()) {
            Personnage personnage = iterator.next();
            if (personnage.getClass().getName().equals("codeJeu.Medecin")) {
                Medecin medecin = (Medecin) personnage;
                //COllition avec le magicien
                if (medecin.getHitBox().intersects(joueur.getHitBox())) {
                    joueur.setPdv(ConstantesDeJeu.PDVMAX);
                }

            }
        }
    }

    private void collisionCuisinier(Joueur joueur) {
        Iterator<Personnage> iterator = personnages.iterator();

        while (iterator.hasNext()) {
            Personnage personnage = iterator.next();
            if (personnage.getClass().getName().equals("codeJeu.Cuisinier")) {
                Cuisinier cuisinier = (Cuisinier) personnage;
                //COllition avec le magicien
                if (cuisinier.getHitBox().intersects(joueur.getHitBox())) {
                    joueur.setForce(ConstantesDeJeu.FORCEMAX);
                }

            }
        }
    }

    private void collisionMagicien(Joueur joueur) {

        Iterator<Personnage> iterator = personnages.iterator();

        while (iterator.hasNext()) {
            Personnage personnage = iterator.next();
            if (personnage.getClass().getName().equals("codeJeu.Magicien")) {
                Magicien magicien = (Magicien) personnage;
                //COllition avec le magicien
                if (magicien.getHitBox().intersects(joueur.getHitBox())) {
                    magicien.recuperationDoom(joueur);
                }

            }
        }

    }

 

}

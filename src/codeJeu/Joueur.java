package codeJeu;

import GUI.Clavier;
import GUI2.TableauJeu;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.imageio.ImageIO;

public class Joueur extends JoueurActif implements KeyListener {

    /**
     *
     * Graphisme du personage
     *
     *
     */
    static Image perso;
    private final String persoRoute = "/perso.png";
    private final int HEIGHT = 90, WIDHT = 69;

    /**
     *
     * Variables du personage
     *
     *
     */
    private static int armure;
    private static final int QUANTITEOBJETS = 6;
    public ArrayList<Objet> listeObjets = new ArrayList<Objet>();
    private ConstantesDeJeu caracPerso;
    boolean doom = true;

    //constructeur Joueur
    public Joueur(int x, int y) {
        super(x, y, ConstantesDeJeu.PDVMAX, ConstantesDeJeu.FORCEMAX);
        Joueur.armure = 0;
        doom = true;
    }

    //getters setters joueur
    public static int getArmure() {
        return armure;
    }

    public void setArmure(int armure) {
        this.armure = armure;
    }

    public ArrayList<Objet> getListeObjets() {
        return listeObjets;
    }

    public void setListeObjets(ArrayList<Objet> listeObjets) {
        this.listeObjets = listeObjets;
    }

    public ConstantesDeJeu getCaracPerso() {
        return caracPerso;
    }

    public void setCaracPerso(ConstantesDeJeu caracPerso) {
        this.caracPerso = caracPerso;
    }

    public boolean isDoom() {
        return doom;
    }

    public void setDoom(boolean doom) {
        this.doom = doom;
    }

    public Image getPerso() throws IOException {
        return ImageIO.read(Joueur.class.getResource(persoRoute));

    }
    
    public Rectangle2D getHitBox(){
        return new Rectangle2D.Double(getX()+38, getY(), 36, 58);
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public int getWIDHT() {
        return WIDHT;
    }

    //methode sort Doom : tue tous les monstres de la piece   
    public void sortDoom() {

    }

    //porte un objet de la map
    public void porterObjet(Objet porter) {
        if (listeObjets.size() < QUANTITEOBJETS) {
            listeObjets.add(porter);
        }
    }
    //supprime l'objet de la liste 

    public void poserObjet(Objet poserObjet) {
        Iterator<Objet> iterateur = listeObjets.iterator();
        while (iterateur.hasNext()) {
            Objet nouveau = iterateur.next();
            if (nouveau.getClass().equals(poserObjet.getClass())) {
                listeObjets.remove(nouveau);
                break;
            }

        }
    }
    //methode pour ouvrir une porte

    public void ouvrirPorte(Porte ouvrir) {

        for (int i = 0; i < listeObjets.size(); i++) {
            if (listeObjets.get(i).getClass().equals("Clef.java")) {
                Clef clef = (Clef) listeObjets.get(i);
                if (clef.getNumeroClef() == ouvrir.getNumeroPorte()) {
                    ouvrir.setSerrure(true);
                }
            }
        }
    }

    public void passageSecret(Piece DeplacementPassageSecret) {
        //cliquer sur methode passage secret de piece !
    }

    //ouvrir un tresor et si le tresor est grand il gagne la partie sinon on retourne l'objet trouver dans le tresor
    public Objet ouvrirTresor(Tresor Tresor) {
        Objet objetTrouver = null;
        if (Tresor.getType()) {
            gagnerPartie();
        } else {
            objetTrouver = Tresor.getContient();
        }

        return objetTrouver;
    }

    //fin du jeu suite a gagner partie
    public void gagnerPartie() {
        System.out.println("Felicitations ! Vous venez de gagner la partie :)");
        System.exit(0);
    }

    //plus de points de vie, partie perdue
    public void perdrePartie() {
        if (getPdv() == 0) {
            System.out.println("Vous avez perdu la partie, retentez votre chance :)!");
            System.exit(0);
        }
    }

    //tuer tous les monstres de la partie pour gagner la partie 
    public void tuerTousLesMonstres(Piece[][] toutesLesPieces) {
        boolean gagner = true;
        int nombreMonstres = 0;
        for (int i = 0; i < toutesLesPieces.length; i++) {
            for (int j = 0; j < toutesLesPieces[i].length; j++) {
                nombreMonstres = toutesLesPieces[i][j].nombreMonstresDansLaPiece();
                if (nombreMonstres != 0) {
                    //si dans la piece il y'a des monstres si il y'a plus de monstre on gagne //verifier aussi si il y'a des mosntres dans la piece 
                    Iterator<Personnage> iterateur = toutesLesPieces[i][j].getPersonnage().iterator();
                    while (iterateur.hasNext()) {
                        Personnage personnage = iterateur.next();
                        //verifier si le monstre de la piece a des pdv, si il en a le perso a toujours pas gagn�
                        if (personnage.getClass().equals("Monstre.java")) {
                            JoueurActif monstre = (Monstre) personnage;
                            if (monstre.getPdv() > 0) {
                                gagner = false;
                            }
                        }
                    }
                }
            }

        }
        if (gagner) {
            gagnerPartie();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    public void seDeplacer() {

        if (Clavier.up && getY() > 66) {
            setY(getY() - 2);
        }

        if (Clavier.down && getY() < 540 - HEIGHT) {
            setY(getY() + 2);
        }

        if (Clavier.left && getX() > 40) {
            setX(getX() - 2);
        }

        if (Clavier.right && getX() < 715 - WIDHT) {
            setX(getX() + 2);
        }
    }

}

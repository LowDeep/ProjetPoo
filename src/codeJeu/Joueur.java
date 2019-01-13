package codeJeu;

import GUI2.Clavier;
import GUI2.Animation;
import GUI2.TableauJeu;
import GUI2.Texture;
import java.awt.Color;
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

public class Joueur extends JoueurActif {

    /**
     *
     * Graphisme du personage
     *
     *
     */
    static Image perso;
    private final int HEIGHT = 80, WIDHT = 40;
    public Animation PlayerAnimationDown;
    public Animation PlayerAnimationUp;
    public Animation PlayerAnimationLeft;
    public Animation PlayerAnimationRight;
    public Animation PlayerAnimationStand;
    Texture texture = new Texture();

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

    //TEMP
    private int numPositionPiece;

    //constructeur Joueur
    public Joueur(int x, int y) {
        super(x, y, ConstantesDeJeu.PDVMAX, ConstantesDeJeu.FORCEMAX);
        Joueur.armure = 0;
        doom = false;

        PlayerAnimationDown = new Animation(20, texture.Rick[3], texture.Rick[4],
                texture.Rick[5],texture.Rick[4]);

        PlayerAnimationUp = new Animation( 20, texture.Rick[6], texture.Rick[7],
                texture.Rick[8] , texture.Rick[7]);

        PlayerAnimationLeft = new Animation(15, texture.Rick[13], texture.Rick[14], texture.Rick[15], texture.Rick[16]);

        PlayerAnimationRight = new  Animation(15, texture.Rick[9], texture.Rick[10], texture.Rick[11], texture.Rick[12]);

        PlayerAnimationStand = new Animation(40, texture.Rick[0], texture.Rick[1], texture.Rick[2]);
        numPositionPiece = 0;
    }

    //getters setters joueur
    public static int getArmure() {
        return armure;
    }

    public void setArmure(int armure) {
        this.armure = armure;
    }

    public int getNumPositionPiece() {
        return numPositionPiece;
    }

    public void setNumPositionPiece(int numPositionPiece) {
        this.numPositionPiece = numPositionPiece;
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

    /*public Image getPerso() throws IOException {
        return ImageIO.read(Joueur.class.getResource(persoRoute));

    }*/
    @Override
    public Rectangle2D getHitBox() {
        //return new Rectangle2D.Double(getX()+38, getY(), 36, 58);
        return new Rectangle2D.Double(getX() + 17, getY() + 15, 28, 45);
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

    /*public void ouvrirPorte(Porte ouvrir) {

        for (int i = 0; i < listeObjets.size(); i++) {
            if (listeObjets.get(i).getClass().equals("Clef.java")) {
                LevierPorte clef = (LevierPorte) listeObjets.get(i);
                if (clef.getNumeroClef() == ouvrir.getNumeroPorte()) {
                    ouvrir.setSerrure(true);
                }
            }
        }
    }*/
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

    public void seDeplacer(Graphics2D g2) {

        if (Clavier.up && getY() > 30) {
            setY(getY() - 1);
            PlayerAnimationUp.dessinerAnimation(g2, getX(), getY());

        } else if (Clavier.down && getY() < 540 - HEIGHT) {
            PlayerAnimationDown.dessinerAnimation(g2, getX(), getY());
            setY(getY() + 1);
        } else if (Clavier.left && getX() > 30) {
            PlayerAnimationLeft.dessinerAnimation(g2, getX(), getY());
            setX(getX() - 1);
        } else if (Clavier.right && getX() < 755 - WIDHT) {
            PlayerAnimationRight.dessinerAnimation(g2, getX(), getY());
            setX(getX() + 1);
        } else {
            //g2.drawImage(texture.squelette[0], getX(), getY(), null);
            PlayerAnimationStand.dessinerAnimation(g2, getX(), getY());
            //g2.drawImage(texture.Rick[2], getX(), getY(), null);    
        }
    }

    //PUEDE GENERAR ERROR
    @Override
    public void dessiner(Graphics2D g2) {
        g2.drawImage(texture.Rick[10], getX(), getY(), null);
    }

}

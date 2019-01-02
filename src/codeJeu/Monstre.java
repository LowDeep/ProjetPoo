package codeJeu;

import GUI2.Animation;
import GUI2.TableauJeu;
import GUI2.Texture;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;

public class Monstre extends JoueurActif {

    /**
     *
     * Graphisme du personage
     *
     *
     */
    static Image Monstre;
    private final int HEIGHT = 45, WIDHT = 45;
    public Animation MonstreAnimationDown;
    public Animation MonstreAnimationUp;
    public Animation MonstreAnimationLeft;
    public Animation MonstreAnimationRight;
    Texture texture = TableauJeu.getInstance();
    
    public int posInitialX, posInitialY;

    //constructeur monstre
    public Monstre(int x, int y, int pdv, int force, int type) {
        super(x, y, pdv, force);
        
        posInitialX = x;
        posInitialY = y;
        
        if(type == 1){

        MonstreAnimationDown = new Animation(10, texture.monstreGhost[1], texture.monstreGhost[2],
                texture.monstreGhost[3]);

        MonstreAnimationUp = new Animation(10, texture.monstreGhost[9], texture.monstreGhost[10],
                texture.monstreGhost[11]);

        MonstreAnimationLeft = new Animation(10, texture.monstreGhost[3], texture.monstreGhost[4],
                texture.monstreGhost[5]);

        MonstreAnimationRight = new Animation(10, texture.monstreGhost[6], texture.monstreGhost[7],
                texture.monstreGhost[8]);
        }else{
            
            MonstreAnimationDown = new Animation(10, texture.monstreMinotaure[1], texture.monstreMinotaure[2],
                texture.monstreMinotaure[3]);

        MonstreAnimationUp = new Animation(10, texture.monstreMinotaure[9], texture.monstreMinotaure[10],
                texture.monstreMinotaure[11]);

        MonstreAnimationLeft = new Animation(10, texture.monstreMinotaure[3], texture.monstreMinotaure[4],
                texture.monstreMinotaure[5]);

        MonstreAnimationRight = new Animation(10, texture.monstreMinotaure[6], texture.monstreMinotaure[7],
                texture.monstreMinotaure[8]);
        }

    }

    public void chercherJoueur(Graphics2D g2, int JoueurX, int JoueurY) {

        if (JoueurX > getX()) {
            setX(getX() + 1);
            MonstreAnimationRight.dessinerAnimation(g2, getX(), getY());
        } else if (JoueurY > getY()) {
            setY(getY() + 1);
            MonstreAnimationDown.dessinerAnimation(g2, getX(), getY());

        } else if (JoueurX < getX()) {
            MonstreAnimationLeft.dessinerAnimation(g2, getX(), getY());

            setX(getX() - 1);
        } else if (JoueurY < getY()) {

            MonstreAnimationUp.dessinerAnimation(g2, getX(), getY());
            setY(getY() - 1);
        }
    }

    public void seBattre(Joueur joueur) {

    }

    public Rectangle2D getHitBox() {
        return new Rectangle2D.Double(getX(), getY(), WIDHT, HEIGHT);
    }

    @Override
    public void dessiner(Graphics2D g2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public int getWIDHT() {
        return WIDHT;
    }

}

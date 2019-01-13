package codeJeu;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.io.IOException;

import javax.imageio.ImageIO;

import GUI2.TableauJeu;
import GUI2.Texture;

public class Porte extends Objet implements Dessiner {

    private boolean serrure = false;
    private final int numeroPorte = 0;
    private final int HEIGHT = 66, WIDHT = 66;
    Texture texture = TableauJeu.getInstance();

    private int frame;

    private boolean ouvert;

    //constructeur porte
    /*public Porte(boolean serrure){
    	//this.serrure=serrure;
    	//this.numeroPorte=numeroPorte;
    }*/
    //constructeur porte avec x et y
    public Porte(int x, int y) {
        super(x, y);
        ouvert = false;
    }

    public boolean isOuvert() {
        return ouvert;
    }
    
    
    public void setOuvert(boolean ouvert) {
        this.ouvert = ouvert;
    }

    @Override
    public void dessiner(Graphics2D g) {
        if (ouvert) {
            g.drawImage(texture.porteHaut[0], getX(), getY(), null);
        } else {
            g.drawImage(texture.porteHaut[1], getX(), getY(), null);

        }
    }

    @Override
    public Rectangle2D getHitBox() {
        return new Rectangle2D.Double(getX(), getY() + 4, WIDHT, HEIGHT);
    }

    public void dessinerBas(Graphics2D g) {
        if (ouvert) {
            g.drawImage(texture.porteBas[0], 350, 500, null);
        } else {
            g.drawImage(texture.porteBas[1], 350, 500, null);
        }
    }


    public void dessinerDroite(Graphics2D g) {
        if (ouvert) {
            g.drawImage(texture.porteDroite[0], 720, 250, null);

        } else {
            g.drawImage(texture.porteDroite[1], 720, 250, null);

        }
    }

    public void dessinerGauche(Graphics2D g) {
        if (ouvert) {
            g.drawImage(texture.porteGauche[0], 0, 250, null);

        } else {
            g.drawImage(texture.porteGauche[1], 0, 250, null);

        }
    }

}

package codeJeu;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;

import GUI2.Texture;

public class LevierPorte extends Objet {
    private int numeroClef;
    /* Dessin du levier */
    static Image magicien;
    private final String levierRoute = "/liverPorteGauche.png";
    private final int HEIGHT = 35, WIDHT = 44;
    Texture texture = new Texture();
    //constructeur clef
    public LevierPorte(int x , int y) {
    	super(x,y);
    }
	public int getNumeroClef() {
		return numeroClef;
	}
    	
	public Rectangle2D getHitBox() {
        return new Rectangle2D.Double(getX(), getY(), WIDHT, HEIGHT);
    }

    public void dessiner(Graphics2D g) {
        g.drawImage(texture.levierPorte[0], getX(), getY(), null);
    }

}

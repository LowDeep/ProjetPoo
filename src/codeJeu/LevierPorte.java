package codeJeu;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;

import GUI2.Texture;

public class LevierPorte extends Objet {

    /* Dessin du levier */
    private final int HEIGHT = 35, WIDHT = 44;
    Texture texture = new Texture();
    private boolean active = false;

    //constructeur clef
    public LevierPorte(int x, int y) {
        super(x, y);
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Rectangle2D getHitBox() {
        return new Rectangle2D.Double(getX(), getY(), WIDHT, HEIGHT);
    }

    public void dessiner(Graphics2D g) {
        if (active) {
            g.drawImage(texture.levierPorte[1], getX(), getY(), null);
        } else {
            g.drawImage(texture.levierPorte[0], getX(), getY(), null);
        }
    }

}

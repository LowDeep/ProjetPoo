package codeJeu;

import GUI2.TableauJeu;
import GUI2.Texture;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Cuisinier extends Personnage {

    /**
     *
     * Graphisme du personage
     *
     *
     */
    static Image cuisinier;
    private final String cuisinierRoute = "/cuisinier.png";
    private final int HEIGHT = 45, WIDHT = 39;
    Texture texture = TableauJeu.getInstance();

    //constrcteur cuisinier
    public Cuisinier(int x, int y) {
        super(x, y);
        // TODO Auto-generated constructor stub
    }

    //methode pour recuperer tous les points de force du joueur
    public void recuperation(Joueur Joueur) {
        Joueur.setForce(ConstantesDeJeu.FORCEMAX);
    }

    public Rectangle2D getHitBox() {
        return new Rectangle2D.Double(getX(), getY(), WIDHT, HEIGHT);
    }

    public void dessiner(Graphics2D g) {
        g.drawImage(texture.cuisinier[0], getX(), getY(), null);
    }

}

package codeJeu;

import GUI2.Animation;
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
    private final int HEIGHT = 90, WIDHT = 69;
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

    public Image getCuisinier() throws IOException {
        return ImageIO.read(getClass().getResource(cuisinierRoute));
    }

    public Rectangle2D getHitBox() {
        return new Rectangle2D.Double(getX(), getY(), 69, 90);
    }

    public void dessiner(Graphics2D g) {
        g.drawImage(cuisinier, 90, 90, null);
    }

}

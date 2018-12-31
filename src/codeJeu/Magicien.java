package codeJeu;

import GUI2.TableauJeu;
import GUI2.Texture;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Magicien extends Personnage {
    private boolean donnerDoom=true;
    
     /**
     *
     * Graphisme du personage
     *
     *
     */
    static Image magicien;
    private final String magicienRoute = "/magicien.png";
    private final int HEIGHT = 60, WIDHT = 43;
    Texture texture = TableauJeu.getInstance();
    
    //constructeur magicien
    public Magicien(int x, int y) {
		super(x, y);
	}

    //methode pour recuperer le doom puis le magicien s'evapore
    public void recuperationDoom(Joueur Joueur) {
        if (Joueur.isDoom()==false && donnerDoom)
        {	Joueur.setDoom(true);
                donnerDoom=false;
        }
    }
    
    
    public Image getMagicien() throws IOException {
        return ImageIO.read(getClass().getResource(magicienRoute));
    }

    public Rectangle2D getHitBox() {
        return new Rectangle2D.Double(getX(), getY(), WIDHT, HEIGHT);
    }

    public void dessiner(Graphics2D g) {
        g.drawImage(texture.magicien[0], getX(), getY(), null);
    }

}

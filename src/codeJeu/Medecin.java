package codeJeu;

import GUI2.TableauJeu;
import GUI2.Texture;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;

public class Medecin extends Personnage {
     /**
     *
     * Graphisme du personage
     *
     *
     */
    static Image medecin;
    private final String medecinRoute = "/cuisinier.png";
    private final int HEIGHT = 45, WIDHT = 29;
    Texture texture = TableauJeu.getInstance();

    
	//constructeur medecin
    public Medecin(int x, int y) {
		super(x, y);
	}

    //methode pour soigner tous les points de vie du joueur
	public void soigner(Joueur Joueur) {
		Joueur.setPdv(ConstantesDeJeu.PDVMAX);
    }
        
        
    public Rectangle2D getHitBox() {
        return new Rectangle2D.Double(getX(), getY(), WIDHT, HEIGHT);
    }

    public void dessiner(Graphics2D g) {
        g.drawImage(texture.medecin[0], getX(), getY(), null);
    }
 
    
}

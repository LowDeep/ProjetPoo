/**
 * 
 */
package codeJeu;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;

import GUI2.TableauJeu;
import GUI2.Texture;

/**
 * @author Low_Deep
 */
public class Princesse extends Personnage {
	
	/**
    *
    * Graphisme du personage
    *
    *
    */
   static Image princesse;
   private final String princesseRoute = "/princesse.png";
   private final int HEIGHT = 45, WIDHT = 29;
   Texture texture = TableauJeu.getInstance();

   
	//constructeur princesse
   public Princesse(int x, int y) {
		super(x, y);
	}
   
   
  public Rectangle2D getHitBox() {
      return new Rectangle2D.Double(getX(), getY(), WIDHT, HEIGHT);
  }

  public void dessiner(Graphics2D g) {
      g.drawImage(texture.princesse[0], getX(), getY(), null);
  }
  
  //methode fin jeu si hitbox joueur touche hitbox princesse

}

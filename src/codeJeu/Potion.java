package codeJeu;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;

import GUI2.TableauJeu;
import GUI2.Texture;

public abstract class Potion extends Objet {
    
    //Boolean True, Potion Grande;
    //Boolean False, potion Petite;
    private final boolean type;
    Texture texture = TableauJeu.getInstance();
    private final int HEIGHTPetit = 17, WIDHTPetit = 24;
    private final int HEIGHTGrand = 42, WIDHTGrand = 31;
    /*
    static Image potionViePetit;
	   private final String potionViePetitRoute = "/potionViePetit.png";
	   private final int HEIGHTPetit = 26, WIDHTPetit = 25;
	   
	   
	   static Image potionVieGrand;
	   private final String potionVieGrandRoute = "/potionVieGrande.png";
	   private final int HEIGHTGrand = 42, WIDHTGrand = 31;
	   //Texture texture = TableauJeu.getInstance();
	    
	    */

    public Potion(boolean type, int x, int y) {
        super(x, y);
        this.type = type;
    }


    public boolean isType() {
        return type;
    }
    
    public void dessinerPotion(Graphics2D g)
    {
    	
    	if(getClass().getName().equals("codeJeu.PotionVie") && type==false)
    	{
    		g.drawImage(texture.potionViePetit[0], getX(), getY(), null);
    	}
    	if(getClass().getName().equals("codeJeu.PotionVie") && type==true)
    	{
    		g.drawImage(texture.potionVieGrand[0], getX(), getY(), null);
    	}

    	if(getClass().getName().equals("codeJeu.PotionForce") && type==false)
    	{
    		g.drawImage(texture.potionForcePetit[0], getX(), getY(), null);
    	}
    	if(getClass().getName().equals("codeJeu.PotionForce") && type==true)
    	{
    		g.drawImage(texture.potionForceGrand[0], getX(), getY(), null);
    	}
    	if(getClass().getName().equals("codeJeu.PotionArmure") && type==false)
    	{
    		g.drawImage(texture.potionArmurePetit[0], getX(), getY(), null);
    	}
    	if(getClass().getName().equals("codeJeu.PotionArmure") && type==true)
    	{
    		g.drawImage(texture.potionArmureGrand[0], getX(), getY(), null);
    	}
    }
  
    public Rectangle2D getHitBox() {
    	if(type)
    		return new Rectangle2D.Double(getX(), getY(), WIDHTGrand, HEIGHTGrand);
    	else
    		return new Rectangle2D.Double(getX(), getY(), HEIGHTPetit, WIDHTPetit);
    }
    
    

}

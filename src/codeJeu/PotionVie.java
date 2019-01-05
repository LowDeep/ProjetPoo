package codeJeu;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;

import GUI2.TableauJeu;
import GUI2.Texture;

public class PotionVie extends Potion {

	private boolean type;
	//static Image potionViePetit;
	//   private final String potionViePetitRoute = "/potionViePetit.png";
	  
	   //Texture texture = TableauJeu.getInstance();
	   
	   //static Image potionVieGrand;
	  // private final String potionVieGrandRoute = "/potionVieGrande.png";
	  
	   //Texture texture = TableauJeu.getInstance();
	   
	   
    public PotionVie(boolean type, int x, int y) {
        super(type, x, y);
    }

 
   
    
    public void gainVie(Joueur joueur) {
        /*
        //Potion Grande
        if(isType()) {
            joueur.setPdv(joueur.getPdv()+ ConstantesDeJeu.POTIONVIEGRANDE);
        }else{
            joueur.setPdv(joueur.getPdv()+ ConstantesDeJeu.POTIONVIEPETITE);
        }
         
        if(joueur.getPdv() > ConstantesDeJeu.PDVMAX){
            joueur.setPdv(ConstantesDeJeu.PDVMAX);
        }
        */
    }
    
    

   
    

}

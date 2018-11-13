package codeJeu;

public class PotionVie extends Potion {

    public PotionVie(boolean type, double x, double y) {
        super(type, x, y);
    }

 
   
    
    public void gainVie(Joueur joueur) {
        
        //Potion Grande
        if(isType()) {
            joueur.setPdv(joueur.getPdv()+ ConstantesDeJeu.POTIONVIEGRANDE);
        }else{
            joueur.setPdv(joueur.getPdv()+ ConstantesDeJeu.POTIONVIEPETITE);
        }
         
        if(joueur.getPdv() > ConstantesDeJeu.PDVMAX){
            joueur.setPdv(ConstantesDeJeu.PDVMAX);
        }
    }

}

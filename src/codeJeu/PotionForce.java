package codeJeu;

public class PotionForce extends Potion {

    public PotionForce(boolean type, double x, double y) {
        super(type, x, y);
    }


    
    public void gainForce(Joueur joueur) {
        //Potion Grande
        if(isType()) {
            joueur.setForce(joueur.getForce() + ConstantesDeJeu.PotionForceGrande);
        }else{
            joueur.setForce(joueur.getForce() + ConstantesDeJeu.PotionForcePetite);
        }
         
        if(joueur.getForce() > ConstantesDeJeu.forceMax){
            joueur.setForce(ConstantesDeJeu.forceMax);
        }
    }
}

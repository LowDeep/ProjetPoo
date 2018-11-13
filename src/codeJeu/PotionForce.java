package codeJeu;

public class PotionForce extends Potion {

    public PotionForce(boolean type, double x, double y) {
        super(type, x, y);
    }


    
    public void gainForce(Joueur joueur) {
        //Potion Grande
        if(isType()) {
            joueur.setForce(joueur.getForce() + ConstantesDeJeu.POTIONFORCEGRANDE);
        }else{
            joueur.setForce(joueur.getForce() + ConstantesDeJeu.POTIONFORCEPETITE);
        }
         
        if(joueur.getForce() > ConstantesDeJeu.FORCEMAX){
            joueur.setForce(ConstantesDeJeu.FORCEMAX);
        }
    }
}

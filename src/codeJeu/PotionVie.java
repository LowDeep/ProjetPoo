package codeJeu;

public class PotionVie extends Potion {

    public PotionVie(boolean type, double x, double y) {
        super(type, x, y);
    }

 
   
    
    public void gainVie(Joueur joueur) {
        
        //Potion Grande
        if(isType()) {
            joueur.setPdv(joueur.getPdv()+ ConstantesDeJeu.PotionVieGrande);
        }else{
            joueur.setPdv(joueur.getPdv()+ ConstantesDeJeu.PotionViePetite);
        }
         
        if(joueur.getPdv() > ConstantesDeJeu.pdvMax){
            joueur.setPdv(ConstantesDeJeu.pdvMax);
        }
    }

}

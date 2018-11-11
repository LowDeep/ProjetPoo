package codeJeu;

public class Medecin extends Personnage {
	//constructeur medecin
    public Medecin(double x, double y) {
		super(x, y);
	}
    //methode pour soigner tous les points de vie du joueur
	public void soigner(Joueur Joueur) {
		Joueur.setPdv(ConstantesDeJeu.pdvMax);
    }

}

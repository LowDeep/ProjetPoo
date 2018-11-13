package codeJeu;

public class Cuisinier extends Personnage {
	//constrcteur cuisinier
    public Cuisinier(double x, double y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
    //methode pour recuperer tous les points de force du joueur
	public void recuperation(Joueur Joueur) {
		Joueur.setForce(ConstantesDeJeu.FORCEMAX);
    }

}

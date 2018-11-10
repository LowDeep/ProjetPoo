package codeJeu;

public abstract class JoueurActif extends Personnage {
	private int pdv;
    private int force;
	//Constructeur Joueur Actif
    public JoueurActif(double x, double y,int pdv,int force) {
		super(x, y);
		this.pdv=pdv;
		this.force=force;
	}
    //getters + setters Pdv et force
    public int getPdv() {
		return pdv;
	}
    public void setPdv(int pdv) {
		pdv = pdv;
	}
    public int getForce() {
		return force;
	}
    public void setForce(int force) {
		force = force;
	}
    //fonctions du joueur actif	
    public abstract void seDeplacer();
    public abstract void seBattre(JoueurActif attaquer);
    public void afterBattlePDV() {
    }

}

package codeJeu;

	public class Joueur extends JoueurActif{
		
    private int armure;
    private static final int QUANTITEOBJETS = 6;
    public Objet[] listeObjets = new Objet[QUANTITEOBJETS];
    private ConstantesDeJeu caracPerso;
    //constructeur Joueur
    public Joueur(double x, double y,int pdv,int force,int armure,ConstantesDeJeu caracPerso)
    {
    	super(x,y,pdv,force);
    	this.armure=armure;
    	this.caracPerso=caracPerso;
    }
    //getters setters joueur
    public int getArmure() {
		return armure;
	}

	public void setArmure(int armure) {
		armure = armure;
	}

	public Objet[] getListeObjets() {
		return listeObjets;
	}

	public void setListeObjets(Objet[] listeObjets) {
		listeObjets = listeObjets;
	}
	public ConstantesDeJeu getCaracPerso() {
		return caracPerso;
	}
	public void setCaracPerso(ConstantesDeJeu caracPerso) {
		this.caracPerso = caracPerso;
	}

	//methode sort Doom : tue tous les monstres de la pièce   
    public void sortDoom() {
    	
    }
	public void porterObjet(Objet porter) {
		
    }
    public void ouvrirPorte(Porte ouvrir) {
    }
    public void passageSecret(PassageSecret DeplacementPassageSecret) {
    }
    public void trouverTresor(boolean GagnerPartie) {
    }
    public void poserObjet(Objet poserObjet) {
    }
    public void gagnerPartie() {
    }
    public void perdrePartie() {
    }
	@Override
	public void seDeplacer() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void seBattre(JoueurActif attaquer) {
		// TODO Auto-generated method stub
		
	}
	
}

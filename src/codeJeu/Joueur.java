package codeJeu;


    public class Joueur extends JoueurActif{
		
    private int armure;
    private static final int QUANTITEOBJETS = 6;
    public Objet[] listeObjets = new Objet[QUANTITEOBJETS];
    private ConstantesDeJeu caracPerso;
    boolean doom;
    //constructeur Joueur
    public Joueur(double x, double y)
    {
    	super(x,y,ConstantesDeJeu.pdvMax,ConstantesDeJeu.forceMax);
    	this.armure=0;
    	doom=true;
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

	public boolean isDoom() {
		return doom;
	}
	public void setDoom(boolean doom) {
		this.doom = doom;
	}
	
	//methode sort Doom : tue tous les monstres de la pi�ce   
    public void sortDoom() {
    	
    }
	public void porterObjet(Objet porter) {
		
    }
	//methode pour ouvrir une porte
    public void ouvrirPorte(Porte ouvrir) {

    	for(int i=0;i<listeObjets.length;i++)
    	{
    		if(listeObjets[i].getClass().equals("Clef"))
    			{
    				Clef clef=(Clef) listeObjets[i];
    				if(clef.getNumeroClef()==ouvrir.getNumeroPorte())
    				{
    					ouvrir.setSerrure(true);
    				}
    			}
    	}
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


}

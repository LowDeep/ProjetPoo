package codeJeu;

import java.util.ArrayList;

public class Joueur extends JoueurActif{
		
    private int armure;
    private static final int QUANTITEOBJETS = 6;
    public ArrayList<Objet> listeObjets = new ArrayList<Objet>(QUANTITEOBJETS);
    private ConstantesDeJeu caracPerso;
    boolean doom;
    //constructeur Joueur
    public Joueur(double x, double y)
    {
    	super(x,y,ConstantesDeJeu.PDVMAX,ConstantesDeJeu.FORCEMAX);
    	this.armure=0;
    	doom=true;
    }
    //getters setters joueur
    public int getArmure() {
		return armure;
	}
	public void setArmure(int armure) {
		this.armure = armure;
	}
	public ArrayList<Objet> getListeObjets() {
		return listeObjets;
	}
	public void setListeObjets(ArrayList<Objet> listeObjets) {
		this.listeObjets = listeObjets;
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

    	for(int i=0;i<listeObjets.size();i++)
    	{
    		if(listeObjets.get(i).getClass().equals("Clef"))
    			{
    				Clef clef=(Clef) listeObjets.get(i);
    				if(clef.getNumeroClef()==ouvrir.getNumeroPorte())
    				{
    					ouvrir.setSerrure(true);
    				}
    			}
    	}
    }
    public void passageSecret(Piece DeplacementPassageSecret) {
    }
    //ouvrir un tresor et si le tresor est grand il gagne la partie sinon on retourne l'objet trouver dans le tresor
    public Objet ouvrirTresor(Tresor Tresor) {
    	Objet objetTrouver=null;
    	if(Tresor.getType())
    		gagnerPartie();
    	else
    		objetTrouver=Tresor.getContient();
    	
    	return objetTrouver; 	
    }
    public void poserObjet(Objet poserObjet) {
    }
    //fin du jeu suite a gagner partie
    public void gagnerPartie() {
    	System.out.println("F�licitations ! Vous venez de gagner la partie :)");
    	System.exit(0);
    }
    public void perdrePartie() {
    }
    //tuer tous les monstres de la partie pour gagner la partie 
    public void tuerTousLesMonstres(Piece[][] toutesLesPieces)
    {
    	for(int i=0;i<toutesLesPieces.length;i++)
    	{
    		//if(toutesLesPieces) {}
    	}
    }
    public void seBattre(Monstre monstre)
    {
    	
    }
    

}

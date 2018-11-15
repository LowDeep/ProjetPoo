package codeJeu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Piece {
    private boolean nord;
    private boolean sud;
    private boolean est;
    private boolean ouest;
    private Porte[] porte;

    private boolean passageSecret;

    private List<Personnage> personnages = new ArrayList<Personnage> ();

	public Piece(boolean nord, boolean sud, boolean est, boolean ouest, Porte[] porte, boolean passageSecret,
			List<Personnage> personnage) {
		super();
		this.nord = nord;
		this.sud = sud;
		this.est = est;
		this.ouest = ouest;
		this.porte = porte;
		this.passageSecret = passageSecret;
		this.personnages = personnage;
	}
	//savoir si il y'a un passage secret 
	public boolean isPassageSecret() {
		return passageSecret;
	}
	//getters de portes
	public void transporterPersonnage() {
		
	}
	public List<Personnage> getPersonnage() {
		return personnages;
	}
	public void setPersonnage(List<Personnage> personnage) {
		this.personnages = personnage;
	}
	public boolean isNord() {
		return nord;
	}
	public boolean isSud() {
		return sud;
	}
	public boolean isEst() {
		return est;
	}
	public boolean isOuest() {
		return ouest;
	}
	public Porte[] getPorte() {
		return porte;
	}
	public int nombreMonstresDansLaPiece() {
		int nombreMonstres=0;
		Iterator<Personnage> iterateur = personnages.iterator();
		while(iterateur.hasNext())
		{	
			Monstre personnage = (Monstre) personnages;
			if(personnage.getClass().equals("Monstre.java"))
				nombreMonstres++;
		}
		return nombreMonstres;
	}
    
    

}

package codeJeu;

import java.util.ArrayList;
import java.util.List;

public class Piece {
    private boolean nord;
    private boolean sud;
    private boolean est;
    private boolean ouest;
    private Porte[] porte;

    private boolean passageSecret;

    private List<Personnage> personnage = new ArrayList<Personnage> ();

	public Piece(boolean nord, boolean sud, boolean est, boolean ouest, Porte[] porte, boolean passageSecret,
			List<Personnage> personnage) {
		super();
		this.nord = nord;
		this.sud = sud;
		this.est = est;
		this.ouest = ouest;
		this.porte = porte;
		this.passageSecret = passageSecret;
		this.personnage = personnage;
	}
	//savoir si il y'a un passage secret 
	public boolean isPassageSecret() {
		return passageSecret;
	}

	public void transporterPersonnage() {
		
	}
    
    

}

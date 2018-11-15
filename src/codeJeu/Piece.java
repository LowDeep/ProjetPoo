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

	public void transporterPersonnage(Piece[][] toutesLesPieces) {
            for(int i = 0; i < toutesLesPieces.length ; i++){
                
                for(int j = 0; j < toutesLesPieces[i].length; j++)
                {
                    //si dans la piece il y a un passage secret 
                    if(toutesLesPieces[i][j].isPassageSecret()){
                        
                        //si le personnage principal n'est pas là
                        Iterator<Personnage> iter = personnage.iterator();
                        boolean isPer = false;
                        while(iter.hasNext()){
                            Personnage per = iter.next();
                            
                            if(per.equals("Joueur.java")){
                                //le personnage principal est  dans la sale
                                isPer = true;
                            }
                            
                        }
                        
                        //changer coordonées x et y de personnagge
                        if(!isPer){
                          
                            changerCoordonneesPersonnage();
                            
                            
                        }
                        
                        
                    }
                    
                }
                
                
            }
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


    public List<Personnage> getPersonnage() {
        return personnage;
    }

    public void setPersonnage(List<Personnage> personnage) {
        this.personnage = personnage;
    }

    private void changerCoordonneesPersonnage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}

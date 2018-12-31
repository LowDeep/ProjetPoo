package codeJeu;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import GUI2.TableauJeu;
import GUI2.Texture;

public class Piece {
    private boolean nord;
    private boolean sud;
    private boolean est;
    private boolean ouest;
    private Porte[] porte;

    private boolean passageSecret;
    
    private final int xFirst = 30 ;
    private final int yFirst = 40;
  
    private final int xSecond = 630 ;
    private final int ySecond = 410;
    
    private final String passageSecretRoute = "/passageSecret1.png";
    private final int HEIGHT = 118, WIDHT = 87;
    Texture texture = TableauJeu.getInstance();

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
	
	//nouveau constructeur
	public Piece(boolean passageSecret)
	{
		super();
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
        
        
	public void transporterPersonnage(Piece[][] toutesLesPieces) {
            for(int i = 0; i < toutesLesPieces.length ; i++){
                
                for(int j = 0; j < toutesLesPieces[i].length; j++)
                {
                    //si dans la piece il y a un passage secret 
                    if(toutesLesPieces[i][j].isPassageSecret()){
                        
                        //si le personnage principal n'est pas là
                        Iterator<Personnage> iter = personnages.iterator();
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


    private void changerCoordonneesPersonnage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public Rectangle2D getHitBoxFirst() {
        return new Rectangle2D.Double(xFirst+15, yFirst+15, WIDHT, HEIGHT-45);
    }

    public void dessinerFirst(Graphics2D g) {
        g.drawImage(texture.passageSecretFirst[0], xFirst, yFirst, null);
    }

    public Rectangle2D getHitBoxSecond() {
        return new Rectangle2D.Double(xSecond+15, ySecond+15, WIDHT, HEIGHT-45);
    }

    public void dessinerSecond(Graphics2D g) {
        g.drawImage(texture.passageSecretSecond[0], xSecond, ySecond, null);
    }
    

}

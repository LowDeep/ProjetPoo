package codeJeu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public abstract class JoueurActif extends Personnage{
	private static int pdv;
    private static int force;
	//Constructeur Joueur Actif
    public JoueurActif(int x, int y,int pdv,int force) {
		super(x, y);
		JoueurActif.pdv=pdv;
		JoueurActif.force=force;
	}
    //getters + setters Pdv et force
    public static int getPdv() {
		return pdv;
	}
    public static void setPdv(int pdv) {
		JoueurActif.pdv = pdv;
	}
    public static int getForce() {
		return force;
	}
    public static void setForce(int force) {
		JoueurActif.force = force;
	}
    //fonctions du joueur actif	
    public void seDeplacer(KeyEvent ke)
    {	
    	int key = ke.getKeyCode();
		switch (key) {
			case KeyEvent.VK_DOWN : 
			setY(getY()+2);
				break;
			case KeyEvent.VK_UP:
				setY(getY()-2);
				break;
			case KeyEvent.VK_RIGHT:
				setX(getX()+2);
				break;
			case KeyEvent.VK_LEFT:
				setX(getX()-2);
				break;
 
		}
    	
    }
    public void afterBattlePDV() {
    }
    
}
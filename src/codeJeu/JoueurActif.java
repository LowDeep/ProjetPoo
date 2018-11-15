package codeJeu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public abstract class JoueurActif extends Personnage implements KeyListener {
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
		this.pdv = pdv;
	}
    public int getForce() {
		return force;
	}
    public void setForce(int force) {
		this.force = force;
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

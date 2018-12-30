package codeJeu;

public abstract class Personnage {
    private int x;
    private int y;
    //constructeur personnage
    public Personnage(int x,int y) {
    	this.x=x;
    	this.y=y;
    }
    //getters/setters position personnage
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}

}

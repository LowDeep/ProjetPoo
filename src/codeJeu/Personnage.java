package codeJeu;

public abstract class Personnage {
    private double x;
    private double y;
    //constructeur personnage
    public Personnage(double x,double y) {
    	this.x=x;
    	this.y=y;
    }
    //getters/setters position personnage
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public void setX(double x) {
		this.x = x;
	}
	public void setY(double y) {
		this.y = y;
	}

}

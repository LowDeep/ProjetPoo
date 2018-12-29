package codeJeu;

public abstract class Objet {
    private double x;
    private double y;

    public Objet(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Objet() {
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    
}

package codeJeu;

public abstract class Objet {
    private int x;
    private int y;

    public Objet(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Objet() {
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    
}

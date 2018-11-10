package codeJeu;

public abstract class Potion extends Objet {
    private int gain;

    public Potion(int gain, double x, double y) {
        super(x, y);
        this.gain = gain;
    }

    
    

}

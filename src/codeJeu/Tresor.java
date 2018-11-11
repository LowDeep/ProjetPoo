package codeJeu;

public class Tresor extends Objet{
    
    //Soit 
    private final boolean type;
    private final Objet contient;

    public Tresor(boolean type, Objet contient) {
        this.type = type;
        this.contient = contient;
    }

    public boolean getType() {
        return type;
    }

    public Objet getContient() {
        return contient;
    }
    
}

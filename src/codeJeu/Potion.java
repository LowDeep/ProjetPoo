package codeJeu;

public abstract class Potion extends Objet {
    
    //Boolean True, Potion Grande;
    //Boolean False, potion Petite;
    private final boolean type;

    public Potion(boolean type, double x, double y) {
        super(x, y);
        this.type = type;
    }


    public boolean isType() {
        return type;
    }
    
    
    
    

}

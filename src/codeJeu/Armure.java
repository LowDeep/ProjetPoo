package codeJeu;

public class Armure extends Objet implements ObjetEndomager {
    private int protection;

    public Armure(int Protection, int x, int y) {
        super(x, y);
        this.protection = Protection;
    }

    public int getProtection() {
        return protection;
    }

    public void setProtection(int Protection) {
        this.protection = Protection;
    }
    
    
    
    public void objetEndomage() {
    }
    

}

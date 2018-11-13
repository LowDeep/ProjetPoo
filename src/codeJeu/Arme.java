package codeJeu;

public abstract class Arme extends Objet implements ObjetEndomager {
	
    private int dommages;
    private int vieArme;
    private String typeArme;

    public Arme(int Dommages, int VieArme, String TypeArme, double x, double y) {
        super(x, y);
        this.dommages = Dommages;
        this.vieArme = VieArme;
        this.typeArme = TypeArme;
    }

    public int getDommages() {
        return dommages;
    }

    public void setDommages(int Dommages) {
        this.dommages = Dommages;
    }

    public int getVieArme() {
        return vieArme;
    }

    public void setVieArme(int VieArme) {
        this.vieArme = VieArme;
    }

    public String getTypeArme() {
        return typeArme;
    }

    public void setTypeArme(String TypeArme) {
        this.typeArme = TypeArme;
    }


    @Override
    public void objetEndomage() {


    }

    
}

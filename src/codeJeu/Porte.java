package codeJeu;

public class Porte {
    private boolean serrure;
    private final int numeroPorte;
    //constructeur porte
    public Porte(boolean serrure, int numeroPorte){
    	this.serrure=serrure;
    	this.numeroPorte=numeroPorte;
    }
    //getters/setters
    public boolean isSerrure() {
            return serrure;
    }
    public void setSerrure(boolean serrure) {
            this.serrure = serrure;
    }
    public int getNumeroPorte() {
        return numeroPorte;
    }
    

}

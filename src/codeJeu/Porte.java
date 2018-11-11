package codeJeu;

public abstract class Porte {
    private boolean serrure;
    private int numeroPorte;
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

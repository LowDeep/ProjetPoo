package codeJeu;

public abstract class JoueurActif extends Personnage {
    private int Pdv;
    private int Force;
    
    public abstract void seDeplacer();

    public abstract void seBattre(JoueurActif attaquer);

    public void afterBattlePDV() {
    }

}

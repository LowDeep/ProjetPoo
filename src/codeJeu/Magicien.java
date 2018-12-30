package codeJeu;

public class Magicien extends Personnage {
    private boolean donnerDoom=true;
    
    //constructeur magicien
    public Magicien(int x, int y) {
		super(x, y);
	}

    //methode pour recuperer le doom puis le magicien s'evapore
    public void recuperationDoom(Joueur Joueur) {
        if (Joueur.isDoom()==false && donnerDoom)
        {	Joueur.setDoom(true);
                donnerDoom=false;
        }
    }

}

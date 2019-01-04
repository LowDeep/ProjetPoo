package GUI2;


import codeJeu.Cuisinier;
import codeJeu.Joueur;
import codeJeu.Monstre;
import codeJeu.Personnage;
import codeJeu.Piece;
import java.awt.Graphics2D;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 * @author Low_Deep
 */
public class main {


    public static void main(String[] args) throws IOException {

        FenetreDepar fenetreDepar = new FenetreDepar();
        fenetreDepar.setVisible(true);
        //HowToPlay howToPlay = new HowToPlay();
        //howToPlay.setVisible(true);
        //howToPlay.setDefaultCloseOperation(EXIT_ON_CLOSE);

        
        //fenetreJeu fenetreJeu = new fenetreJeu();
        //fenetreObjets fenetreObjets = new fenetreObjets();
        //fenetreObjets.setLocationRelativeTo(fenetreJeu);
        //fenetreObjets.setBounds(400,140,300,600);
        /*Joueur joueur = new Joueur(0, 0);
        Monstre monstre = new Monstre(0, 0, 0, 0, 1);
        Cuisinier cuisinier = new Cuisinier(0, 0);
        
        List<Personnage> personnages = new ArrayList<Personnage>();
        personnages.add(joueur);
        personnages.add(monstre);
        personnages.add(cuisinier);
        
        
        Piece piece = new Piece(true, true, true, true, true, personnages);
        //piece.dessinerComponents();
        */
    }


}

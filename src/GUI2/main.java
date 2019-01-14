package GUI2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 * @author Low_Deep
 */
public class main {

    public static void main(String[] args) throws IOException {
        String path = "/musique.wav";
        InputStream musique;
        try{
            musique = new FileInputStream(new File(main.class.getResource(path).getFile()));
            AudioStream audio = new AudioStream(musique);
            AudioPlayer.player.start(audio);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

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

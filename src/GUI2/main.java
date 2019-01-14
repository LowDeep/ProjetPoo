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
        /**
        *
        * Utilisation du fichier musique.wav pour reproduire toute la musique du jeu
        * 
        */
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

    }
    

}

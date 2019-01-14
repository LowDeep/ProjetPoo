package GUI2;

import codeJeu.Cuisinier;
import codeJeu.Joueur;
import codeJeu.Monstre;
import codeJeu.Personnage;
import codeJeu.Piece;
import java.awt.Graphics2D;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.SourceDataLine;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import sun.audio.AudioDataStream;
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

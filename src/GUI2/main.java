/**
 *
 */
package GUI2;

import java.io.IOException;
import javax.swing.JFrame;

/**
 * @author Low_Deep
 */
public class main {

    /**
     * @throws IOException
     *
     */
    public static void main(String[] args) throws IOException {

        Fenetre fenetre = new Fenetre();
        fenetre.setVisible(true);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //fenetreJeu fenetreJeu = new fenetreJeu();
        //fenetreObjets fenetreObjets = new fenetreObjets();
        //fenetreObjets.setLocationRelativeTo(fenetreJeu);
        //fenetreObjets.setBounds(400,140,300,600);
    }

}

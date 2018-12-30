/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI2;

<<<<<<< HEAD
import java.awt.Dimension;

=======
import GUI.Clavier;
>>>>>>> 77850d0e920c3ed6bec9254de00a9b670ca40ee8
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

/**
 *
 * @author dioxo
 */
public class Fenetre extends JFrame {

    private final int WIDTH = 790, HEIGHT = 600;
    private TableauJeu tableauJeu;
<<<<<<< HEAD
    private fenetreObjets fenetreObjet;
    
=======
    Thread2 thread;

>>>>>>> 77850d0e920c3ed6bec9254de00a9b670ca40ee8
    public Fenetre() {
        setTitle("Les aventures de Taha");
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        tableauJeu = new TableauJeu();
        fenetreObjet = new fenetreObjets();
        JPanel contenuFenetreJeu = (JPanel) getContentPane();

        add(tableauJeu);
        addKeyListener(new Clavier());
        thread = new Thread2(tableauJeu);
        thread.start();
    }

}

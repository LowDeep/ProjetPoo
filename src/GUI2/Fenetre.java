/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI2;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JPanel;

import GUI.Clavier;

/**
 * @author dioxo
 * @author Low_Deep
 */
public class Fenetre extends JFrame {

    private final int WIDTH = 790, HEIGHT = 600;
    private TableauJeu tableauJeu;
    private fenetreObjets fenetreObjet;

    public static Thread2 thread;

    public Fenetre() {
        setTitle("Les aventures de Mr Rick");
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        tableauJeu = new TableauJeu();

        //JPanel contenuFenetreJeu = (JPanel) getContentPane();

        add(tableauJeu);
        addKeyListener(new Clavier());
        thread = new Thread2(tableauJeu);

        //tableauJeu.collisionVie(tableauJeu.getJoueur());
        // fenetreObjets.getProgbarVie().getProgressBar().setValue(JoueurActif.getPdv());
        // System.out.println(JoueurActif.getPdv());

        try {
            Thread.sleep(1000);
            fenetreObjet = new fenetreObjets();
        } catch (InterruptedException ex) {
            Logger.getLogger(Fenetre.class.getName()).log(Level.SEVERE, null, ex);
        }
        thread.start();
    }

    //getter tableau jeu pour prendre carac joueur 
    public TableauJeu getTableauJeu() {
        return tableauJeu;
    }

    //fonction pour reinitialiser le jeu
    /*public void reinitialiserJeu()
	{
		dispose();
		FenetreDepar fenetreDep = new FenetreDepar();
        fenetreDep.setVisible(true);
	}*/
}

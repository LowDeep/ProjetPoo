/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dioxo
 */
public class Thread2 extends Thread {

    TableauJeu tableauJeu;  

    final int NS_PAR_SECOND = 1000000000;
    final byte APS_OBJET = 100;
    final double NS_PAR_ACTUALISATION = NS_PAR_SECOND / APS_OBJET;
    long refActualisation = System.nanoTime();
    long refCompteur = System.nanoTime();

    double tempsPasse;
    double delta = 0;
    
    
    public Thread2(TableauJeu tableauJeu) {
        this.tableauJeu = tableauJeu;
    }

    @Override
    public void run() {
         while (true) {
            final long debutBoucle = System.nanoTime();
            tempsPasse = debutBoucle - refActualisation;
            refActualisation = debutBoucle;

            delta += tempsPasse / NS_PAR_ACTUALISATION;

            while (delta >= 1) {
                tableauJeu.repaint();
                delta--;
            }

            /*try {
                Thread.sleep(6);
                tableauJeu.repaint();

            } catch (InterruptedException ex) {
                Logger.getLogger(Thread2.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        }
    }

}

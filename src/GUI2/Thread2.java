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

    public Thread2(TableauJeu tableauJeu) {
        this.tableauJeu = tableauJeu;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(20);
                tableauJeu.repaint();

            } catch (InterruptedException ex) {
                Logger.getLogger(Thread2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}

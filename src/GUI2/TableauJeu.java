/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import GUI.Clavier;
import codeJeu.Joueur;

/**
 *
 * @author dioxo
 */
public class TableauJeu extends JPanel {

    private final String bgRoute = "/bg.png";
    Image bg;
    Joueur joueur;
    

    
    /*
    TEMP
    */
    Enemi enemi;
    
    TableauJeu() {

        try {
            bg = ImageIO.read(TableauJeu.class.getResource(bgRoute));
            //perso =  ImageIO.read(TableauJeu.class.getResource(persoRoute));
            //bg = ImageIO.read(new File("/home/dioxo/Documentos/Universidad/ProjetPoo/src/res/bg.png"));
        } catch (IOException exc) {
            exc.printStackTrace();
        }
        setPreferredSize(new Dimension(790, 600));
        setBackground(Color.WHITE);
        enemi = new Enemi(0 , 0 );
        joueur = new Joueur(790 / 2, 600 / 2);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        //Dessiner escenaire
        g2.drawImage(bg, 0, 0, getWidth(), getHeight(), this);

        //Set color transparent pour les hit Boxs
        g2.setColor(new Color(255, 255, 255, 0));
        try {
            dessiner(g2);
            actualiser();
            //g2D.drawImage(perso, getWidth() /2  , getHeight() /2, 90, 69, this);
        } catch (IOException ex) {
            Logger.getLogger(TableauJeu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    public void dessiner(Graphics2D g2) throws IOException {
        g2.fill(joueur.getHitBox());
        g2.drawImage(joueur.getPerso(), joueur.getX(), joueur.getY(), joueur.getHEIGHT(), joueur.getWIDHT(), this);

        g2.setColor(Color.red);
        g2.fill(enemi.getEnemi());

    }

    public void actualiser() {
        Clavier.update();
        joueur.seDeplacer();
        enemi.seDeplacer(getBounds(), collisionVie(joueur));
        if(joueur.getPdv()==0)
        {
        	endGame();
        }
    }
    
    /**
	 * methode fin jeu
	 * consiste a afficher un message de fin du jeu avec bouton pour recommencer
	 */
	private void endGame() {
		
			Fenetre.thread.stop();
		
		// TODO Auto-generated method stub
		/*try {
			Fenetre.thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		JOptionPane jop1;
		String choices[]= { "Fermer le jeu"};
		jop1=new JOptionPane();
		/*jop1.showConfirmDialog(null, "Vous avez perdu!", "LOOOSER:)", 
        JOptionPane.YES_NO_OPTION, 
        JOptionPane.QUESTION_MESSAGE);*/
		int i =0;
		//System.out.println(i);

		jop1.showOptionDialog(this, "Vous avez perdu! ", "LOOOOOSER !", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
		i = JOptionPane.DEFAULT_OPTION;
		//actionPerformed(jop1);
		//System.out.println(i);
		if(i != 0) {
			
			//setVisible(false);
	        //FenetreDepar fenetreDep = new FenetreDepar();
	        //fenetreDep.setVisible(true);
	        //fenetreDep.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			System.exit(0);
	        
		}
		
		
	}

	public boolean collision(Joueur joueur){
        return enemi.getEnemi().intersects(joueur.getHitBox()); 
    }
    //getter joueur
	public Joueur getJoueur() {
		return joueur;
	}
	//methode pour si il y a collision 
	public boolean collisionVie(Joueur joueur)
	{
		if(collision(joueur))
		{
			if(Joueur.getArmure()>0)
			{
				joueur.setArmure(joueur.getArmure()-1);
			}
			else
			{
				joueur.setPdv(joueur.getPdv()-1);;
			}
		}
		fenetreObjets.getProgbarArmure().getProgressBar().setValue(joueur.getArmure());
		fenetreObjets.getProgbarVie().getProgressBar().setValue(joueur.getPdv());
		
		//System.out.println(joueur.getPdv());
		
		return collision(joueur);
	}
}

package codeJeu;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.io.IOException;

import javax.imageio.ImageIO;

import GUI2.TableauJeu;
import GUI2.Texture;

public class Porte extends Objet implements Dessiner{
    private boolean serrure=false;
    private final int numeroPorte=0;
    private final String porteOuverteHaut = "/porteOuverte.png";
    private final int HEIGHT = 66, WIDHT = 66;
    Texture texture = TableauJeu.getInstance();
    
    private final String porteOuverteBas = "/porteOuverteBas.png";
    private final String porteOuverteDroite = "/porteOuverteDroite.png";
    private final String porteOuverteGauche = "/porteOuverteGauche.png";
    
    //constructeur porte
    public Porte(boolean serrure, int numeroPorte){
    	//this.serrure=serrure;
    	//this.numeroPorte=numeroPorte;
    }
    //constructeur porte avec x et y
    public Porte(int x , int y )
    {
    	super(x,y);
    }
    //getters/setters
    public boolean isSerrure() {
            return serrure;
    }
    public void setSerrure(boolean serrure) {
            this.serrure = serrure;
    }
    public int getNumeroPorte() {
        return numeroPorte;
    }
    
    public Image getporteOuverte() throws IOException {
        return ImageIO.read(getClass().getResource(porteOuverteHaut));
    }

   
    @Override
    public void dessiner(Graphics2D g) {
        g.drawImage(texture.porteOuverte[0],350 ,0 , null);
    }
    
    @Override
    public Rectangle2D getHitBox() {
        return new Rectangle2D.Double(getX(), getY(), WIDHT, HEIGHT);
    }
    
    public Image getporteOuverteBas() throws IOException {
        return ImageIO.read(getClass().getResource(porteOuverteBas));
    }

   
    public void dessinerBas(Graphics2D g) {
        g.drawImage(texture.porteOuverteBas[0],350 ,500 , null);
    }
    
   
    //Droite
    public Image getporteOuverteDroite() throws IOException {
        return ImageIO.read(getClass().getResource(porteOuverteDroite));
    }

   
    public void dessinerDroite(Graphics2D g) {
        g.drawImage(texture.porteOuverteDroite[0],720 ,250 , null);
    }
    

    //gauche
    public Image getporteOuverteGauche() throws IOException {
        return ImageIO.read(getClass().getResource(porteOuverteGauche));
    }

   
    public void dessinerGauche(Graphics2D g) {
        g.drawImage(texture.porteOuverteGauche[0],0 ,250 , null);
    }
    

}

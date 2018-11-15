package GUI2;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Scene extends JPanel{
	
	private ImageIcon icoFond;
	private Image imgFond1;
	//abscisse de l'image de fond 
	private int xFond1;
	
	//constructeur 
	public Scene(){
		super();
		this.xFond1= -50;
			icoFond = new ImageIcon("/ProjetPooJeu/images/imageFond.jpg");
			this.imgFond1=this.icoFond.getImage();
			 
	}
	
	public void paintComponent(Graphics g)
	{
		try {
		super.paintComponent(g);
		Graphics g2 = (Graphics2D)g;
		g2.drawImage(imgFond1,this.getWidth(),this.getHeight(),this);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}

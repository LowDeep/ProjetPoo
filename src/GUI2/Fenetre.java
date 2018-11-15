package GUI2;

import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame{
	public static Scene scene;
	
	public Fenetre(String title) {
		setTitle(title);
		//redim la page 
		setSize(1000, 560);
		//eteindre le programme quand on a fermer la page
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//afficher la fenetre au milieu de l'ecran
		setLocationRelativeTo(null);
		setResizable(false);
		setAlwaysOnTop(true);
		
		//instancier scene
		scene = new Scene();
		//ajouter scene au panel
		setContentPane(scene);
		//rendre le panel visible 
		setVisible(true);
	}
	
}

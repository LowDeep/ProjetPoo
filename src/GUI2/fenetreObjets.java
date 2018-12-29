/**
 * 
 */
package GUI2;

import javax.swing.JFrame;

/**
 * @author Low_Deep
 */
public class fenetreObjets extends JFrame{
	
	//constructeur fenetreObjet
	public fenetreObjets()
	{
		setTitle("Objets");
		setVisible(true);
		setResizable(false);
		setBounds(400,140,300,600);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);//quand on ferme la fenetre ca termine l'application
	}
}

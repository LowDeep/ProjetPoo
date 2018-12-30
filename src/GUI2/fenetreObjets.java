/**
 * 
 */
package GUI2;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

/**
 * @author Low_Deep
 */
public class fenetreObjets extends JFrame{
	
	//constructeur fenetreObjet
	public fenetreObjets()
	{
		getContentPane().setBackground(Color.LIGHT_GRAY);
		getContentPane().setLayout(null);
		setTitle("Objets");
		setVisible(true);
		setResizable(false);
		setBounds(250,210,300,600);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);//quand on ferme la fenetre ca termine l'application
		
		JProgressBar progressBar_Vie = new JProgressBar();
		progressBar_Vie.setBounds(114, 16, 146, 14);
		getContentPane().add(progressBar_Vie);
		
		JProgressBar progressBar_Armure = new JProgressBar();
		progressBar_Armure.setBounds(114, 40, 146, 14);
		getContentPane().add(progressBar_Armure);
		JLabel lblVie = new JLabel("Vie");
		lblVie.setSize(22, 29);
		lblVie.setLocation(10, 10);
		lblVie.setBackground(Color.WHITE);
		getContentPane().add(lblVie);
		
		JLabel lblArmure = new JLabel("Armure");
		lblArmure.setBackground(Color.WHITE);
		lblArmure.setBounds(10, 32, 54, 29);
		getContentPane().add(lblArmure);
		
		JLabel lblForce = new JLabel("Force");
		lblForce.setBackground(Color.WHITE);
		lblForce.setBounds(10, 55, 54, 29);
		getContentPane().add(lblForce);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(114, 65, 146, 14);
		getContentPane().add(progressBar);
		
		
	}
}

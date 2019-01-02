/**
 * 
 */
package GUI2;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import java.awt.Font;

/**
 * @author Low_Deep
 */
public class fenetreObjets extends JFrame{
	public static progressBar progbarVie;
	public static progressBar progbarForce;
	public static progressBar progbarArmure;
	
	//constructeur fenetreObjet
	public fenetreObjets()
	{
            progbarVie= new progressBar();
            progbarForce= new progressBar();
            progbarArmure=new progressBar();
            
		getContentPane().setBackground(Color.LIGHT_GRAY);
		getContentPane().setLayout(null);
		setTitle("Stats");
		setVisible(true);
		setResizable(false);
		setBounds(250,210,316,250);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);//quand on ferme la fenetre ca termine l'application
		
		//this.progbarVie.infosJoueur("vie");//recup vie puis la mettre dans la progressBar
		//this.progbarForce.infosJoueur("force");//same pour force
		//this.progbarArmure.infosJoueur("armure");//same pour armure
		progbarVie.setBounds(114, 16, 146, 33);
		progbarForce.setBounds(114, 65, 146, 33);
		progbarArmure.setBounds(114, 40, 146, 33);
	
		getContentPane().add(progbarVie);
		getContentPane().add(progbarForce);
		getContentPane().add(progbarArmure);
		
		
		
		
		/*
		JProgressBar progressBar_Vie = new JProgressBar();
		
		progressBar_Vie.setMaximum(10);
		progressBar_Vie.setMinimum(0);
		progressBar_Vie.setStringPainted(true);
		getContentPane().add(progressBar_Vie);
		
		JProgressBar progressBar_Armure = new JProgressBar();
		progressBar_Armure.setBounds(114, 40, 146, 14);
		getContentPane().add(progressBar_Armure);
		JLabel lblVie = new JLabel("Vie");
		lblVie.setSize(22, 29);
		lblVie.setLocation(10, 10);
		lblVie.setBackground(Color.WHITE);
		getContentPane().add(lblVie);
		
				
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(114, 65, 146, 14);
		getContentPane().add(progressBar);
		*/
		
		JLabel lblArmure = new JLabel("Armure");
		lblArmure.setBackground(Color.WHITE);
		lblArmure.setBounds(10, 40, 54, 29);
		getContentPane().add(lblArmure);
		
		JLabel lblForce = new JLabel("Force");
		lblForce.setBackground(Color.WHITE);
		lblForce.setBounds(10, 69, 54, 29);
		getContentPane().add(lblForce);
		
		JLabel lblVie = new JLabel("Vie");
		lblVie.setBackground(Color.WHITE);
		lblVie.setBounds(10, 10, 54, 29);
		getContentPane().add(lblVie);
		
		JLabel lblTrouvezLaPrincesse = new JLabel("Sauvez la Princesse et vous obtiendrez");
		lblTrouvezLaPrincesse.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 18));
		lblTrouvezLaPrincesse.setBackground(Color.WHITE);
		lblTrouvezLaPrincesse.setBounds(10, 114, 317, 33);
		getContentPane().add(lblTrouvezLaPrincesse);
		
		JLabel label = new JLabel("...");
		label.setFont(new Font("Snap ITC", Font.PLAIN, 22));
		label.setBackground(Color.WHITE);
		label.setBounds(131, 138, 40, 33);
		getContentPane().add(label);
		
		JLabel lblLaGloire = new JLabel("la GLOIRE !");
		lblLaGloire.setForeground(Color.RED);
		lblLaGloire.setFont(new Font("Viner Hand ITC", Font.BOLD, 19));
		lblLaGloire.setBackground(Color.WHITE);
		lblLaGloire.setBounds(94, 174, 124, 20);
		getContentPane().add(lblLaGloire);

		
		
	}
	
	//getters setters
	
	public static progressBar getProgbarVie() {
		return progbarVie;
	}



	public static progressBar getProgbarForce() {
		return progbarForce;
	}


	public static progressBar getProgbarArmure() {
		return progbarArmure;
	}
}

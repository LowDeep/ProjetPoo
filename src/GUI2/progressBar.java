/**
 * 
 */
package GUI2;

import javax.swing.JPanel;
import javax.swing.JProgressBar;

import codeJeu.ConstantesDeJeu;
import codeJeu.Joueur;
import codeJeu.JoueurActif;

/**
 * @author Low_Deep
 */
public class progressBar extends JPanel{
	private JProgressBar progressBar;
	//private Fenetre fenetrePerso;
	
	public progressBar()
	{
		this.progressBar=new JProgressBar();
		//progressBar.setBounds(114, 16, 146, 14);
		//progressBar.setMaximum(10);
		//progressBar.setMinimum(0);
		progressBar.setStringPainted(true);
		this.progressBar.setBounds(0,0, 146,14);
		add(progressBar);
	}
	//methode pour avoir les informations du joueur et les mettre dans la progressBar
	public void infosJoueur(String carac)
	{
		System.out.println(JoueurActif.getPdv());
		
		if(carac.equals("vie")) {
			progressBar.setValue(JoueurActif.getPdv());
			progressBar.setMaximum(ConstantesDeJeu.PDVMAX);
		}
		else if(carac.equals("armure")) {
			progressBar.setValue(Joueur.getArmure());
			progressBar.setMaximum(ConstantesDeJeu.ARMUREMAX);}
		else if(carac.equals("force")) {
			progressBar.setValue(JoueurActif.getForce());
			progressBar.setMaximum(ConstantesDeJeu.FORCEMAX);}
		
	}
	public JProgressBar getProgressBar() {
		return progressBar;
	}

	
	
	
	
	/*
	 	public static void main(String args[]) 
	{
		progressBar prog = new progressBar();
		JFrame frameTest = new JFrame();
		frameTest.setVisible(true);
		//frameTest.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frameTest.setLocationRelativeTo(null);
		frameTest.setBounds(800, 140, 990, 600);
		
		JPanel panelContent = (JPanel)frameTest.getContentPane();
		panelContent.add(prog);
		
	}
*/
}

/**
 * 
 */
package GUI2;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;

/**
 * @author Low_Deep
 */
public class fenetreJeu2 extends JFrame {
	public fenetreJeu2() {
		setTitle("Jeu alex!!");
		setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
		setResizable(false); 
		setVisible(true);
		setBounds(800,140,796,635);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("/BackgroundJFramesimple.png"));
		getContentPane().add(label, BorderLayout.CENTER);
		
	}

}

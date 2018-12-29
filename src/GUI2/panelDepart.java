/**
 * 
 */
package GUI2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @author Low_Deep
 */
public class panelDepart extends JFrame {
	public panelDepart() {
		setTitle("Les Aventures de Toto");
		//setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
		setResizable(false); 
		setVisible(true);
		getContentPane().setLayout(null);
		setBackground(new Color(192, 192, 192));
		setBounds(100, 100, 873, 744);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Low_Deep\\eclipse-workspace\\ProjetPooJeu\\res\\Group 2.png"));
		btnNewButton.setBounds(530, 193, 210, 50);
		getContentPane().add(btnNewButton);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon("C:\\Users\\Low_Deep\\eclipse-workspace\\ProjetPooJeu\\res\\Group.png"));
		button.setBackground(Color.WHITE);
		button.setBounds(530, 389, 210, 50);
		getContentPane().add(button);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Low_Deep\\eclipse-workspace\\ProjetPooJeu\\res\\image.png"));
		label.setBounds(-39, 16, 879, 123);
		getContentPane().add(label);
	}
}
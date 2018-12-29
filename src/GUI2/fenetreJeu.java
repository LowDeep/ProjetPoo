/**
 * 
 */
package GUI2;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;

/**
 * @author Low_Deep
 */
public class fenetreJeu extends JFrame{
	private JScrollPane rightScrollPane_1;

	//constructeur fenetreJeu
	public fenetreJeu()
	{
		getContentPane().setBackground(Color.WHITE);
		setBackground(new Color(240, 240, 240));
		setTitle("Jeu!!");
		setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
		setResizable(false); 
		setVisible(true);
		setBounds(800,140,990,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);//quand on ferme la fenetre ca termine l'application
		
		JPanel contenuFenetreJeu = (JPanel)getContentPane();
		
		//contenu de fenetre
		JScrollPane leftScrollPane = new JScrollPane();
		leftScrollPane.setPreferredSize(new Dimension(200, 0));
		
		JScrollPane rightScrollPane = new JScrollPane();
		rightScrollPane_1=new JScrollPane( );
		//ImageIcon img = new ImageIcon("C:\\Users\\Low_Deep\\eclipse-workspace\\ProjetPooJeu\\res\\BackgroundJFramesimple.png");
       // partieDroite.add(img);
		
		JSplitPane splitPane = new JSplitPane(
					JSplitPane.HORIZONTAL_SPLIT,leftScrollPane,rightScrollPane_1);
		
		Canvas canvas = new Canvas();
		rightScrollPane_1.setViewportView(canvas);
		/*Image image = new ImageIcon(this.getClass().getResource("/BackgroundJFramesimple.png")).getImage();
		JLabel label = new JLabel();
		label.setBounds(200,0,790,600);
		label.setIcon(new ImageIcon(image));*/
		
		contenuFenetreJeu.setBorder(BorderFactory.createLineBorder(Color.gray));//bordure visible 
		//splitPane.setResizeWeight(0.5);
        //splitPane.setOneTouchExpandable(true);
        //splitPane.setContinuousLayout(true);
		splitPane.setBackground(Color.BLACK);
		
		contenuFenetreJeu.add(splitPane);
		JLabel label = new JLabel("");
		rightScrollPane_1.add(label);
		label.setIcon(new ImageIcon("C:\\Users\\Low_Deep\\eclipse-workspace\\ProjetPooJeu\\res\\BackgroundJFramesimple.png"));
		label.add(label, BorderLayout.NORTH);
		
		//ImageIcon icon = createImage("images/Dog.gif");
		
		
		
		

	}
	
}

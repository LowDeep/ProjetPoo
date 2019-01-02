/**
 * 
 */
package GUI2;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * @author Low_Deep
 */
public class Map extends JPanel {
	
	public  void paintComponent(Graphics g) {
        paintComponent(g);
        g.setColor(Color.RED);
        g.fillRect(10, 100, 200, 200);
        g.drawRect(10,200,200,200);
 
    }
	
	
}

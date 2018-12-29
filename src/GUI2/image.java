/**
 * 
 */
package GUI2;

import java.awt.Graphics;
import java.awt.Image;
import java.io.Serializable;

import javax.swing.JPanel;

/**
 * @author Low_Deep
 */
public class image extends JPanel implements Serializable  {

	    Image image = null;
	    public image(Image image) {
	        this.image = image;
	    }
	    public image() {
	    }
	    public void setImage(Image image){
	        this.image = image;
	    }
	    public Image getImage(Image image){
	        return image;
	    }
	    public void paintComponent(Graphics g) {
	        super.paintComponent(g); //paint background
	        if (image != null) { //there is a picture: draw it
	            int height = this.getSize().height;
	            int width = this.getSize().width;
	            //g.drawImage(image, 0, 0, this); //use image size          
	            g.drawImage(image,0,0, width, height, this);
	        }
	    }
	
}

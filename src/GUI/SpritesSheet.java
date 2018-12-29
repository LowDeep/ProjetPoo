/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Alex Molinares
 */
public class SpritesSheet {
    public final int[] pixeles;
    private final int HEIGHT, WIDTH;
    
    
    //SPREETS SHEETS
    public static SpritesSheet snow = new SpritesSheet("/textures/snow.jpg", 1024, 1024);
    public static SpritesSheet textures = new SpritesSheet("/textures/textures.png", 640, 320);
    
    //FIN SPREET SHEET
    
    
    public SpritesSheet(final String ruta, final int ancho, final int alto) {
        this.WIDTH = ancho;
        this.HEIGHT = alto;
        pixeles = new int [ancho*alto];
        
        BufferedImage imagen;
        try {
            imagen = ImageIO.read(SpritesSheet.class.getResource(ruta));
            imagen.getRGB(0, 0, ancho, alto, pixeles, 0, ancho);

        } catch (IOException ex) {
            Logger.getLogger(SpritesSheet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    public int getAncho() {
        return WIDTH;
    }
    
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI2;

import java.awt.image.BufferedImage;

/**
 *
 * @author dioxo
 */
public class Texture {
    
    SpriteSheet squeletteSpriteSheet;
    private BufferedImage squelette_sheet = null;
    
    public BufferedImage[] squelette = new BufferedImage[36];
    

    public Texture() {
        
        BufferedImageLoader loader = new BufferedImageLoader(); 
        
        squelette_sheet = loader.loadImage("/squelette.png");
        
        squeletteSpriteSheet = new SpriteSheet(squelette_sheet);
        getSquelette();
    }

    private void getSquelette() {
        
        
        //ANIMATIONS Enemi Squelette
        //Squelette immobile
        squelette[0] = squeletteSpriteSheet.grabImage(1, 3, 64, 64); 
        
        //Walk Down
        squelette[1] = squeletteSpriteSheet.grabImage(2, 3, 64, 64); 
        squelette[2] = squeletteSpriteSheet.grabImage(3, 3, 64, 64); 
        squelette[3] = squeletteSpriteSheet.grabImage(4, 3, 64, 64); 
        squelette[4] = squeletteSpriteSheet.grabImage(5, 3, 64, 64); 
        squelette[5] = squeletteSpriteSheet.grabImage(6, 3, 64, 64); 
        squelette[6] = squeletteSpriteSheet.grabImage(7, 3, 64, 64); 
        squelette[7] = squeletteSpriteSheet.grabImage(8, 3, 64, 64); 
        squelette[8] = squeletteSpriteSheet.grabImage(9, 3, 64, 64);
        
        //Walk Up
        squelette[9] = squeletteSpriteSheet.grabImage(1, 1, 64, 64); 
        squelette[10] = squeletteSpriteSheet.grabImage(2, 1, 64, 64); 
        squelette[11] = squeletteSpriteSheet.grabImage(3, 1, 64, 64); 
        squelette[12] = squeletteSpriteSheet.grabImage(4, 1, 64, 64); 
        squelette[13] = squeletteSpriteSheet.grabImage(5, 1, 64, 64); 
        squelette[14] = squeletteSpriteSheet.grabImage(6, 1, 64, 64); 
        squelette[15] = squeletteSpriteSheet.grabImage(7, 1, 64, 64); 
        squelette[16] = squeletteSpriteSheet.grabImage(8, 1, 64, 64); 
        squelette[17] = squeletteSpriteSheet.grabImage(9, 1, 64, 64);
        
        //Walk Left
        squelette[18] = squeletteSpriteSheet.grabImage(1, 2, 64, 64); 
        squelette[19] = squeletteSpriteSheet.grabImage(2, 2, 64, 64); 
        squelette[20] = squeletteSpriteSheet.grabImage(3, 2, 64, 64); 
        squelette[21] = squeletteSpriteSheet.grabImage(4, 2, 64, 64); 
        squelette[22] = squeletteSpriteSheet.grabImage(5, 2, 64, 64); 
        squelette[23] = squeletteSpriteSheet.grabImage(6, 2, 64, 64); 
        squelette[24] = squeletteSpriteSheet.grabImage(7, 2, 64, 64); 
        squelette[25] = squeletteSpriteSheet.grabImage(8, 2, 64, 64); 
        squelette[26] = squeletteSpriteSheet.grabImage(9, 2, 64, 64);
       
        //Walk Right
        squelette[27] = squeletteSpriteSheet.grabImage(1, 4, 64, 64); 
        squelette[28] = squeletteSpriteSheet.grabImage(2, 4, 64, 64); 
        squelette[29] = squeletteSpriteSheet.grabImage(3, 4, 64, 64); 
        squelette[30] = squeletteSpriteSheet.grabImage(4, 4, 64, 64); 
        squelette[31] = squeletteSpriteSheet.grabImage(5, 4, 64, 64); 
        squelette[32] = squeletteSpriteSheet.grabImage(6, 4, 64, 64); 
        squelette[33] = squeletteSpriteSheet.grabImage(7, 4, 64, 64); 
        squelette[34] = squeletteSpriteSheet.grabImage(8, 4, 64, 64); 
        squelette[35] = squeletteSpriteSheet.grabImage(9, 4, 64, 64);
    }
    
    
    
    
    
    
    
}

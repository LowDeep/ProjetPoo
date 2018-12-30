/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI2;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author dioxo
 */
public class Animation {
    
    private int vitesse;
    private int frames;
    
    private int index = 0;
    private int count = 0;
    
    private BufferedImage[] images;
    private BufferedImage currentImage; 

    public Animation(int vitesse , BufferedImage... args) {
        this.vitesse = vitesse;
        images = new BufferedImage[args.length];
        
        for(int i = 0; i < args.length; i++){
            images[i] = args[i];
        }
        
        frames = args.length;
        
    }
    
    public void runAnimation(){
        index++;
        if(index>vitesse){
            index=0;
            nextFrame();
        }
    }

    private void nextFrame() {
        for(int i = 0; i < frames; i++){
            if(count == i){
                currentImage = images[i];
            }
        }
        
        count++;
        
        if(count > frames){
            count=0;
        }
    }
    
    public void dessinerAnimation(Graphics2D g, int x , int y ){
        g.drawImage(currentImage, x, y,null);
    }
}

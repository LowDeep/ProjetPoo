/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI2;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author dioxo
 */
public class Enemi {
    private int x;
    private int y;
    private int dx = 1, dy = 1;
    private final int ANCHO = 15, ALTO = 15;

    public Enemi(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Rectangle2D getEnemi() {
        return new Rectangle2D.Double(x, y, ANCHO, ALTO);
    }
    
        public void seDeplacer(Rectangle limites, boolean collision) {

        x += dx; 
        y += dy; 
        
        if(collision){ 
            dx=-dx;
            x -= 20;
        }
        
        if( x > limites.getMaxX() ){
            dx = -dx;
        }
        
        if( y > limites.getMaxY()){
            dy = -dy;
        }
        
        
        if(x < 0 ){
            dx = -dx;
        }
        
        if(y < 0 ){
            dy = -dy;

        }
        
    
    }
}
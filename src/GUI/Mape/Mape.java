/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Mape;

import GUI.Ecran;

/**
 *
 * @author dioxo
 */
public abstract class Mape {
    
    private int width;
    private int height;
    private int[] tiles;

    public Mape(int width, int height) {
        this.width = width;
        this.height = height;    
        tiles = new int[width*height];
        
        genererMape();
        
    }

    public Mape(String route) {
        chargerMape(route);
    }
    
    
    
    private void genererMape() {
        
    }

    private void chargerMape(String route) {

    }
    
    public void update(){
        
        
    }
    
    public void montrer(int deltaX, int deltaY, Ecran ecran){
        
    }
    
    
    
}

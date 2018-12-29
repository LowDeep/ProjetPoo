/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Mape.Tile;

import GUI.Ecran;
import GUI.Sprite;

/**
 *
 * @author dioxo
 */
public abstract class Tile {
    public int x, y;
    public Sprite sprite;
    
    //---------------
    public static final Tile Terre = new TileTerre(Sprite.terre);
    
    //---------
    
    
    public Tile(Sprite sprite){
        this.sprite = sprite;
    }

    //metrre montrer en abstract mais, on sait pas
    public abstract void montrer(int x, int y, Ecran ecran);

    public boolean solide(){
        return false;
    }
        
}

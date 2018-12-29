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
public class TileTerre extends Tile{
    
    public TileTerre(Sprite sprite){
        super(sprite);
    }

    @Override
    public void montrer(int x, int y, Ecran ecran) {
        ecran.montrerTile(x,y,(Tile) this);
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author Alex Molinares
 */
public class Sprite {
    private final int lado;
    private int x;
    private int y;
    
    private final SpritesSheet sheet;
    public int[] pixeles;
    
    
    
    //SPREETS SHEETS
    public static Sprite snow = new Sprite(1024, 0, 0, SpritesSheet.snow);
    public static Sprite terre = new Sprite(64, 0, 1, SpritesSheet.textures);
    
    //FIN SPREET SHEET
    

    public Sprite(int lado,final int columna, final int fila, final SpritesSheet sheet) {
        this.lado = lado;
        
        pixeles = new int[lado*lado];
        this.x = columna * lado;
        this.y = fila * lado;
        this.sheet = sheet;
        
        for(int y = 0; y < lado; y++){
            for(int x = 0 ; x < lado; x++){
                pixeles[x+y*lado] = sheet.pixeles[(x+this.x) +
                                    (y+this.y) * sheet.getAncho()];
                
            }
            
        }
        
    }

    public int getLado() {
        return lado;
    }
    
    
    
    
    
}
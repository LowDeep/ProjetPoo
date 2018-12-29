/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.Mape.Tile.Tile;

/**
 *
 * @author Alex Molinares
 */
public final class Ecran {
    private final int WIDHT, HEIGHT;
    
    public final int[] pixels;

    
    
    //Temporaire 
    private final static int LADO_SPRITE = 64;
    private final static int MASCARA_SPRITE = LADO_SPRITE - 1;
    
    //FIN Temporaire
    public Ecran(int WIDHT, int HEIGHT) {
        this.WIDHT = WIDHT;
        this.HEIGHT = HEIGHT;
        pixels = new int[WIDHT* HEIGHT];
    }
    
    public void nettoyer(){
        //Effacer tous les elements de l'ecran
        //mettre couleur noir à tous les pixels pour pouvoir re dessiner
        for(int i = 0; i < pixels.length;i++) {
            pixels[i] = 0;
        }
    }
    
    
    // -----------------TEMPORAL
    public void montrer(final int deltaX, final int deltaY){
        
        //Parcourir de haut en bas, dessiner left to right and up to down
        for(int y = 0 ; y< HEIGHT; y++){
            int positionY = y + deltaY;
            
            //IF -- si on sort de la taille vertical du map, on arret
            if(positionY < 0 || positionY >= HEIGHT){
                continue;
            }
            
            for(int x = 0; x < WIDHT; x++){
                int positionX = x + deltaX;
                
                //IF --  si on sor de la taille horizontal du map, on arret
                if(positionX< 0 || positionX >= WIDHT){
                    continue;
                }
                
                //temporaire
                pixels[positionX + positionY * WIDHT] = Sprite.terre.pixeles[(x & MASCARA_SPRITE) 
                                                        + (y & MASCARA_SPRITE) * LADO_SPRITE];
   
            }
            
        }
    }
    
    public void montrerTile(int deltaX, int deltaY, Tile tile){
        
        for (int y = 0; y < tile.sprite.getLado(); y++) {
            int positionY = y + deltaY;
            
          
            for (int x = 0; x < tile.sprite.getLado(); x++) {
                int positionX = x + deltaX;
                
                //interdire de dessiner dehors du mape
                if(positionX< 0 || positionX >= WIDHT || positionY < 0 || positionY >= HEIGHT){
                    break;
                }
                
                //representation de notre image dans l'ecran
                pixels[positionX + positionY * WIDHT] = tile.sprite.pixeles[x+
                                                        y*tile.sprite.getLado()];
                
                
            }
        }
    }
    
    
}

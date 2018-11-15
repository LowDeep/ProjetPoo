package GUI;

public class Sprite {
    private final int lado;
    private int x;
    private int y;
    
    private final SpritesSheet sheet;
    public int[] pixeles;
    
    
    
    //SPREETS SHEETS
    public static Sprite snow = new Sprite(620, 0, 0, SpritesSheet.snow);
    
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
    
    
    
    
}

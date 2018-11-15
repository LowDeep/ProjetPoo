/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Alex Molinares
 */
                                    //Implementer interface pour pouvoir utiliser Thread
public class Game extends Canvas implements Runnable{
    public static final int WIDTH = 800, HEIGHT = 600;
    //private Canvas canvas;
    private static JFrame ventana;
    private static final String NOM = "NOM DE JEU";
    //thread pour la partie graphique du jeu
    private Thread thread;
    
    private boolean running = false;
    private BufferStrategy bs;
    private Graphics g;
    
    private static BufferedImage imagen = new BufferedImage(WIDTH, HEIGHT , 
            BufferedImage.TYPE_INT_RGB);

    //retourner un array de pixeles
    private static int[] pixeles = ((DataBufferInt) imagen.getRaster().getDataBuffer()).getData();
    
    private static Ecran ecran;
    private static Clavier clavier;
   
    private static int x = 0, y = 0;
    
    public Game() {
         
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        setMaximumSize(new Dimension(WIDTH,HEIGHT));
        setMinimumSize(new Dimension(WIDTH,HEIGHT));
        clavier = new Clavier();
        addKeyListener(clavier);
        
        ecran = new Ecran(WIDTH, HEIGHT);
        
        ventana = new JFrame(NOM);
        
        
        ventana.setTitle("title jeu");
        ventana.setSize(WIDTH, HEIGHT);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setLayout(new BorderLayout());
        //Montrer la fenetre dans la moitie de l'ecran
        ventana.setLocationRelativeTo(null);
        ventana.add(this, BorderLayout.CENTER);
        ventana.pack();
        
        ventana.setVisible(true);
        
       
        
        
        //Recevoir entrés par clavier
        //canvas.setFocusable(true);
        
        //add(canvas);
    }

    private void update(){
        clavier.update();
        if(clavier.up){
            System.out.println("arriba");
        }
        if(clavier.down){
            System.out.println("abajo");
        }
        if(clavier.left){
            System.out.println("izquierda");
        }
        if(clavier.right){
            System.out.println("derecha");
        }
    }
    private void draw(){
        bs = getBufferStrategy();
        
        if(bs==null){
            createBufferStrategy(3);
            return;
        }
        ecran.nettoyer();
        ecran.montrer(x , y);

        System.arraycopy(ecran.pixels, 0, pixeles, 0, pixeles.length);


        g = bs.getDrawGraphics();   
        //------------DESSINER--------------------
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), null);

        //------------------------------
        g.dispose();
        bs.show();


        
    }
    
    @Override
    public void run() {
        requestFocus();
        System.out.println("hi");
        while(running)
        {
            update();
            draw();
        }
        
        stop();
    }
    //Synchronized car on veux pas faire le 2 methores en meme temps, changer l'etat
    //de Running 
    public synchronized void start(){
        //cette classe va utiliser l'interface RUNNABLE
        running = true;

        thread = new Thread(this);
        thread.start();
    }
    
   
    private synchronized void stop(){
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
            running = false;
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Alex Molinares
 */
                                    //Implementer interface pour pouvoir utiliser Thread
public class Window extends JFrame implements Runnable{
    public static final int WIDTH = 800, HEIGHT = 600;
    private Canvas canvas;
    
    //thread pour la partie graphique du jeu
    private Thread thread;
    
    private boolean running = false;
    private BufferStrategy bs;
    private Graphics g;
    public Window() {
        
        setTitle("title jeu");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        //Montrer la fenetre dans la moitie de l'ecran
        setLocationRelativeTo(null);
        
        
        setVisible(true);
        
        canvas = new Canvas();
        
        canvas.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        canvas.setMaximumSize(new Dimension(WIDTH,HEIGHT));
        canvas.setMinimumSize(new Dimension(WIDTH,HEIGHT));
        
        
        //Recevoir entrés par clavier
        canvas.setFocusable(true);
        
        add(canvas);
    }

    private void update(){
        
    }
    private void draw(){
        bs = canvas.getBufferStrategy();
        
        if(bs==null){
            canvas.createBufferStrategy(3);
        }else{
            
            g = bs.getDrawGraphics();   
            //------------DESSINER--------------------
                g.drawRect(0, 0, 100, 100);
            
            //------------------------------
            g.dispose();
            bs.show();
            
            
        }
    }
    
    @Override
    public void run() {

        while(running)
        {
            update();
            draw();
        }
        
        stop();
    }
    
    public void start(){
        //cette classe va utiliser l'interface RUNNABLE
        thread = new Thread(this);
        thread.start();
        running = true;
    }
    
    private void stop(){
        try {
            thread.join();
            running = false;
        } catch (InterruptedException ex) {
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

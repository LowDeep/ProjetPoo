/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author dioxo
 */
public class TableauJeu extends JPanel {

    private final String bgRoute = "/bg.png";
    Image bg;

    TableauJeu() {
        try {
            bg = ImageIO.read(TableauJeu.class.getResource(bgRoute));
            //bg = ImageIO.read(new File("/home/dioxo/Documentos/Universidad/ProjetPoo/src/res/bg.png"));
        } catch (IOException exc) {
            exc.printStackTrace();
        }
        setPreferredSize(new Dimension(790, 600));
        setBackground(Color.WHITE);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
    }

}

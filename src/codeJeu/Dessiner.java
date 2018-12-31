/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codeJeu;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author dioxo
 */
public interface Dessiner {
    public abstract Rectangle2D getHitBox();
    public abstract void dessiner(Graphics2D g2);
}

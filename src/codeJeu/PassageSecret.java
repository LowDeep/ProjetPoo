/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codeJeu;

import GUI2.TableauJeu;
import GUI2.Texture;
import java.awt.Image;

/**
 *
 * @author dioxo
 */
public class PassageSecret extends Objet{
    static Image passageSecret;
    private final String magicienRoute = "/magicien.png";
    private final int HEIGHT = 60, WIDHT = 43;
    Texture texture = TableauJeu.getInstance();
    
    public PassageSecret(int x, int y) {
        super(x, y);
    }
    
}

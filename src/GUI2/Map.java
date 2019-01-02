/**
 *
 */
package GUI2;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

/**
 * @author Low_Deep
 */
public class Map {

    //premiere rang�e
    Rectangle2D piece1 = new Rectangle2D.Double(10, 10, 18, 18);
    Rectangle2D piece2 = new Rectangle2D.Double(30, 10, 18, 18);
    Rectangle2D piece3 = new Rectangle2D.Double(50, 10, 18, 18);
    Rectangle2D piece4 = new Rectangle2D.Double(70, 10, 18, 18);
    Rectangle2D piece5 = new Rectangle2D.Double(90, 10, 18, 18);
    //deuxieme rang�e
    Rectangle2D piece6 = new Rectangle2D.Double(10, 30, 18, 18);
    Rectangle2D piece7 = new Rectangle2D.Double(30, 30, 18, 18);
    Rectangle2D piece8 = new Rectangle2D.Double(50, 30, 18, 18);
    Rectangle2D piece9 = new Rectangle2D.Double(70, 30, 18, 18);
    Rectangle2D piece10 = new Rectangle2D.Double(90, 30, 18, 18);
    //troisieme rang�e
    Rectangle2D piece11 = new Rectangle2D.Double(10, 50, 18, 18);
    Rectangle2D piece12 = new Rectangle2D.Double(30, 50, 18, 18);
    Rectangle2D piece13 = new Rectangle2D.Double(50, 50, 18, 18);
    Rectangle2D piece14 = new Rectangle2D.Double(70, 50, 18, 18);
    Rectangle2D piece15 = new Rectangle2D.Double(90, 50, 18, 18);
    //quatrieme rang�e
    Rectangle2D piece16 = new Rectangle2D.Double(10, 70, 18, 18);
    Rectangle2D piece17 = new Rectangle2D.Double(30, 70, 18, 18);
    Rectangle2D piece18 = new Rectangle2D.Double(50, 70, 18, 18);
    Rectangle2D piece19 = new Rectangle2D.Double(70, 70, 18, 18);
    Rectangle2D piece20 = new Rectangle2D.Double(90, 70, 18, 18);

    Rectangle2D[][] mapa = new Rectangle2D[4][5];

    public Map() {
        mapa[0][0] = piece1;
        mapa[0][1] = piece2;
        mapa[0][2] = piece3;
        mapa[0][3] = piece4;
        mapa[0][4] = piece5;
        mapa[1][0] = piece6;
        mapa[1][1] = piece7;
        mapa[1][2] = piece8;
        mapa[1][3] = piece9;
        mapa[1][4] = piece10;
        mapa[2][0] = piece11;
        mapa[2][1] = piece12;
        mapa[2][2] = piece13;
        mapa[2][3] = piece14;
        mapa[2][4] = piece15;
        mapa[3][0] = piece16;
        mapa[3][1] = piece17;
        mapa[3][2] = piece18;
        mapa[3][3] = piece19;
        mapa[3][4] = piece20;

    }

    public void dessinerMap(Graphics2D g2) {
        g2.setColor(new Color(255, 255, 255, 100));
        g2.fillRect(10, 10, 100, 80);

        for (int i = 0; i < mapa.length; i++) {

            for (int j = 0; j < mapa[i].length; j++) {
                if (!(i == 3 && j == 4)){
                    //System.out.println(i);
                    g2.setColor(new Color(0, 0, 0, 100));

                    g2.fill(mapa[i][j]);

                }
            }
        }
    }

    public void changerCouleurPiece(Graphics2D g2, int x, int y) {
        g2.setColor(Color.black);
        g2.fill(mapa[x][y]);
    }

}

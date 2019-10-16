import org.w3c.dom.css.Rect;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

/**
 * Assignment 6 -- Prisoner's Dilemma -- 2ip90
 * part Patch
 * 
 * @author FILL IN
 * @author FILL IN
 * assignment group FILL IN
 * 
 * assignment copyright Kees Huizing
 */

class Patch extends JComponent {

    private boolean cooperate = true;
    private double score = 0;
    private int posX;
    private int posY;
    public static final int ROW_SIZE = 10;
    public static final int COL_SIZE = 10;
    
    // returns true if and only if patch is cooperating
    boolean isCooperating() {
            return cooperate;// CHANGE THIS
        }

        // set strategy to C if isC is true and to D if false
        void setCooperating(boolean isC) {
            cooperate = isC;
        }

        // change strategy from C to D and vice versa
        void toggleStrategy() {
            cooperate = !cooperate;
        }

        // return score of this patch in current round
        double getScore() {
            return this.score;
        }

        @Override
        protected void paintComponent(Graphics g) {
            g.drawRect(posX, posY, Patch.ROW_SIZE, Patch.COL_SIZE);
        }

        public void draw(Graphics g)
        {
            Graphics2D graphics2D = (Graphics2D)g;
            graphics2D.setPaint(cooperate? Color.BLUE: Color.RED);
            graphics2D.fill(new RoundRectangle2D.Double(posX, posY, Patch.ROW_SIZE, Patch.COL_SIZE,3.0,3.0));
        }

        // setting up the position in terms of coordinates of every Patch
    public Patch(int posX, int posY) {
            this.posX = posX;
            this.posY = posY;
     }
}

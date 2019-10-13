import org.w3c.dom.css.Rect;

import javax.swing.*;
import java.awt.*;

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

    private boolean cooperate = false;
    private double score = 0;
    private int posX;
    private int posY;
    public static final int ROW_SIZE = 20;
    public static final int COL_SIZE = 20;
    
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
        Rectangle rectangle = new Rectangle(posX, posY, Patch.ROW_SIZE, Patch.COL_SIZE);
        g.drawRect(posX, posY, Patch.ROW_SIZE, Patch.COL_SIZE);
        repaint(rectangle);
    }

    // setting up the position in terms of coordinates of every Patch
    public Patch(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }
}

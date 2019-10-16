/**
 * INCOMPLETE
 * Assignment 6 -- Prisoner's Dilemma -- 2ip90
 * part PlayingField
 * 
 * @author FILL IN
 * @author FILL IN
 * assignment group FILL IN
 * 
 * assignment copyright Kees Huizing
 */

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.function.Consumer;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

class PlayingField extends JPanel implements ChangeListener, MouseListener {
    private static double CoordX;
    private static double CoordY;
    private static final int GRID_SIZE = 50;
    private Patch[][] grid = new Patch[GRID_SIZE][GRID_SIZE];
    private  ArrayList<Patch> patches = new ArrayList<>(grid.length * grid.length);
    
    private double alpha; // defection award factor
    
    private Timer timer;
    
    // random number genrator
    private static final long SEED = 37L; // seed for random number generator; any number goes
    public static final Random random = new Random( SEED );         
    
    //...
    public static double getCoordX() {
        return PlayingField.CoordX;
    }

    public static double getCoordY() {
        return PlayingField.CoordY;
    }

    /**
     * calculate and execute one step in the simulation 
     */
    public void step( ) {
        //...
    }
    private void iterator() {

    }
    public void setAlpha( double alpha ) {
        this.alpha = alpha;
    }
    
    public double getAlpha( ) {
        return alpha;
    }
    
    // return grid as 2D array of booleans
    // true for cooperators, false for defectors
    // precondition: grid is rectangular, has non-zero size and elements are non-null
    public boolean[][] getGrid() {
        boolean[][] resultGrid = new boolean[grid.length][grid[0].length];
        for (int x = 0; x < grid.length; x++ ) {
            for (int y = 0; y < grid[0].length; y++ ) {
                resultGrid[x][y] = grid[x][y].isCooperating();
            }
        }
        
        return resultGrid; 
    }
    public void getPatches() {

    }

    public void setPatches() {
        int startX = 0;
        int startY = 0;
        boolean flagX = false;
        boolean flagY = false;

        Patch patch = new Patch(startX, startY);
        for(int i = 0; i < grid.length;i++) {
            for(int y = 0; y < grid[i].length; y++) {
                if(startY/grid.length>=grid.length)
                {
                    startY = 0;
                }
                Patch current = new Patch(flagX ? (startX +=Patch.ROW_SIZE) : startX, flagY ? startY += Patch.COL_SIZE: startY);
                grid[i][y] = current;
                patches.add(current);
                flagX = true;
                flagY = false;
            }
            startX = 0;
            flagY = true;
            flagX = false;
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Consumer<Patch> c = (x) -> x.draw(g);
        patches.forEach(c);
    }

    // sets grid according to parameter inGrid
    // a patch should become cooperating if the corresponding
    // item in inGrid is true
    public void setGrid( boolean[][] inGrid) {
        // ...
    }
    private void setColor(int xCoordinate, int yCoordinate) {
        int rowCell = xCoordinate/(Patch.ROW_SIZE)-1;
        int colCell = yCoordinate/(Patch.COL_SIZE)-3;
        if(rowCell>=grid.length|| colCell>=grid.length) {
            return;
        }
        int index = patches.indexOf(grid[colCell][rowCell]);
        patches.get(index).toggleStrategy();
        repaint();

    }

    @Override
    public void stateChanged(ChangeEvent changeEvent) {
        double currentMeasurement = (double)changeEvent.getSource();
    }
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {}

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        setColor(mouseEvent.getX(), mouseEvent.getY());
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
    }
}


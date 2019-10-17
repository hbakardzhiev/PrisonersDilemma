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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.SwingUtilities;

class PlayingField extends JPanel implements MouseListener, ActionListener {
    private static int GRID_SIZE = 50;

    private Patch[][] grid = new Patch[GRID_SIZE][GRID_SIZE];
    private Patch[][] gridUpdated = new Patch[GRID_SIZE][GRID_SIZE];
    private double alpha = 1.0; // defection award factor
    
    private Timer timer;
    private boolean flag = true;
    // random number genrator
    private static final long SEED = 37L; // seed for random number generator; any number goes
    public static final Random random = new Random( SEED );         
    
    //...
    public PlayingField() {
        setRandom();
        printCoordinatesSet();
    }
    private void setRandom() {
        for(int i = 0; i < grid.length; i++) {
            for(int y = 0; y < grid[i].length; y++) {
                grid[i][y] = new Patch(i, y);
                grid[i][y].setCooperating(random.nextBoolean());

            }
        }
    }

    private void printCoordinatesSet() {
        int startX = 0;
        int startY = 0;
        boolean flagX = false;
        boolean flagY = false;

        Patch patch = new Patch(startX, startY);
        for (int i = 0; i < grid.length; i++) {
            for (int y = 0; y < grid[i].length; y++) {
                if (startY / grid.length >= grid.length) {
                    startY = 0;
                }
                Patch current = new Patch(flagX ? (startX += Patch.ROW_SIZE) : startX, flagY ? startY += Patch.COL_SIZE : startY);
                boolean value = grid[i][y].isCooperating();
                current.setCooperating(value);
                grid[i][y] = current;
                flagX = true;
                flagY = false;
            }
            startX = 0;
            flagY = true;
            flagX = false;
        }
    }
    /**
     * calculate and execute one step in the simulation 
     */
    public void step( ) {
        if(flag) {
            for (int i = 0; i < grid.length; i++) {
                for (int y = 0; y < grid[i].length; y++) {
                    ArrayList<Tuple<Integer, Integer>> neighbours = getNeighbours(i, y);
                    Patch currentElement = grid[i][y];
                    double score = calculateScore(currentElement, neighbours);
                    grid[i][y].setScore(score);
                }
            }

        }
        else {
            for(int i = 0; i < grid.length; i++) {
                for(int y = 0; y < grid[i].length; y++) {
                    ArrayList<Tuple<Integer, Integer>> neighbours = getNeighbours(i, y);
                    neighbours.add(new Tuple<>(i, y));
                    Patch bestStrategyPatch = findMostSuccessfulStrategy(neighbours);
                    grid[i][y] = bestStrategyPatch;
                }
            }
        }
        flag = false;
        printCoordinatesSet();
        repaint();
    }
    private Patch findMostSuccessfulStrategy(ArrayList<Tuple<Integer, Integer>> list) {
        double maxScore = 0;
        int row = 0;
        int col = 0;
        boolean value = false;
        for(Tuple<Integer, Integer> element: list) {
            if(maxScore <= grid[element.getKey()][element.getValue()].getScore()){
                row = element.getKey();
                col = element.getValue();
                value = grid[element.getKey()][element.getValue()].isCooperating();
                maxScore = grid[element.getKey()][element.getValue()].getScore();
            }
        }
        Patch output = new Patch(row, col);
        output.setScore(maxScore);
        output.setCooperating(value);
        return output;
    }
    private double calculateScore(Patch currentElement, ArrayList<Tuple<Integer, Integer>> neighbours) {
        double score = 0;
        if(currentElement.isCooperating()) {
            for(Tuple<Integer, Integer> element: neighbours) {
                if(grid[element.getKey()][element.getValue()].isCooperating()) {
                    score++;
                }
            }
        }
        else {
            for(Tuple<Integer, Integer> element: neighbours) {
                if(!grid[element.getKey()][element.getValue()].isCooperating()) {
                    score += alpha * 1;
                }
            }
        }
        return score;
    }

    private ArrayList<Tuple<Integer, Integer>> getNeighbours(int row, int col) {
        ArrayList<Tuple<Integer, Integer>> list = new ArrayList<>();
        for(int i = row - 1; i <= row + 1;i++) {
            for (int y = col - 1; y <= col + 1; y++) {
                if ((i < 0 || y < 0) || i >= grid.length || y >= grid.length || (row == i && col == y)) {
                    continue;
                }
                Tuple<Integer, Integer> current = new Tuple<>();
                current.setKey(i);
                current.setValue(y);
                list.add(current);
            }
        }
        return list;
    }
    
    public void setAlpha( double alpha ) {
        this.alpha = alpha;
    }
    
    public double getAlpha( ) {
        return alpha;
    }

    @Override
    protected void printComponent(Graphics g) {
        printCoordinatesSet();
        for(Patch[] row: grid) {
            for(Patch item: row) {
                item.draw(g);
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        printCoordinatesSet();
        for(Patch[] row: grid) {
            for(Patch item: row) {
                item.draw(g);
            }
        }
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
    
    // sets grid according to parameter inGrid
    // a patch should become cooperating if the corresponding
    // item in inGrid is true
    public void setGrid( boolean[][] inGrid) {
        for(int i = 0; i < inGrid.length;i++) {
            for(int y = 0; y < inGrid[i].length; y++) {
                Patch current = new Patch(i, y);
                current.setCooperating(inGrid[i][y]);
                grid[i][y] = current;
            }
        }
    }
    private void setColor(int xCoordinate, int yCoordinate) {
        int rowCell = xCoordinate/(Patch.ROW_SIZE)-1;
        int colCell = yCoordinate/(Patch.COL_SIZE)-3;
        if(rowCell>=grid.length|| colCell>=grid.length) {
            return;
        }
        grid[colCell][rowCell].toggleStrategy();
        repaint();

    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) { }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        int coordX = mouseEvent.getX();
        int coordY = mouseEvent.getY();
        setColor(coordX,coordY);
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

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        step();
    }
}


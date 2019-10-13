/**
 * INCOMPLETE
 * Assignment 6 -- Prisoner's Dilemma -- 2ip90
 * main class
 * 
 * @author FILL IN
 * @author FILL IN
 * assignment group FILL IN
 * 
 * assignment copyright Kees Huizing
 */

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
//...

class PrisonersDilemma {
    //...
    private PlayingField playingField = new PlayingField();
    //private ArrayList<Patch> patches = playingField.getPatches();

    private JSlider alphaSlider = new JSlider();
    void buildGUI() {
        alphaSlider.addChangeListener(playingField);
        SwingUtilities.invokeLater( () -> {
//            JFrame frame = new JFrame();
//            frame.add(new Button("Hello"));
//            frame.add(patches.get(3));
//            frame.repaint();
//            frame.add(patches.get(0));
//            frame.repaint();
//            frame.add(patches.get(1));
//            frame.repaint();
//            frame.setSize(1200, 1200);
//            frame.setVisible(true);
            playingField.setLayout(new BorderLayout());
            playingField.setSize(800, 800);
            playingField.setVisible(true);
            playingField.repaint();
        } );
    }
    
    //...
    
    public static void main( String[] a ) {
        (new PrisonersDilemma()).buildGUI();
    }
}

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
//...

class PrisonersDilemma /* possible extends... */ {
    //...
    private PlayingField playingField = new PlayingField();
    private JFrame frame = new JFrame();
    private JButton startButton = new JButton("GO");

    void buildGUI() {
        startButton.addActionListener(playingField);
        SwingUtilities.invokeLater( () -> {
            frame.addMouseListener(playingField);
            frame.add(playingField);
            frame.add(startButton, BorderLayout.SOUTH);
            frame.setSize(800,800);
            frame.setVisible(true);
        } );
    }
    
    //...
    
    public static void main( String[] a ) {
        (new PrisonersDilemma()).buildGUI();
    }
}

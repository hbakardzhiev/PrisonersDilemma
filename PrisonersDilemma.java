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
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
//...

class PrisonersDilemma {
    //...
    private PlayingField playingField = new PlayingField();
    //private ArrayList<Patch> patches = playingField.getPatches();
    JFrame frame;
  //  Painting painting;
    JButton resetButton;
    JButton goButton;
    JButton startButton;
    JSlider alphaSlider;

    void buildGUI() {
        SwingUtilities.invokeLater(() -> {

            //         painting = new Painting();
            //       frame = new JFrame("Computer Assisted Random Artist");
            //       frame.add(painting, BorderLayout.CENTER);
            //           regenerateButton = new JButton("Regenerate");
            //              regenerateButton.addActionListener(painting); // painting provides reaction to buttonclick
            frame.add(regenerateButton, BorderLayout.SOUTH);
            startButton = new JButton("Start");
            startButton.addActionListener(painting);
            frame.add(startButton, BorderLayout.SOUTH);
            frame.pack();
            painting.regenerate(); // can be done here since painting has a size!
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);






                painting = new Painting();
                frame = new JFrame("Prisoner's Dilemma");
                frame.add(painting, BorderLayout.CENTER);
                frame.add(new Button(""));

                resetButton = new JButton("Reset");
                resetButton.addActionListener(painting);
                frame.add(startButton, BorderLayout.SOUTH);
                frame.add(resetButton, BorderLayout.SOUTH);

                frame.add(goButton, BorderLayout.SOUTH);
                frame.add(resetButton, BorderLayout.SOUTH);
                alphaSlider.addChangeListener(playingField);
//            frame.add(patches.get(3));
//            frame.repaint();
//            frame.add(patches.get(0));
//            frame.repaint();
//            frame.add(patches.get(1));
//            frame.repaint();
//            frame.setSize(1200, 1200);
                frame.setVisible(true);
                playingField.setLayout(new BorderLayout());
                playingField.setSize(800, 800);
                playingField.setVisible(true);
                playingField.repaint();
            });
        }
    //...
    
    public static void main( String[] a ) {
        (new PrisonersDilemma()).buildGUI();
    }
}

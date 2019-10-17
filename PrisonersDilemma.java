/**
 * INCOMPLETE
 * Assignment 6 -- Prisoner's Dilemma -- 2ip90
 * main class
 *
 * @author FILL IN
 * @author FILL IN
 * assignment group FILL IN
 * <p>
 * assignment copyright Kees Huizing
 */

import javafx.print.PageLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
//...

class PrisonersDilemma {
    //...
    private PlayingField playingField = new PlayingField();
    //private ArrayList<Patch> patches = playingField.getPatches();
    JFrame frame;
    JPanel buttons;
    JButton resetButton;
    JButton pauseButton;
    JButton goButton;
    JSlider alphaSlider;
    JSlider timerSlider;
    JTextArea alphaText;
    JTextArea timeText;

    void buildGUI() {
        SwingUtilities.invokeLater(() -> {

            frame = new JFrame("Prisoner's Dilemma");
            resetButton = new JButton("Reset");
            pauseButton = new JButton("Pause");
            goButton = new JButton("Go");
            alphaText= new JTextArea("Alpha");
            timeText= new JTextArea("Timer");

            alphaSlider = new JSlider(JSlider.HORIZONTAL, 0, 3, 1);
            alphaSlider.setName("Alpha Value");
            timerSlider = new JSlider(JSlider.HORIZONTAL, 0, 60, 30);
            timerSlider.setName("Frequency");

            buttons = new JPanel();


            alphaSlider.setMajorTickSpacing(1);
            alphaSlider.setPaintLabels(true);
            alphaSlider.setPaintTicks(true);
            timerSlider.setMajorTickSpacing(10);
            timerSlider.setPaintTicks(true);
            timerSlider.setPaintLabels(true);

            resetButton.addActionListener(playingField); // painting provides reaction to button click
            goButton.addActionListener(playingField);
            pauseButton.addActionListener(playingField);
            alphaSlider.addChangeListener(playingField);
            timerSlider.addChangeListener(playingField);

            buttons.add(goButton);
            buttons.add(resetButton);
            buttons.add(pauseButton);
            buttons.add(alphaText);
            buttons.add(alphaSlider);
            buttons.add(timeText);
            buttons.add(timerSlider);



            frame.add(buttons, BorderLayout.SOUTH);

            frame.setSize(800, 800);
            playingField.setSize(800,800);
            frame.setVisible(true);
            playingField.setLayout(new BorderLayout());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            playingField.repaint();
        });
    }
    //...

    public static void main(String[] a) {
        (new PrisonersDilemma()).buildGUI();
    }
}

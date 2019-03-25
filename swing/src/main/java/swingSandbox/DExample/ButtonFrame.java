package swingSandbox.DExample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonFrame extends JFrame {
    private JPanel buttonPanel = new JPanel();
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 300;

    public ButtonFrame(){

        // Utworzenie przycisków
        JButton yellowButton = new JButton("Yellow");
        JButton blueButton = new JButton("Blue");
        JButton redButton = new JButton("Red");

        // Dodanie przycisków do panelu ramki
        buttonPanel.add(yellowButton);
        buttonPanel.add(blueButton);
        buttonPanel.add(redButton);

        // Dodanie panelu do ramki
        add(buttonPanel);

        // Utworzenie akcji przycisków
        ColorAction yellowAction = new ColorAction(Color.YELLOW);
        ColorAction blueAction = new ColorAction(Color.BLUE);
        ColorAction redAction = new ColorAction(Color.RED);

        // Powiązanie akcji z przyciskami
        yellowButton.addActionListener(yellowAction);
        blueButton.addActionListener(blueAction);
        redButton.addActionListener(redAction);

        setTitle("My Button frame");
        setLocationByPlatform(true);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private class ColorAction implements ActionListener {
        private Color backgroundColor;

        public ColorAction(Color color){
            backgroundColor = color;
        }

        @Override
        public void actionPerformed(ActionEvent event){
            buttonPanel.setBackground(backgroundColor);
        }
    }
}

package swingSandbox.EExample;

import javax.swing.*;
import java.awt.*;

public class ButtonFrame extends JFrame{
    private JPanel buttonPanel = new JPanel();
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 300;

    public ButtonFrame(){

        addButtonToPanel("Blue", Color.BLUE);
        addButtonToPanel("Green", Color.GREEN);
        addButtonToPanel("White", Color.white);
        add(buttonPanel);

        setTitle("My Button frame");
        setLocationByPlatform(true);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void addButtonToPanel(String name, Color color){
        JButton button = new JButton(name);
        buttonPanel.add(button);
        button.addActionListener(event ->
            buttonPanel.setBackground(color));
    }
}

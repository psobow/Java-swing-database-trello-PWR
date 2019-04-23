package swingSandbox.swingTutorial.tut02;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private JButton button;
    private JTextArea textArea;

    public MainFrame(){
        super("Hello World!");

        setLayout(new BorderLayout());

        button = new JButton("Click me!");
        textArea = new JTextArea();

        add(textArea, BorderLayout.CENTER);
        add(button, BorderLayout.SOUTH);

        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

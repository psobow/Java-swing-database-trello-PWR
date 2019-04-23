package swingSandbox.swingTutorial;

import javax.swing.*;
import java.awt.*;

public class AppRunner {

    public static void main(String args[]){
        EventQueue.invokeLater(() -> {
            JFrame frame = new JFrame("Hello World!");

            frame.setSize(600,600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

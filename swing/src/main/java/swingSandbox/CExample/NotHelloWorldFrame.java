package swingSandbox.CExample;

import javax.swing.*;

public class NotHelloWorldFrame extends JFrame {
    public NotHelloWorldFrame(){
        add(new NotHelloWorldComponent());
        pack();

        setTitle("Not Hello World");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

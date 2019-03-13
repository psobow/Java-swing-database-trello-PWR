package swingSandbox.CExample;

import javax.swing.*;
import java.awt.*;

public class NotHelloWorldComponent extends JComponent {
    public static final int MESSAGE_X = 75;
    public static final int MESSAGE_Y = 100;

    private static final int PREFERRED_FRAME_WIDTH = 300;
    private static final int PREFERRED_FRAME_HEIGHT = 300;

    @Override
    public void paintComponent(Graphics g){
        g.drawString("Hello World!", MESSAGE_X, MESSAGE_Y);
    }

    @Override
    public Dimension getPreferredSize(){
        return new Dimension(PREFERRED_FRAME_WIDTH, PREFERRED_FRAME_HEIGHT);
    }
}

package swingSandbox.BExample;

import javax.swing.*;
import java.awt.*;

public class SizedFrameTest {
    public static void main(String[] args){
        EventQueue.invokeLater(() ->
        {
            JFrame frame = new SizedFrame();
        });
    }
}

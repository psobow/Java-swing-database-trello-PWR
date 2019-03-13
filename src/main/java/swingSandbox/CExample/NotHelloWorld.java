package swingSandbox.CExample;

import javax.swing.*;
import java.awt.*;

public class NotHelloWorld {
    public static void main(String[] args){
        EventQueue.invokeLater(() ->
        {
            JFrame frame = new NotHelloWorldFrame();
        });
    }
}

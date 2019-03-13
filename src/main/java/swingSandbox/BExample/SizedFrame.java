package swingSandbox.BExample;

import javax.swing.*;
import java.awt.*;

public class SizedFrame extends JFrame {
    public SizedFrame(){

        // sprawdzenie wymiarów ekranu
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        // ustawienie szerokości i wysokości oraz lewy górny rok okienka w lewym górnym rogu ekranu
        setSize(screenWidth / 2, screenHeight / 2);
        setLocation(0, 0);
        //setLocationByPlatform(true);


        setTitle("Sized Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

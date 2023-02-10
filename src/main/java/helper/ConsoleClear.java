package helper;

import java.awt.*;
import java.io.Console;

public class ConsoleClear {

    public static void clear() {
        //System.out.print("Everything on the console will cleared");
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    //die nuttenkacke funktioniert noch nicht
/*
    public static void main(String[] args) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth() / 2;
        int height = (int) screenSize.getHeight() / 2;

        // Set the console size
        Console c = System.console();
        if (c != null) {
            c.getFrame().setSize(width, height);
        } else {
            System.out.println("Could not resize the console window.");
        }
    }

 */

}

import java.awt.Color;

import javax.swing.JFrame;

import view.LoginFrame;


// Main application file

public class App {


    public static void main(String[] args){

        JFrame window = new JFrame();
        window.setBackground(Color.LIGHT_GRAY);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocation(300, 100);


        var activeFrame = new LoginFrame(window);

        activeFrame.init();
        window.pack();
        window.setVisible(true);

        

    }

}
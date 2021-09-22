import javax.swing.JFrame;

import view.LoginFrame;
import view.MainFrame;

// Main application file

public class App {


    public static void main(String[] args){

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocation(550, 350);

        var activeFrame = new MainFrame(window);

        activeFrame.init();
        window.pack();
        window.setVisible(true);
        

    }

}
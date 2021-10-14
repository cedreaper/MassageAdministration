import java.awt.Color;

import javax.swing.JFrame;

import view.ClientFrame;
import view.HistoryFrame;
import view.LoginFrame;
import view.MainFrame;
import view.MedicalFrame;
import view.NotesFrame;

// Main application file

public class App {


    public static void main(String[] args){

        JFrame window = new JFrame();
        window.setBackground(Color.LIGHT_GRAY);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocation(550, 350);


        var activeFrame = new LoginFrame(window);

        activeFrame.init();
        window.pack();
        window.setVisible(true);

        

    }

}
package view;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;



public class LoginFrame  extends JFrame {

    // singleton pattern for the window

    private static LoginFrame loginFrame;
    private final int WDO_HEIGHT = 300; 
    private final int WDO_WIDTH = 400;

    /////Labels//////
    private JLabel copyright = new JLabel("Copyright 2021  >>| Cedric Green |<<");     JLabel company = new JLabel("Company Name Here", SwingConstants.CENTER);
    private JLabel username = new JLabel("Username: ");
    private JLabel password = new JLabel("Password: ");

    //////Buttons/////
    private JButton forgotPassword = new JButton("Forgot Password");
    private JButton login = new JButton("Login");
    private JButton register = new JButton("Register");

    ///// Textfields ////////
    private JTextField userText = new JTextField();
    private JTextField userPass = new JTextField();




    private LoginFrame() {
        
       
    }


    public static LoginFrame getLoginFrame(){

        // if loginFrame obj does not yet exit create.
        if(loginFrame == null) {
            
            loginFrame = new LoginFrame();

        }

        // if exists return the single obj

        return loginFrame;
    }

    public void loadFrame(){

        //*** setting up the login screen ***
        Container cp = loginFrame.getContentPane();
        loginFrame.setSize(WDO_WIDTH, WDO_HEIGHT);
        loginFrame.setTitle("Login - Company Name Here");

        ////////Panel & Subpanels///////////
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);

        JPanel sSubPanel = new JPanel();
        sSubPanel.setBackground(Color.LIGHT_GRAY);

        JPanel wSubPanel = new JPanel();
        wSubPanel.setBackground(Color.LIGHT_GRAY);

        JPanel nSubPanel = new JPanel();
        JPanel nSubPanel2 = new JPanel();
        nSubPanel2.setLayout(new GridLayout(1,1));
        nSubPanel2.setBackground(Color.LIGHT_GRAY);

        JPanel eSubPanel = new JPanel();
        JPanel eSubPanel2 = new JPanel();
        eSubPanel.setLayout(new BorderLayout());
        eSubPanel.setBackground(Color.LIGHT_GRAY);

       

        ////Label Attributes////
        company.setSize(50, 50);
        company.setFont(new Font("Arial Black", Font.PLAIN, 20));
 
        username.setFont(new Font("Arial", Font.PLAIN, 14));        
        password.setFont(new Font("Arial", Font.PLAIN, 14));


        /////adding secondary panels attributes/////
        sSubPanel.add(copyright, BorderLayout.CENTER);

     
        wSubPanel.add(forgotPassword);
        wSubPanel.add(login);
        wSubPanel.add(register);

        nSubPanel.setLayout(new GridLayout(1,1));
        nSubPanel.setBackground(Color.LIGHT_GRAY);
        nSubPanel.add(company, BorderLayout.NORTH);
        nSubPanel.add(nSubPanel2, BorderLayout.SOUTH);
        nSubPanel2.add(username, BorderLayout.WEST);
        nSubPanel2.add(userText, BorderLayout.CENTER);

        eSubPanel.add(eSubPanel2, BorderLayout.SOUTH);
        eSubPanel.add(password, BorderLayout.WEST);
        eSubPanel.add(userPass, BorderLayout.CENTER);

        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setLocation(550, 350);
        loginFrame.setVisible(true);

        panel.setLayout(new BorderLayout());
        panel.add(sSubPanel, BorderLayout.SOUTH);
        panel.add(wSubPanel, BorderLayout.WEST);
        panel.add(nSubPanel, BorderLayout.NORTH);
        
        
        cp.add(panel);
    }

}

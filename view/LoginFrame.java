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



public class LoginFrame  {

    private JFrame window;
    private int WDO_HEIGHT = 250; 
    private int WDO_WIDTH = 400;

    /////Labels//////
    private JLabel copyright = new JLabel("Copyright 2021  >>| Cedric Green |<<");     
    private JLabel company = new JLabel("Company Name Here", SwingConstants.CENTER);
    private JLabel username = new JLabel("Username:", SwingConstants.CENTER);
    private JLabel password = new JLabel("Password:", SwingConstants.CENTER);

    //////Buttons/////
    private JButton forgotPassword = new JButton("Forgot Password");
    private JButton login = new JButton("Login");
    private JButton register = new JButton("Register");

    ///// Textfields ////////
    private JTextField userText = new JTextField(SwingConstants.LEFT);
    private JTextField userPass = new JTextField(SwingConstants.LEFT);


    public LoginFrame(JFrame window) {

        this.window = window;
    }



    public void init() {

        //*** setting up the login screen ***
        Container cp = window.getContentPane();
        window.setSize(WDO_WIDTH, WDO_HEIGHT);
        window.setTitle("Login - Company Name Here");
        

        ////////Panel & Subpanels//////////
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        panel.setBackground(Color.LIGHT_GRAY);

        JPanel copywrightPanel = new JPanel();
        copywrightPanel.add(copyright);
        copywrightPanel.setBackground(Color.LIGHT_GRAY);

        JPanel southPanel = new JPanel();
        southPanel.setBackground(Color.LIGHT_GRAY);
        

        JPanel northPanel = new JPanel();
        northPanel.setBackground(Color.LIGHT_GRAY);

        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.LIGHT_GRAY);
        centerPanel.setLayout(new GridLayout(2, 2));

       

        ////Label Attributes////
        company.setSize(50, 50);
        company.setFont(new Font("Arial Black", Font.PLAIN, 20));
 
        username.setFont(new Font("Arial", Font.BOLD, 14));        
        password.setFont(new Font("Arial", Font.BOLD, 14));


        /////adding attributes to panels/////

     
        southPanel.add(forgotPassword);
        southPanel.add(login);
        southPanel.add(register);

        northPanel.add(company, BorderLayout.NORTH);
        
        centerPanel.add(username);
        centerPanel.add(userText);

        centerPanel.add(password);
        centerPanel.add(userPass);

       
       
        
        cp.setLayout(new GridLayout(4, 1));
        cp.setBackground(Color.LIGHT_GRAY);
        cp.add(northPanel);
        cp.add(centerPanel);
        cp.add(southPanel);
        cp.add(copywrightPanel);
    }

}

package view;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.File;
import java.util.Scanner;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;



public class LoginFrame  {

    ///////Main Frame////////

    private MainFrame mainFrame;

    private JFrame window;
    private int WDO_HEIGHT = 250; 
    private int WDO_WIDTH = 400;

    /////Labels//////
    private JLabel copyright = new JLabel("Copyright 2021  >>| Cedric Green |<<");     
    private JLabel company = new JLabel("Scissortail Massage", SwingConstants.CENTER);
    private JLabel username = new JLabel("Username:", SwingConstants.CENTER);
    private JLabel password = new JLabel("Password:", SwingConstants.CENTER);

    //////Buttons/////
    private JButton forgotPassword = new JButton("Forgot Password");
    private JButton login = new JButton("Login");

    ///// Textfields ////////
    private JTextField userText = new JTextField();
    private JPasswordField userPass = new JPasswordField();

    private int counter = 0;

    //////// user file /////////

    private File userFile;
    private Scanner fileIn;

    private String user;
    private String pass;

    private Boolean isValidUser = false;


    public LoginFrame(JFrame window) {

        this.window = window;
        
    }



    public void init() {
         
        userPass.setEchoChar('*');

        //check file for availability
        try {

            fileIn = new Scanner(new File("mcdb/userconfig.txt"));
            user = fileIn.nextLine();
            pass = fileIn.nextLine();

            fileIn.close();
            

        }
        catch (Exception e) {

            JOptionPane.showMessageDialog(window, "User Configuration File not found.\n" + 
                "Please reinstall software or email ScissortailIT@gmail.com\n" +
                "Login will not work until fixed...");
        }
        

        //*** setting up the login screen ***
        Container cp = window.getContentPane();
        window.setSize(WDO_WIDTH, WDO_HEIGHT);
        window.setTitle("Login - Scissortail Massage");
        window.setLocation(500,250);
        

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

        //login frame will have its own button listener lambdas since only 2 buttons

        forgotPassword.addActionListener( e ->  {
            
            JOptionPane.showMessageDialog(window, "If you are the administrator..\nplease refer to your instructions.\n" +
            "Otherwise.. please contact the business\nowner for access permissions.");
        });

        login.addActionListener(e -> {

            
            String passWord = new String(userPass.getPassword());
            if(userText.getText().toLowerCase().equals(user) &&
            passWord.equals(pass)) {

                isValidUser = true;

            }

            
            if(isValidUser) {

                window.dispose();

                if(counter == 0) {
    
                    JFrame window2 = new JFrame();
                    window2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    mainFrame = new MainFrame(window2, this);
                    mainFrame.init();
                    window2.pack();
                    window2.setVisible(true); 
                }

            }
            else {

                JOptionPane.showMessageDialog(window, "                      ACCESS DENIED\n" +
                        "You have entered an invalid username or password.\n" +
                        "Please try again or contact the business owner.");
            }
          
            
          

        });
        

    }

    public JFrame getWindow() {

        return window;
    }

    public File getUserFile() {

        return userFile;
    }

}

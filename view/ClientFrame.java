package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;


public class ClientFrame {
    
    private JFrame window;

    private int height = 600;
    private int width = 800;

    private JButton editButton = new JButton("Update");
    private JButton confirmButton = new JButton("Confirm");
    private JButton notesButton = new JButton("Notes");
    private JButton historyButton = new JButton("History");

    private JLabel clientFrameTitle = new JLabel("Client Information", SwingConstants.CENTER);
    private JLabel clientNameLabel = new JLabel("Name: ", SwingConstants.LEFT);
    private JLabel phoneLabel = new JLabel("Phone: ");
    private JLabel emailLabel = new JLabel("Email: ");
    private JLabel workLabel = new JLabel("Work #: ");
    private JLabel addressLabel = new JLabel("Address: ");
    private JLabel addressCityLabel = new JLabel("City: ");
    private JLabel addressStateLabel = new JLabel("State: ");
    private JLabel zipLabel = new JLabel("Zip Code: ");
    private JLabel nextAppointmentLabel = new JLabel("Next Appointment: ");
    private JLabel emergencyName = new JLabel("Name: ");
    private JLabel emergencyPhone = new JLabel("Phone: ");
    private JLabel serviceType = new JLabel("Service Type: ");
    private JLabel price = new JLabel("Price: "); 
    private JLabel errorLabel = new JLabel("Error: Check Fields");


    private JTextField priceText = new JTextField(10);
    private JTextField serviceTypeText = new JTextField(25);
    private JTextField nextAppointmentText = new JTextField(20);
    private JTextField emergencyNameText = new JTextField(25);
    private JTextField emergencyPhoneText = new JTextField(20);
    private JTextField clientNameText = new JTextField(25);
    private JTextField phoneText = new JTextField(25);
    private JTextField emailText = new JTextField(25);
    private JTextField workText = new JTextField(25);
    private JTextField addressText = new JTextField(20);
    private JTextField addressCityText = new JTextField(20);
    private JTextField addressStateText = new JTextField(5);
    private JTextField zipText = new JTextField(10);

    private MainFrame panel;

    public ClientFrame(JFrame window, MainFrame panel) {

        this.window = window;
        window.setTitle("Client Info - Scissortail Massage");
        window.setPreferredSize(new Dimension(width, height));
        window.setLocation(300,100);

        this.panel = panel;
    }

    public void init() {

        Container cp = window.getContentPane();
        cp.setLayout(new GridLayout(3,1));
        cp.setBackground(Color.LIGHT_GRAY);
        JPanel panelOne = new JPanel();
        JPanel panelTwo = new JPanel();
        JPanel panelThree = new JPanel();

        errorLabel.setVisible(false);
        errorLabel.setForeground(Color.red);
       

        //sub panels
        JPanel sOne = new JPanel();
        JPanel sTwo = new JPanel();
        JPanel sThree = new JPanel();
        JPanel sFour = new JPanel();
        JPanel sFive = new JPanel();
        JPanel sSix = new JPanel();
        JPanel sSeven = new JPanel();
        JPanel sEight = new JPanel();


        clientFrameTitle.setFont(new Font("Arial Black", Font.BOLD, 26));

        sOne.setBackground(Color.LIGHT_GRAY);
        sTwo.setBackground(Color.LIGHT_GRAY);
        sThree.setBackground(Color.LIGHT_GRAY);
        sFour.setBackground(Color.LIGHT_GRAY);
        sFive.setBackground(Color.LIGHT_GRAY);
        sSix.setBackground(Color.LIGHT_GRAY);
        sSeven.setBackground(Color.LIGHT_GRAY);
        sEight.setBackground(Color.LIGHT_GRAY);

        panelOne.setBackground(Color.LIGHT_GRAY);
        panelTwo.setBackground(Color.LIGHT_GRAY);
        panelThree.setBackground(Color.LIGHT_GRAY);
        
        TitledBorder contactBorder = new TitledBorder("Contact Details");

        panelOne.add(clientFrameTitle);
        panelOne.setBorder(contactBorder);

        panelOne.setLayout(new GridLayout(5,2));
        panelOne.add(sOne);
        sOne.add(clientNameLabel);
        sOne.add(clientNameText);
        sOne.add(phoneLabel);
        sOne.add(phoneText);

        
        sTwo.add(emailLabel);
        sTwo.add(emailText);
        sTwo.add(workLabel);
        sTwo.add(workText);

        panelOne.add(sTwo);

        sThree.add(addressLabel);
        sThree.add(addressText);
        sThree.add(addressCityLabel);
        sThree.add(addressCityText);
        sThree.add(addressStateLabel);
        sThree.add(addressStateText);

        panelOne.add(sThree);

        sFour.add(zipLabel);
        sFour.add(zipText);
        

        panelOne.add(sFour);

        panelTwo.setLayout(new GridLayout(3,2));

        TitledBorder emergency = new TitledBorder("Emergency Contact Information");
        sFive.setBorder(emergency);

        sFive.add(emergencyName);
        sFive.add(emergencyNameText);
        sFive.add(emergencyPhone);
        sFive.add(emergencyPhoneText);

        panelTwo.add(sFive);

        TitledBorder serviceInfo = new TitledBorder("Service Information");
        sSix.setBorder(serviceInfo);

        sSix.add(serviceType);
        sSix.add(serviceTypeText);
        sSix.add(price);
        sSix.add(priceText);


        panelTwo.add(sSix);

        TitledBorder filler = new TitledBorder("Schedule Next Appointment");
        sSeven.setBorder(filler);
        sSeven.add(nextAppointmentLabel);
        sSeven.add(nextAppointmentText);

        panelTwo.add(sSeven);

        sEight.add(editButton);
        sEight.add(notesButton);
        sEight.add(editButton);
        sEight.add(historyButton);
        sEight.add(confirmButton);

        panelThree.add(sEight);
        panelThree.add(errorLabel);

        //disable text fields until edit button selected

        clientNameText.setEnabled(false);
        phoneText.setEnabled(false);
        emailText.setEnabled(false);
        workText.setEnabled(false);
        addressText.setEnabled(false);
        addressCityText.setEnabled(false);
        addressStateText.setEnabled(false);
        zipText.setEnabled(false);
        nextAppointmentText.setEnabled(false);
        serviceTypeText.setEnabled(false);
        priceText.setEnabled(false);
        emergencyNameText.setEnabled(false);
        emergencyPhoneText.setEnabled(false);



        cp.add(panelOne);
        cp.add(panelTwo);
        cp.add(panelThree);
        
       


        
        
    }
}
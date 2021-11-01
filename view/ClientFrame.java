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

import controller.MainButtonListener;
import model.Client;
import model.ClientDB;


public class ClientFrame {
    
    private JFrame window;

    private Client client;

    private boolean addingClient = false;

    private int height = 600;
    private int width = 800;

    private JButton editButton = new JButton("Update");
    private JButton confirmButton = new JButton("Confirm");
    private JButton notesButton = new JButton("Notes");
    private JButton historyButton = new JButton("History");
    private JButton medicalButton = new JButton("Medical");
    private JButton exitButton = new JButton("Exit");

    private JLabel clientFrameTitle = new JLabel("Client Information", SwingConstants.CENTER);
    private JLabel clientNameLabel = new JLabel("Name: ", SwingConstants.LEFT);
    private JLabel phoneLabel = new JLabel("Phone: ");
    private JLabel emailLabel = new JLabel("Email: ");
    private JLabel workLabel = new JLabel("Work #: ");
    private JLabel addressLabel = new JLabel("Address: ");
    private JLabel addressCityLabel = new JLabel("City: ");
    private JLabel addressStateLabel = new JLabel("State: ");
    private JLabel zipLabel = new JLabel("Zip Code: ");
    private JLabel nextAppointmentLabel = new JLabel("Next Appointment(YYYY-MM-DD): ");
    private JLabel nextAppointmentTime = new JLabel("Time(XXPM): ");
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
    private JTextField nextAppointmentTimeText = new JTextField(10);


    public ClientFrame(JFrame window) {

        this.window = window;
        window.setPreferredSize(new Dimension(width, height));
        window.setLocation(300,100);

        this.window = window;
    }

    public void init() {

        //test client populate text
       //ClientDB.setSelectedClient(0);

        Container cp = window.getContentPane();
        cp.setLayout(new GridLayout(3,1));
        cp.setBackground(Color.LIGHT_GRAY);
        JPanel panelOne = new JPanel();
        JPanel panelTwo = new JPanel();
        JPanel panelThree = new JPanel();

        confirmButton.setEnabled(false);
        errorLabel.setVisible(false);
        errorLabel.setForeground(Color.red);


        priceText.setText("$");

        //fill textFields
        client = ClientDB.getSelectedClient();
        fillTextFields();
       

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
        sSeven.add(nextAppointmentTime);
        sSeven.add(nextAppointmentTimeText);

        nextAppointmentTimeText.setEditable(false);

        panelTwo.add(sSeven);

        sEight.add(editButton);
        sEight.add(notesButton);
        sEight.add(editButton);
        sEight.add(historyButton);
        sEight.add(confirmButton);
        sEight.add(medicalButton);
        sEight.add(exitButton);

        panelThree.add(sEight);
        panelThree.add(errorLabel);

        //disable text field editing until edit button selected

        clientNameText.setEditable(false);
        phoneText.setEditable(false);
        emailText.setEditable(false);
        workText.setEditable(false);
        addressText.setEditable(false);
        addressCityText.setEditable(false);
        addressStateText.setEditable(false);
        zipText.setEditable(false);
        nextAppointmentText.setEditable(false);
        serviceTypeText.setEditable(false);
        priceText.setEditable(false);
        emergencyNameText.setEditable(false);
        emergencyPhoneText.setEditable(false);



        cp.add(panelOne);
        cp.add(panelTwo);
        cp.add(panelThree);
        
    }

    public JFrame getWindow() {

        return window;

    }

    public JButton getUpdateButton() {

        return editButton;
    }

    public JButton getExitButton() {

        return exitButton;
    }

    public JButton getMedicalButton() {

        return medicalButton;
    }

    public JButton getHistoryButton() {

        return historyButton;
    }

    public JButton getConfirmButton() {

        return confirmButton;
    }

    public JButton getNotesButton() {

        return notesButton;
    }

    public JTextField getAddressCityText() {
        return addressCityText;
    }

    public JTextField getAddressStateText() {
        return addressStateText;
    }

    public JTextField getClientNameText() {
        return clientNameText;
    }

    public JTextField getAddressText() {
        return addressText;
    }

    public JTextField getEmailText() {
        return emailText;
    }
    public JTextField getEmergencyPhoneText() {
        return emergencyPhoneText;
    }

    public JTextField getEmergencyNameText() {
        return emergencyNameText;
    }

    public JTextField getNextAppointmentText() {
        return nextAppointmentText;
    }

    public JTextField getNextAppointmentTimeText() {
        return nextAppointmentTimeText;
    }

    public JTextField getPhoneText() {
        return phoneText;
    }

    public JTextField getPriceText() {
        return priceText;
    }

    public JTextField getServiceTypeText() {
        return serviceTypeText;
    }

    public JTextField getWorkText() {
        return workText;
    }

    public JTextField getZipText() {
        return zipText;
    }
    
    public void enableTextFields() {

        clientNameText.setEditable(true);
        phoneText.setEditable(true);
        emailText.setEditable(true);
        emergencyNameText.setEditable(true);
        emergencyPhoneText.setEditable(true);
        addressCityText.setEditable(true);
        addressStateText.setEditable(true);
        addressText.setEditable(true);
        zipText.setEditable(true);
        priceText.setEditable(true);
        serviceTypeText.setEditable(true);
        nextAppointmentText.setEditable(true);
        workText.setEditable(true);
        nextAppointmentTimeText.setEditable(true);

    }

    public void disableTextFields() {
        
        clientNameText.setEditable(false);
        phoneText.setEditable(false);
        emailText.setEditable(false);
        emergencyNameText.setEditable(false);
        emergencyPhoneText.setEditable(false);
        addressCityText.setEditable(false);
        addressStateText.setEditable(false);
        addressText.setEditable(false);
        zipText.setEditable(false);
        priceText.setEditable(false);
        serviceTypeText.setEditable(false);
        nextAppointmentText.setEditable(false);
        workText.setEditable(false);
        nextAppointmentTimeText.setEditable(false);

    }

    private void fillTextFields() {
        //populate text fields with client info
        if(client != null) {

            clientNameText.setText(client.getName());
            phoneText.setText(client.getPhone());
            emailText.setText(client.getEmail());
            emergencyNameText.setText(client.getEmergencyName());
            emergencyPhoneText.setText(client.getEmergencyPhone());
            addressCityText.setText(client.getCity());
            addressStateText.setText(client.getState());
            addressText.setText(client.getAddress());
            zipText.setText(client.getZip());
            priceText.setText(client.getPrice());
            serviceTypeText.setText(client.getServiceType());
            nextAppointmentText.setText(client.getNextAppointment());
            workText.setText(client.getWorkPhone());
            nextAppointmentTimeText.setText(client.getAppointmentTime());

        }
  

    }

    public void clearTextFields() {

        //clear textfields for new client addition

        clientNameText.setText("");
        phoneText.setText("");
        emailText.setText("");
        emergencyNameText.setText("");
        emergencyPhoneText.setText("");
        addressCityText.setText("");
        addressStateText.setText("");
        addressText.setText("");
        zipText.setText("");
        priceText.setText("");
        serviceTypeText.setText("");
        nextAppointmentText.setText("");
        workText.setText("");
        nextAppointmentTimeText.setText("");
    }

    public boolean getAddingNewClient() {

        return addingClient;
    }

    public void setAddingClient(boolean addingClient) {
        this.addingClient = addingClient;
    }

    public void createNewClient() {

        //handle createion of new clients from main client add click
        Client c = new Client(clientNameText.getText(), phoneText.getText());

        c.setEmail(emailText.getText());
        c.setEmergencyName(emergencyNameText.getText());
        c.setEmergencyPhone(emergencyPhoneText.getText());
        c.setCity(addressCityText.getText());
        c.setState(addressStateText.getText());
        c.setAddress(addressText.getText());
        c.setZip(zipText.getText());
        c.setPrice(priceText.getText());
        c.setServiceType(serviceTypeText.getText());
        c.setNextAppointment(nextAppointmentText.getText());
        c.setWorkPhone(workText.getText());
        c.setAppointmentTime(nextAppointmentTimeText.getText());

        ClientDB.getClients().add(c);
        ClientDB.setSelectedClient(ClientDB.getClients().size()-1);

        System.out.println(ClientDB.getSelectedClient().getName());

    }

    public void updateClient() {

        ClientDB.getSelectedClient().setName(clientNameText.getText());
        ClientDB.getSelectedClient().setPhone(phoneText.getText());
        ClientDB.getSelectedClient().setEmail(emailText.getText());
        ClientDB.getSelectedClient().setEmergencyName(emergencyNameText.getText());
        ClientDB.getSelectedClient().setEmergencyPhone(emergencyPhoneText.getText());
        ClientDB.getSelectedClient().setCity(addressCityText.getText());
        ClientDB.getSelectedClient().setState(addressStateText.getText());
        ClientDB.getSelectedClient().setAddress(addressText.getText());
        ClientDB.getSelectedClient().setZip(zipText.getText());
        ClientDB.getSelectedClient().setPrice(priceText.getText());
        ClientDB.getSelectedClient().setServiceType(serviceTypeText.getText());
        ClientDB.getSelectedClient().setNextAppointment(nextAppointmentText.getText());
        ClientDB.getSelectedClient().setWorkPhone(workText.getText());
        ClientDB.getSelectedClient().setAppointmentTime(nextAppointmentTimeText.getText());
    }

  
}

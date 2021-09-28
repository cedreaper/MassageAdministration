package view;

import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import java.time.LocalDate;

import model.Client;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolTip;
import javax.swing.ListModel;
import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import org.w3c.dom.Text;

import controller.DateLabelFormatter;



public class MainFrame {

    // main application user interface
    
    private int width = 500;
    private int height = 600;
    private JFrame window;
    
    //private Client[] clients;
    private JLabel clientLabel = new JLabel("Current Clients", SwingConstants.CENTER);

    private JButton clientInformation = new JButton("Client Info.");
    private JButton newClient = new JButton("New");
    private JButton removeClient = new JButton("Remove");
    private JButton logout = new JButton("Logout");
    private JDatePickerImpl datePicker;



    public MainFrame(JFrame window) {

        this.window = window;
    }

    public void init() {

        Container cp = window.getContentPane();
        cp.setBackground(Color.LIGHT_GRAY);
        cp.setSize(width, height);
        cp.setLayout(new GridLayout(6, 6));
        window.setTitle("Main Hub - CompanyNameHere");
        window.setBackground(Color.LIGHT_GRAY);

        JPanel northPanel = new JPanel();
        //northPanel.setLayout(new GridLayout(1, 4));
        northPanel.setBackground(Color.LIGHT_GRAY);

        northPanel.add(clientInformation);
        northPanel.add(newClient);
        northPanel.add(removeClient);
        northPanel.add(logout);
       

        clientLabel.setFont(new Font("Arial Black", Font.BOLD, 26));
        clientLabel.setPreferredSize(new Dimension(500, 300));
        int size = 100;
        Client[] clients = new Client[size];
        //mock up client (me)

        clients[0] = new Client("Cedric Green", "405-896-0669");
      
        //test scrollBar
        for(int i = 1; i < 100; i++) {

           clients[i] = new Client("Testing!!!", "405-599-1234");
            
        }
    
        JList<Client> currentClients = new JList<Client>(clients);
        int appointmentSize = 5;
        String[] appointments = new String[appointmentSize];
        JList<String> scheduledClients = new JList<String>(appointments);
        
        //attaching the scrollpane to currentClients listbox control
        var scrollPane = new JScrollPane(currentClients);
        scrollPane.setSize(500, 300);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.black));
        scrollPane.setToolTipText("Clients can be selected here for use with buttons.");

        Date date = new Date();
        UtilDateModel dateModel = new UtilDateModel();
        dateModel.setValue(date);
        dateModel.setSelected(true);
        Properties prop = new Properties();
        prop.put("text.today", "Today");
        prop.put("text.month", "Month");
        prop.put("text.year", "year");

        JDatePanelImpl datePanel = new JDatePanelImpl(dateModel, prop);
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datePicker.setBackground(Color.LIGHT_GRAY);
        datePicker.setPreferredSize(new Dimension(25, 100));


        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(2, 2));
        southPanel.setBackground(Color.LIGHT_GRAY);
        JLabel schedule = new JLabel("Schedule", SwingConstants.CENTER);
        schedule.setFont(new Font("Arial Black", Font.BOLD, 26));
        southPanel.add(schedule);
        southPanel.add(datePicker);

        //adding second list box for current schedule
        var scrollPane2 = new JScrollPane(scheduledClients);
        scrollPane2.setSize(500, 300);
        scrollPane2.setBorder(BorderFactory.createLineBorder(Color.black));
        scrollPane2.setToolTipText("Appointments will show here.");
        



        cp.add(clientLabel);
        cp.add(scrollPane);
        cp.add(northPanel);
        cp.add(southPanel); 
        cp.add(scrollPane2);       
    }

    public JButton getLogoutButton() {
        
        return logout;
    }

    public JButton getClientInfoButton() {

        return clientInformation;
    }

    public JButton getNewClientButton() {

        return newClient;
    }

    public JButton getRemoveButton() {

        return removeClient;
    }

    public JDatePickerImpl getDatePicker(){

        return datePicker;
    }
     
}

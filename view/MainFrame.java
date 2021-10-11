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
import java.util.Calendar;

import model.Client;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolTip;
import javax.swing.ListModel;
import javax.swing.RepaintManager;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import org.w3c.dom.Text;

import controller.DateLabelFormatter;



public class MainFrame {

    public enum States {

        START, MODIFIABLE;
    }

    //constants

    private final int MAX_CLIENTS = 99;
    private final int MAX_APPOINTMENTS = 10;

    // main application user interface
    
    private int width = 500;
    private int height = 600;
    private JFrame window;
    
    private Client[] clients = new Client[MAX_CLIENTS];
    String[] appointments = new String[MAX_APPOINTMENTS];
    private JLabel clientLabel = new JLabel("Current Clients", SwingConstants.CENTER);

    private JButton clientInformation = new JButton("Client Info.");
    private JButton newClient = new JButton("New");
    private JButton removeClient = new JButton("Remove");
    private JButton logout = new JButton("Logout");
    private JButton cancel = new JButton("Cancel Appointment");
    private JButton complete = new JButton("Complete Appointment");
    private JButton checkIn = new JButton("Check In");

    private JDatePickerImpl datePicker;

    private States state = States.START;

    //current client count xx / MAX 

    private int clientCount;


    public MainFrame(JFrame window) {

        this.window = window;
    }

    public void init() {

        Container cp = window.getContentPane();
        cp.setBackground(Color.LIGHT_GRAY);
        cp.setSize(width, height);
        cp.setLayout(new GridLayout(6, 6));
        window.setTitle("Main - Scissortail Massage");
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
       

        //mock up client (me)

        clients[0] = new Client("Cedric Green", "405-896-0669");
        clients[0].setNextAppointment("2021-10-09");
        clients[0].setServiceType("Deep Tissue");
        clients[0].setAppointmentTime("2:00 PM");  
        clientCount++;
      
        //test scrollBar
        for(int i = 1; i < 99; i++) {

           clients[i] = new Client("Testing!!!", "405-599-1234");
           clientCount++;
            
        }

        clients[30].setNextAppointment("2021-10-09");
        clients[35].setNextAppointment("2021-10-09");
        clients[40].setNextAppointment("2021-10-22");
    
        JList<Client> currentClients = new JList<Client>(clients);
        int appointmentSize = 10;
        
        JList<String> scheduledClients = new JList<String>(appointments);
        scheduledClients.setFixedCellHeight(15);
        scheduledClients.setFixedCellWidth(50);

        
        
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
        prop.put("text.today", "today");
        prop.put("text.month", "month");
        prop.put("text.year", "year");
        
        JDatePanelImpl datePanel = new JDatePanelImpl(dateModel, prop);
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datePicker.setBackground(Color.LIGHT_GRAY);
        datePicker.setPreferredSize(new Dimension(25, 30));
        datePicker.setSize(20,10);

        datePicker.addPropertyChangeListener(event -> {
            
            int counter = 1;
            //set date picker string
            if(counter == 1) {

                
                datePicker.getJFormattedTextField().setText(dateModel.getYear() + "-" + (dateModel.getMonth() + 1) + "-" + 
                dateModel.getDay());

                counter = 2;

            }  
        });
     
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(3, 2));
        southPanel.setBackground(Color.LIGHT_GRAY);
        JLabel schedule = new JLabel("Schedule", SwingConstants.CENTER);
        schedule.setFont(new Font("Arial Black", Font.BOLD, 26));
        southPanel.add(schedule);
        southPanel.add(datePicker);
        

        //adding second list box for current schedule
        var scrollPane2 = new JScrollPane(scheduledClients);
        scrollPane2.setPreferredSize(new Dimension(200, 300));
        scrollPane2.setBorder(BorderFactory.createLineBorder(Color.black));
        int k = 0;

        for(var cl : clients) {

            if(cl.getNextAppointment() != null) {

                if(cl.getNextAppointment().equals(LocalDate.now().toString())) {            
                    appointments[k] = cl.toString() + " | " + cl.getServiceType() + " | " +
                    cl.getAppointmentTime();
                    k++;
                }
            }
        }

        k = 0;

        datePicker.addActionListener(event -> {

            //disable check in button because nothing should be selected as we changed the date
            checkIn.setVisible(false);

            //remove all
            for(int i = 0; i < appointmentSize; i++) {

                appointments[i] = "";
            }

            //check the selected item against clients appointment dates

            int i = 0;

            for( var c : clients) {

               if(c.getNextAppointment() != null) {

                   if(c.getNextAppointment().equals(datePicker.getJFormattedTextField().getText())) {            
                       appointments[i] = c.toString() + " | " + c.getServiceType() + " | " +
                       c.getAppointmentTime();
                       i++;
                   }
                }
            }
       });

      
        checkIn.setVisible(false);

        JPanel south2 = new JPanel();

       scheduledClients.addListSelectionListener(event -> {

            //disabled until selected index
            if(scheduledClients.getSelectedValue().isEmpty()) {
    
                checkIn.setVisible(false);

            }
            else {

                checkIn.setVisible(true);
            }
            
       });

       
       
       
        
        south2.add(checkIn);
        south2.add(cancel);
        south2.add(complete);
        south2.setBackground(Color.LIGHT_GRAY);

        cp.add(clientLabel);
        cp.add(scrollPane);
        cp.add(northPanel);
        cp.add(southPanel); 
        cp.add(scrollPane2);
        cp.add(south2);

        state = States.MODIFIABLE;

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

    public JFrame getWindow() {

        return window;
    }

    public String[] getAppointments() {

        return appointments;
    }

    public JButton getCheckInButton() {

        return checkIn;
    }

    public Client[] getClients() {

        return clients;
    }

    public int getMaxAppointments() {

        return MAX_APPOINTMENTS;
    }

    public void setClient(Client client) {

        if(clientCount < MAX_CLIENTS) {

            clients[clientCount + 1] = client;
        }
        else {

            JOptionPane.showMessageDialog(null, "Clients list has reached maximum capacity. Please contact your software\nadministrator to" + 
                " purchase additional client storage.");
        }
        

    }

    public States getState() {

        return state;
    }

    public void setState(States state) {

        this.state = state;
    }
     
}

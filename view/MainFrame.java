package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;
import model.Client;

import javax.swing.JFrame;
import javax.swing.JTextArea;


public class MainFrame {

    // main application user interface
    
    private int width = 500;
    private int height = 600;
    private JFrame window;
    private JTextArea currentClients = new JTextArea("Brand new... so i'm empty! Clients list will show here later!");
    private ArrayList<Client>clients = new ArrayList<Client>();

    public MainFrame(JFrame window) {

        this.window = window;
    }

    public void init() {

        Container cp = window.getContentPane();
        cp.setBackground(Color.LIGHT_GRAY);
        cp.setSize(width, height);
        window.setTitle("Main Hub - CompanyNameHere");
        window.setBackground(Color.LIGHT_GRAY);

        currentClients.setPreferredSize(new Dimension(500, 300));
        currentClients.setEditable(false);

        clients.add(new Client("Cedric Green", "405-896-0669"));

        currentClients.setText(clients.get(0).getName() + " | " + clients.get(0).getPhone());




        cp.add(BorderLayout.CENTER, currentClients);
        
    }
     
}

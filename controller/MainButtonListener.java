package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import model.Client;
import model.ClientDB;
import view.LoginFrame;
import view.MainFrame;


public class MainButtonListener implements ActionListener {

    MainFrame panel;


   

    public MainButtonListener(MainFrame panel) {

        this.panel = panel;

        //client listeners
        panel.getClientFrame().getExitButton().addActionListener(this);
        panel.getClientFrame().getUpdateButton().addActionListener(this);
        panel.getClientFrame().getConfirmButton().addActionListener(this);
        panel.getClientFrame().getNotesButton().addActionListener(this);
        panel.getClientFrame().getHistoryButton().addActionListener(this);
        panel.getClientFrame().getMedicalButton().addActionListener(this);

        //soap notes listeners
        panel.getNotesFrame().getAddButton().addActionListener(this);
        panel.getNotesFrame().getSaveButton().addActionListener(this);
        panel.getNotesFrame().getExitButton().addActionListener(this);

        //history listeners
        panel.getHistoryFrame().getExitButton().addActionListener(this);

        //medical listeners
        panel.getMedicalFrame().getExitButton().addActionListener(this);
        panel.getMedicalFrame().getEditButton().addActionListener(this);
        panel.getMedicalFrame().getSaveButton().addActionListener(this);
        

    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        JButton button = (JButton) e.getSource();

        if(button.equals(panel.getClientInfoButton())) {

            //open client information window

            if(panel.getCurrentClients().getSelectedIndex() > ClientDB.getClients().size()) {

                //ClientDB.setSelectedClient(-1);
                return;

            }
            else {

                if(panel.getCurrentClients().getSelectedIndex() != -1) {

                    ClientDB.setSelectedClient(panel.getCurrentClients().getSelectedIndex());
                }
                
            }
            

            panel.getWindow().getContentPane().removeAll();

            panel.getClientFrame().init();
            panel.getWindow().setTitle("Client Information - Scissortail Massage");
            panel.getWindow().revalidate();

        }
        else if(button.equals(panel.getNewClientButton())) {
            
            try {

            
                String addedClient =
                JOptionPane.showInputDialog(panel.getWindow(), 
                    "Enter Name and Phone number for new client.\nFormat = Name, Phone\n" +
                    "e.g. Henry Jenkins, 405-599-1234");
                    int commaIndex = 0;

                    for(int i = 0; i < addedClient.length(); i++) {

                        if(addedClient.charAt(i) == ',') {

                            commaIndex = i;
                        }
                    }
                    
                    //substring the line from the input window to get the correct parts for client build
                    String name = addedClient.substring(0, commaIndex);
                    String phone = addedClient.substring(commaIndex + 2, addedClient.length());

                // add new client based on substring results
                Client newClient = new Client(name, phone);
                ClientDB.getClients().add(newClient);

                panel.getWindow().getContentPane().removeAll();
                panel.getMainFrame().init();
                
                panel.getWindow().revalidate();
            }
            catch (Exception except) {

                //return if cancel or invalid information
               
                return;

            }
        }
        else if(button.equals(panel.getClientFrame().getExitButton())) {

                //button exit to main from client window
           
            panel.removeFrames();
            panel.getWindow().getContentPane().removeAll();
            panel.init();
            panel.getWindow().revalidate();

        }
        else if(button.equals(panel.getNotesFrame().getExitButton()) || 
            button.equals(panel.getHistoryFrame().getExitButton()) || 
            button.equals(panel.getMedicalFrame().getExitButton())) {

            //close notes/history/medical windows reopen client window

            panel.removeFrames();
            panel.init();
            panel.getWindow().getContentPane().removeAll();
            panel.getClientFrame().init();
            panel.getWindow().repaint();
            panel.getWindow().revalidate();

        }
        else if(button.equals(panel.getClientFrame().getUpdateButton())) {

            //edit  client information

            panel.getClientFrame().getConfirmButton().setEnabled(true);
            panel.getClientFrame().getExitButton().setEnabled(false);
            panel.getClientFrame().getMedicalButton().setEnabled(false);
            panel.getClientFrame().getHistoryButton().setEnabled(false);
            panel.getClientFrame().getNotesButton().setEnabled(false);
            panel.getClientFrame().getUpdateButton().setEnabled(false);

            panel.getClientFrame().enableTextFields();
        }
        else if(button.equals(panel.getClientFrame().getConfirmButton())) {

            if(panel.getClientFrame().getAddingNewClient()) {

                //if we are adding a new client then we need to get the details here
                panel.getClientFrame().createNewClient();
                

                panel.getClientFrame().setAddingClient(false);

                return;
            }
            //confirm changes in client information window
            if(panel.getClientFrame().getClientNameText().getText().equals("") ||
            panel.getClientFrame().getPhoneText().getText().equals("")) {
                
                JOptionPane.showMessageDialog(panel.getWindow(), 
                "Error: Name and Phone are REQUIRED for all clients.");

            } 
            else {

                panel.getClientFrame().getUpdateButton().setEnabled(true);
                panel.getClientFrame().getExitButton().setEnabled(true);
                panel.getClientFrame().getMedicalButton().setEnabled(true);
                panel.getClientFrame().getHistoryButton().setEnabled(true);
                panel.getClientFrame().getNotesButton().setEnabled(true);
                panel.getClientFrame().getConfirmButton().setEnabled(false);

                panel.getClientFrame().disableTextFields();

                //update each field to match client

                panel.getClientFrame().updateClient();

                
            }
            
        }
        else if(button.equals(panel.getClientFrame().getNotesButton())){

            //open notes window

            panel.getWindow().getContentPane().removeAll();
            panel.getNotesFrame().init();
            panel.getWindow().setTitle("Notes - Scissortail Massage");
            panel.getWindow().revalidate();

        }
        else if(button.equals(panel.getNotesFrame().getAddButton())) {

            //add notes button 

            panel.getNotesFrame().getExitButton().setEnabled(false);
            panel.getNotesFrame().getAddButton().setEnabled(false);
            panel.getNotesFrame().getSaveButton().setEnabled(true);
            panel.getNotesFrame().getNotesArea().setText(panel.getNotesFrame().getNotesArea().getText() + 
                "\n\n" + LocalDate.now() + 
                "\n------------------------------------\nS:\nO:\nA:\nP:\n");
            panel.getNotesFrame().getNotesArea().setEditable(true);

        }
        else if(button.equals(panel.getNotesFrame().getSaveButton())) {

            //save notes button

            panel.getNotesFrame().getNotesArea().setEditable(false);
            panel.getNotesFrame().getSaveButton().setEnabled(false);
            panel.getNotesFrame().getAddButton().setEnabled(true);
            panel.getNotesFrame().getExitButton().setEnabled(true);

            //save notes to client DB
            if(ClientDB.getSelectedClient().getNotes().equals("No Data")) {

                ClientDB.getSelectedClient().setNotes(panel.getNotesFrame().getNotesArea().getText());
            }
            else {

                ClientDB.getSelectedClient().setNotes(ClientDB.getSelectedClient().getNotes() + " " 
                + panel.getNotesFrame().getNotesArea().getText());
            }
        }
        else if(button.equals(panel.getClientFrame().getHistoryButton())) {

            // open history window

            panel.getWindow().getContentPane().removeAll();
            panel.getHistoryFrame().init();
            panel.getWindow().setTitle("History - Scissortail Massage");
            panel.getWindow().revalidate();
        }
        else if(button.equals(panel.getClientFrame().getMedicalButton())) {

            // open medical window

            panel.getWindow().getContentPane().removeAll();
            panel.getMedicalFrame().init();
            panel.getWindow().setTitle("Medical Information - Scissortail Massage");
            panel.getWindow().revalidate();

        }
        else if(button.equals(panel.getMedicalFrame().getEditButton())) {

            //client medical edit

            panel.getMedicalFrame().getDetailsText().setEditable(true);
            panel.getMedicalFrame().enableCheckBoxes();
            panel.getMedicalFrame().getExitButton().setEnabled(false);
            panel.getMedicalFrame().getSaveButton().setEnabled(true);
            panel.getMedicalFrame().getEditButton().setEnabled(false);
            
            

            
        }
        else if(button.equals(panel.getMedicalFrame().getSaveButton())) {

            //medical save action

            panel.getMedicalFrame().disableCheckBoxes();
            panel.getMedicalFrame().getDetailsText().setEditable(false);
            panel.getMedicalFrame().getSaveButton().setEnabled(false);
            panel.getMedicalFrame().getExitButton().setEnabled(true);
            panel.getMedicalFrame().getEditButton().setEnabled(true);

            //save all selected checkboxes accordingly - they correspond with the indexes of the boolean
            //list in client object

            for(int i = 0; i < panel.getMedicalFrame().getCheckBoxes().size(); i++) {

                if(panel.getMedicalFrame().getCheckBoxes().get(i).isSelected()) {
                    //check box selected? then add to the boolean array true value
                    ClientDB.getSelectedClient().getMedicalProblems().set(i, true);
                }
            }

            //also need to get the values from the checked details box and add to the medical notes
            if(ClientDB.getSelectedClient().getMedicalNotes().equals("No Data")) {

                ClientDB.getSelectedClient().setMedicalNotes(panel.getMedicalFrame().getDetailsText().getText());
            }
            else {

                ClientDB.getSelectedClient().setMedicalNotes(ClientDB.getSelectedClient().getMedicalNotes() + " " 
                + panel.getMedicalFrame().getDetailsText().getText());
            }
            

        }
        else if(button.equals(panel.getLogoutButton())) {
            // save database file before exiting and reset the counter for load clients....

            //add code here // <-----------------------


            //logout main - reopen login screen
            panel.getWindow().getContentPane().removeAll();
            // panel.getWindow().setLocation(550,350);
            var loginFrame = new LoginFrame(panel.getWindow());
            loginFrame.init();
            panel.getWindow().revalidate();
        }
        else if(button.equals(panel.getRemoveButton())) {

            // remove client button

            String result =
            JOptionPane.showInputDialog(panel.getWindow(), "Are you sure you want to delete " + 
            panel.getCurrentClients().getSelectedValue().getName() + 
            "\n" +
            "**THIS IS PERMANENT**\nType yes to confirm.");

            if(result.toLowerCase().equals("yes")) {

                ClientDB.getClients().remove(panel.getCurrentClients().getSelectedIndex());
                panel.getWindow().getContentPane().removeAll();
                panel.getMainFrame().init();
                
                panel.getWindow().revalidate();
            }
            else {

                return;
            }
                 
        }
        
    }
    
}

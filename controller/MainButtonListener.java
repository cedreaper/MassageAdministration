package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JButton;

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

            panel.getWindow().getContentPane().removeAll();

            panel.getClientFrame().init();
            panel.getWindow().setTitle("Client Information - Scissortail Massage");
            panel.getWindow().revalidate();

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

            //confirm changes in client information window

            panel.getClientFrame().getUpdateButton().setEnabled(true);
            panel.getClientFrame().getExitButton().setEnabled(true);
            panel.getClientFrame().getMedicalButton().setEnabled(true);
            panel.getClientFrame().getHistoryButton().setEnabled(true);
            panel.getClientFrame().getNotesButton().setEnabled(true);
            panel.getClientFrame().getConfirmButton().setEnabled(false);

            panel.getClientFrame().disableTextFields();
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
        }
        else if(button.equals(panel.getLogoutButton())) {
            
            //logout main - reopen login screen
            panel.getWindow().getContentPane().removeAll();
            var loginFrame = new LoginFrame(panel.getWindow());
            loginFrame.init();
            panel.getWindow().revalidate();
        }
        
    }
    
}

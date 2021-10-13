package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JButton;

import view.ClientFrame;
import view.HistoryFrame;
import view.MainFrame;
import view.MedicalFrame;
import view.NotesFrame;

public class MainButtonListener implements ActionListener {

    MainFrame panel;


   

    public MainButtonListener(MainFrame panel) {

        this.panel = panel;

        //client listeners
        panel.getClientFrame().getExitButton().addActionListener(this);
        panel.getClientFrame().getUpdateButton().addActionListener(this);
        panel.getClientFrame().getConfirmButton().addActionListener(this);
        panel.getClientFrame().getNotesButton().addActionListener(this);

        //soap notes listeners
        panel.getNotesFrame().getAddButton().addActionListener(this);
        panel.getNotesFrame().getSaveButton().addActionListener(this);
        panel.getNotesFrame().getExitButton().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        JButton button = (JButton) e.getSource();

        if(button.equals(panel.getClientInfoButton())) {

            panel.getWindow().getContentPane().removeAll();

            panel.getClientFrame().init();
            panel.getWindow().setTitle("Client Information - Scissortail Massage");
            panel.getWindow().revalidate();

        }
        else if(button.equals(panel.getClientFrame().getExitButton()) || 
                button.equals(panel.getNotesFrame().getExitButton())) {

            
           
            panel.removeFrames();
            panel.getWindow().getContentPane().removeAll();
            panel.init();
            panel.getWindow().revalidate();

        }
        else if(button.equals(panel.getClientFrame().getUpdateButton())) {

            panel.getClientFrame().enableTextFields();
        }
        else if(button.equals(panel.getClientFrame().getConfirmButton())) {

            panel.getClientFrame().disableTextFields();
        }
        else if(button.equals(panel.getClientFrame().getNotesButton())){

            //panel.removeFrames();
            panel.getWindow().getContentPane().removeAll();
            panel.getNotesFrame().init();
            panel.getWindow().setTitle("Notes - Scissortail Massage");
            panel.getWindow().revalidate();

        }
        else if(button.equals(panel.getNotesFrame().getAddButton())) {

            panel.getNotesFrame().getAddButton().setEnabled(false);
            panel.getNotesFrame().getSaveButton().setEnabled(true);
            panel.getNotesFrame().getNotesArea().setText(panel.getNotesFrame().getNotesArea().getText() + "\n\n" + LocalDate.now() + 
                "\n------------------------------------\nS:\nO:\nA:\nP:\n");
            panel.getNotesFrame().getNotesArea().setEditable(true);

        }
        else if(button.equals(panel.getNotesFrame().getSaveButton())) {

            panel.getNotesFrame().getNotesArea().setEditable(false);
            panel.getNotesFrame().getSaveButton().setEnabled(false);
            panel.getNotesFrame().getAddButton().setEnabled(true);
        }
        
    }
    
}

package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import model.ClientDB;

public class MedicalFrame {

    private JFrame window;

    private ArrayList<JCheckBox> checkBoxes = new ArrayList<>();

    private JTextArea detailsText = new JTextArea();

    private JLabel medicalLabel = new JLabel("Medical Information", SwingConstants.CENTER);

    private JButton editButton = new JButton("Edit");
    private JButton saveButton = new JButton("Save");
    private JButton exitButton = new JButton("Exit");


    public MedicalFrame(JFrame window) {

        this.window = window;

        checkBoxes.add(new JCheckBox("Neck Pain"));
        checkBoxes.add(new JCheckBox("Back Pain"));
        checkBoxes.add(new JCheckBox("Headaches"));
        checkBoxes.add(new JCheckBox("Jaw Problems"));
        checkBoxes.add(new JCheckBox("Varicose Veins"));
        checkBoxes.add(new JCheckBox("Leg/Knee Pain"));
        checkBoxes.add(new JCheckBox("Bruise Easily"));
        checkBoxes.add(new JCheckBox("High Blood Pressure"));
        checkBoxes.add(new JCheckBox("Low Blood Pressure"));
        checkBoxes.add(new JCheckBox("Diabetes"));
        checkBoxes.add(new JCheckBox("Seizures"));
        checkBoxes.add(new JCheckBox("Wears Contacts"));
        checkBoxes.add(new JCheckBox("Numbness/Tingling"));
        checkBoxes.add(new JCheckBox("First Time Professional Massage"));
        checkBoxes.add(new JCheckBox("Skin Problems or Allergies"));
        checkBoxes.add(new JCheckBox("Arthritis/Joint Disorders"));
        checkBoxes.add(new JCheckBox("Blood Clots"));
        checkBoxes.add(new JCheckBox("Heart Problems"));
        checkBoxes.add(new JCheckBox("Sleep Problems"));
        checkBoxes.add(new JCheckBox("Spinal Problems"));
        checkBoxes.add(new JCheckBox("Stressful Lifestyle"));
        checkBoxes.add(new JCheckBox("Major Recent Life Event"));
        checkBoxes.add(new JCheckBox("Smoker"));
        checkBoxes.add(new JCheckBox("Drinker"));
        checkBoxes.add(new JCheckBox("Illegal Drugs"));
        checkBoxes.add(new JCheckBox("Taking Medications"));
        checkBoxes.add(new JCheckBox("Plays Sports"));
        checkBoxes.add(new JCheckBox("Any Medical Condition Not Mentioned"));

       
    }

    public void init() {

        //disable all that needs disabled until edit clicked

        for(var c : checkBoxes) {

            c.setEnabled(false);
        }

        saveButton.setEnabled(false);

        detailsText.setEditable(false);
        
        // load client medical details text
        if(ClientDB.getSelectedClient().getMedicalNotes().equals("No Data")) {

            detailsText.setText("");
        }
        else {

            detailsText.setText(ClientDB.getSelectedClient().getMedicalNotes());
        }
        

        medicalLabel.setFont(new Font("arial black", Font.BOLD, 26));     

        detailsText.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        detailsText.setWrapStyleWord(true);
        detailsText.setLineWrap(true);

        Container cp = window.getContentPane();

        cp.setBackground(Color.LIGHT_GRAY);
        
        
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();

        panel1.setBackground(Color.LIGHT_GRAY);
        panel2.setBackground(Color.LIGHT_GRAY);
        panel3.setBackground(Color.LIGHT_GRAY);

        panel1.setPreferredSize(new Dimension(900, 400));

        JPanel s1 = new JPanel();
        JPanel s2 = new JPanel();
        JPanel s3 = new JPanel();

        JScrollPane checkScroll = new JScrollPane(s1);
        checkScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
       
        s1.setBackground(Color.LIGHT_GRAY);

        TitledBorder checkArea = new TitledBorder("Medical Issues");
        TitledBorder detailArea = new TitledBorder("Checked Details");

        for(var c : checkBoxes) {

            s1.add(c);
        }

        s1.setBorder(checkArea);
        s2.setBorder(detailArea);
        detailsText.setWrapStyleWord(true);
        detailsText.setLineWrap(true);
        
        
        JScrollPane detailsScroll = new JScrollPane(detailsText, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        detailsScroll.setPreferredSize(new Dimension(380, 160));
        
        loadCheckedEntries();

        s2.add(detailsScroll);
        s2.setBackground(Color.LIGHT_GRAY);

        s3.add(editButton);
        s3.add(saveButton);
        s3.add(exitButton);

        s3.setBackground(Color.LIGHT_GRAY);

       

        
        panel1.add(s2);
        panel2.add(s3);

        panel3.setLayout(new GridLayout(1, 1));
        panel3.add(s1);


        cp.add(BorderLayout.NORTH, panel3);
        cp.add(BorderLayout.CENTER, panel1);
        cp.add(BorderLayout.SOUTH, panel2);

       
    }

    public JButton getEditButton() {

        return editButton;
    }

    public JButton getExitButton() {

        return exitButton;
    }

    public JButton getSaveButton() {

        return saveButton;
    }

    public ArrayList<JCheckBox> getCheckBoxes() {

        return checkBoxes;
    }

    public JTextArea getDetailsText() {

        return detailsText;
    }

    public void enableCheckBoxes() {

        for(var c : checkBoxes) {

            c.setEnabled(true);
        }
    }

    public void disableCheckBoxes() {

        for(var c : checkBoxes) {

            c.setEnabled(false);
        }
    }

    private void loadCheckedEntries() {

        for(int i = 0; i < checkBoxes.size(); i++) {

            if(ClientDB.getSelectedClient().getMedicalProblems().get(i)) {

                checkBoxes.get(i).setSelected(true);
            }

        }
    }


    
    
}

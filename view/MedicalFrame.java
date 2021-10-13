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

        System.out.println("Size checkboxes arraylist: " + checkBoxes.size());

        saveButton.setEnabled(false);

        detailsText.setEditable(false);

        medicalLabel.setFont(new Font("arial black", Font.BOLD, 26));
        

        detailsText.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        detailsText.setWrapStyleWord(true);
        detailsText.setLineWrap(true);

        Container cp = window.getContentPane();

        cp.setBackground(Color.LIGHT_GRAY);

        window.setLocation(300,200);
        
        
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();

        panel1.setBackground(Color.LIGHT_GRAY);
        panel2.setBackground(Color.LIGHT_GRAY);
        panel3.setBackground(Color.LIGHT_GRAY);

        panel1.setLayout(new GridLayout(1, 2));
        panel1.setPreferredSize(new Dimension(900, 400));

        JPanel s1 = new JPanel();
        JPanel s2 = new JPanel();
        JPanel s3 = new JPanel();
       
        s1.setBackground(Color.LIGHT_GRAY);

        TitledBorder checkArea = new TitledBorder("Medical Issues");
        TitledBorder detailArea = new TitledBorder("Checked Details");

        for(var c : checkBoxes) {

            s1.add(c);
        }

        s1.setBorder(checkArea);
        s2.setBorder(detailArea);
        
        JScrollPane detailsScroll = new JScrollPane(detailsText, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        detailsScroll.setPreferredSize(new Dimension(400, 350));
        
       
       

        s2.add(detailsScroll);
        s2.setBackground(Color.LIGHT_GRAY);

        s3.add(editButton);
        s3.add(saveButton);
        s3.add(exitButton);

        s3.setBackground(Color.LIGHT_GRAY);

        panel1.add(s1);
        panel1.add(s2);
        panel2.add(s3);


        cp.add(BorderLayout.NORTH, medicalLabel);
        cp.add(BorderLayout.CENTER, panel1);
        cp.add(BorderLayout.SOUTH, panel2);

       
    }


    
    
}

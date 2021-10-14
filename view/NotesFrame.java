package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class NotesFrame {

    private JFrame window;
    private MainFrame panel;

    private int width = 700;
    private int height = 600;

    private JTextArea notesArea = new JTextArea();

    private JLabel notesHeader = new JLabel("Soap Notes", SwingConstants.CENTER);

    private JButton addButton = new JButton("Add Note");
    private JButton saveButton = new JButton("Save");
    private JButton exitButton = new JButton("Exit");
    


    public NotesFrame(JFrame window) {

        this.window = window;
    }

    public void init() {

        Container cp = window.getContentPane();
        cp.setBackground(Color.LIGHT_GRAY);


        notesHeader.setFont(new Font("Arial Black", Font.BOLD, 26));
        notesArea.setPreferredSize(new Dimension(600,600));
        notesArea.setLineWrap(true);
        notesArea.setWrapStyleWord(true);
        

        JPanel notesButtons = new JPanel();
        notesButtons.add(addButton);
        notesButtons.add(saveButton);
        notesButtons.add(exitButton);
        notesButtons.setBackground(Color.LIGHT_GRAY);

        //disable until button click
        notesArea.setEditable(false);
        saveButton.setEnabled(false);

        JScrollPane notesScroll = new JScrollPane(notesArea);

        TitledBorder notesBorder = new TitledBorder("Notes Log");
        notesScroll.setBorder(notesBorder);
        

        cp.add(BorderLayout.NORTH, notesHeader);
        cp.add(BorderLayout.CENTER, notesScroll);
        cp.add(BorderLayout.SOUTH, notesButtons);
        


        
    }

    public JButton getAddButton() {

        return addButton;
    }

    public JButton getSaveButton() {

        return  saveButton;
    }

    public JButton getExitButton() {
        
        return exitButton;
    }

    public JTextArea getNotesArea() {

        return notesArea;
    }
    
}

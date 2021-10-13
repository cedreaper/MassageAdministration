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


public class HistoryFrame {

    private JFrame window;

    private JTextArea historyArea = new JTextArea();

    private JLabel historyLabel = new JLabel("Appointment History", SwingConstants.CENTER);

    private JButton exitButton = new JButton("Exit");

    public HistoryFrame(JFrame window) {

        this.window = window;

    }

    public void init() {

        Container cp = window.getContentPane();
        window.setSize(700, 600);
        window.setLocation(500,200);
        cp.setBackground(Color.LIGHT_GRAY);

        historyArea.setLineWrap(true);
        historyArea.setWrapStyleWord(true);
        historyArea.setPreferredSize(new Dimension(400, 400));

        historyArea.setEditable(false);

        TitledBorder border = new TitledBorder("History");

        historyLabel.setFont(new Font("arial black", Font.BOLD, 26));

        JScrollPane historyScroll = new JScrollPane(historyArea);
        historyScroll.setBorder(border);

        JPanel exitPanel = new JPanel();
        exitPanel.setBackground(Color.LIGHT_GRAY);
        exitPanel.add(exitButton);
        
        cp.add(BorderLayout.NORTH, historyLabel);
        cp.add(BorderLayout.CENTER, historyScroll);
        cp.add(BorderLayout.SOUTH, exitPanel);

        
    }
    
}

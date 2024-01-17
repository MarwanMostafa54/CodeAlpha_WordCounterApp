package application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WordCounterApp {
    private JFrame frame;
    private JTextArea textArea;
    private JButton countButton;
    private JLabel countLabel;

    public WordCounterApp() {
        initializeUI();
        setupEventListeners();
    }

    private void initializeUI() {
        frame = new JFrame("Word Counter");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        textArea = new JTextArea(10, 30);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(textArea);
        mainPanel.add(scrollPane, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        countButton = new JButton("Count Words");
        buttonPanel.add(countButton);

        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        countLabel = new JLabel("Word Count: 0");
        countLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(countLabel, BorderLayout.SOUTH);

        frame.add(mainPanel);

        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);
    }

    private void setupEventListeners() {
        countButton.addActionListener(new WordCountButtonListener());
    }

    private class WordCountButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String text = textArea.getText();
            String[] words = text.split("\\s+");
            countLabel.setText("Word Count: " + words.length);
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new WordCounterApp());
    }
}

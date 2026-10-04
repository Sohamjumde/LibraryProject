package com.Library;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ReturnBook extends JFrame implements ActionListener {

    JTextField issueId;
    JButton returnButton;

    ReturnBook() {

        setTitle("Return Book");
        setSize(400, 200);
        setLayout(null);

        JLabel l1 = new JLabel("Issue ID:");
        l1.setBounds(40, 40, 100, 30);
        add(l1);

        issueId = new JTextField();
        issueId.setBounds(150, 40, 180, 30);
        add(issueId);

        returnButton = new JButton("Return Book");
        returnButton.setBounds(130, 100, 120, 35);
        returnButton.addActionListener(this);
        add(returnButton);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try {

            Connection con = DatabaseConnection.getConnection();

            String sql =
                    "UPDATE issued_books " +
                    "SET return_date = CURDATE() " +
                    "WHERE issue_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, Integer.parseInt(issueId.getText()));

            int result = ps.executeUpdate();

            if (result > 0) {

                JOptionPane.showMessageDialog(this,
                        "Book Returned Successfully!");

            } else {

                JOptionPane.showMessageDialog(this,
                        "Issue ID not found!");
            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(this,
                    "Error: " + ex.getMessage());
        }
    }
}
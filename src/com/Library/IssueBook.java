package com.Library;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class IssueBook extends JFrame implements ActionListener {

    JTextField bookId, memberId, dueDate;
    JButton issue;

    IssueBook() {

        setTitle("Issue Book");
        setSize(400, 300);
        setLayout(null);

        JLabel l1 = new JLabel("Book ID:");
        l1.setBounds(40, 40, 100, 30);
        add(l1);

        bookId = new JTextField();
        bookId.setBounds(150, 40, 180, 30);
        add(bookId);

        JLabel l2 = new JLabel("Member ID:");
        l2.setBounds(40, 90, 100, 30);
        add(l2);

        memberId = new JTextField();
        memberId.setBounds(150, 90, 180, 30);
        add(memberId);

        JLabel l3 = new JLabel("Due Date:");
        l3.setBounds(40, 140, 100, 30);
        add(l3);

        dueDate = new JTextField();
        dueDate.setBounds(150, 140, 180, 30);
        add(dueDate);

        issue = new JButton("Issue Book");
        issue.setBounds(130, 200, 120, 35);
        issue.addActionListener(this);
        add(issue);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try {

            Connection con = DatabaseConnection.getConnection();

            String sql =
                    "INSERT INTO issued_books " +
                    "(book_id, member_id, issue_date, due_date) " +
                    "VALUES (?, ?, CURDATE(), ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, Integer.parseInt(bookId.getText()));
            ps.setInt(2, Integer.parseInt(memberId.getText()));
            ps.setDate(3, Date.valueOf(dueDate.getText()));

            ps.executeUpdate();

            JOptionPane.showMessageDialog(this,
                    "Book Issued Successfully!");

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(this,
                    "Error: " + ex.getMessage());
        }
    }
}
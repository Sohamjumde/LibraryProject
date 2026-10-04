package com.Library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddBook extends JFrame implements ActionListener {

    JTextField title, author, quantity;
    JButton add;

    AddBook() {

        setTitle("Add Book");
        setSize(400, 300);
        setLayout(null);

        JLabel l1 = new JLabel("Book Title:");
        l1.setBounds(40, 40, 100, 30);
        add(l1);

        title = new JTextField();
        title.setBounds(150, 40, 180, 30);
        add(title);

        JLabel l2 = new JLabel("Author:");
        l2.setBounds(40, 90, 100, 30);
        add(l2);

        author = new JTextField();
        author.setBounds(150, 90, 180, 30);
        add(author);

        JLabel l3 = new JLabel("Quantity:");
        l3.setBounds(40, 140, 100, 30);
        add(l3);

        quantity = new JTextField();
        quantity.setBounds(150, 140, 180, 30);
        add(quantity);

        add = new JButton("Add Book");
        add.setBounds(130, 200, 120, 35);
        add.addActionListener(this);
        add(add);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try {

            Connection con = DatabaseConnection.getConnection();

            String sql = "INSERT INTO books(title, author, quantity) VALUES (?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, title.getText());
            ps.setString(2, author.getText());
            ps.setInt(3, Integer.parseInt(quantity.getText()));

            ps.executeUpdate();

            JOptionPane.showMessageDialog(this,
                    "Book Added Successfully!");

            title.setText("");
            author.setText("");
            quantity.setText("");

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(this,
                    "Error: " + ex.getMessage());
        }
    }
}
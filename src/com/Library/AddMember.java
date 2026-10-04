package com.Library;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class AddMember extends JFrame implements ActionListener {

    JTextField name, phone;
    JButton add;

    AddMember() {

        setTitle("Add Member");
        setSize(400, 250);
        setLayout(null);

        JLabel l1 = new JLabel("Member Name:");
        l1.setBounds(40, 40, 100, 30);
        add(l1);

        name = new JTextField();
        name.setBounds(150, 40, 180, 30);
        add(name);

        JLabel l2 = new JLabel("Phone:");
        l2.setBounds(40, 90, 100, 30);
        add(l2);

        phone = new JTextField();
        phone.setBounds(150, 90, 180, 30);
        add(phone);

        add = new JButton("Add Member");
        add.setBounds(130, 150, 120, 35);
        add.addActionListener(this);
        add(add);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try {

            Connection con = DatabaseConnection.getConnection();

            String sql =
                    "INSERT INTO members(name, phone) VALUES (?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name.getText());
            ps.setString(2, phone.getText());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(this,
                    "Member Added Successfully!");

            name.setText("");
            phone.setText("");

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(this,
                    "Error: " + ex.getMessage());
        }
    }
}
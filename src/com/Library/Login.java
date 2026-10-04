package com.Library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {

    JLabel l1, l2;
    JTextField username;
    JPasswordField password;
    JButton login;

    Login() {

        setTitle("Library Login");
        setSize(400, 300);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        l1 = new JLabel("Username:");
        l1.setBounds(50, 60, 100, 30);
        add(l1);

        username = new JTextField();
        username.setBounds(150, 60, 180, 30);
        add(username);

        l2 = new JLabel("Password:");
        l2.setBounds(50, 110, 100, 30);
        add(l2);

        password = new JPasswordField();
        password.setBounds(150, 110, 180, 30);
        add(password);

        login = new JButton("Login");
        login.setBounds(150, 170, 100, 35);
        login.addActionListener(this);
        add(login);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        String user = username.getText();
        String pass = new String(password.getPassword());

        if (user.equals("admin") && pass.equals("1234")) {

            JOptionPane.showMessageDialog(this,
                    "Login Successful!");

            new Dashboard();
            dispose();

        } else {

            JOptionPane.showMessageDialog(this,
                    "Invalid Username or Password");
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
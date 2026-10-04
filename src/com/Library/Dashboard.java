package com.Library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {

    JButton addBook;
    JButton addMember;
    JButton issueBook;
    JButton returnBook;
    JButton dueDate;
    JButton viewBooks;

    Dashboard() {

        setTitle("Library Management System");
        setSize(500, 400);
        setLayout(new GridLayout(5, 1, 10, 10));

        addBook = new JButton("Add Book");
        addMember = new JButton("Add Member");
        issueBook = new JButton("Issue Book");
        returnBook = new JButton("Return Book");
        dueDate = new JButton("Due Date Tracking");
        viewBooks = new JButton("View Books");

        add(addBook);
        add(addMember);
        add(issueBook);
        add(returnBook);
        add(dueDate);
        add(viewBooks);

        addBook.addActionListener(this);
        addMember.addActionListener(this);
        issueBook.addActionListener(this);
        returnBook.addActionListener(this);
        dueDate.addActionListener(this);
        viewBooks.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == addBook) {
            new AddBook();
        }

        else if (e.getSource() == addMember) {
            new AddMember();
        }

        else if (e.getSource() == issueBook) {
            new IssueBook();
        }

        else if (e.getSource() == returnBook) {
            new ReturnBook();
        }

        else if (e.getSource() == viewBooks) {
            new ViewBooks();
        }
    }
}
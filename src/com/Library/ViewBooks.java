package com.Library;

import javax.swing.*;
import java.sql.*;

public class ViewBooks extends JFrame {

    JTextArea area;

    ViewBooks() {

        setTitle("View Books");
        setSize(500, 400);

        area = new JTextArea();
        area.setEditable(false);

        add(new JScrollPane(area));

        loadBooks();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    void loadBooks() {

        try {

            Connection con = DatabaseConnection.getConnection();

            String sql = "SELECT * FROM books";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                area.append(
                        "Book ID: " + rs.getInt("book_id") +
                        "\nTitle: " + rs.getString("title") +
                        "\nAuthor: " + rs.getString("author") +
                        "\nQuantity: " + rs.getInt("quantity") +
                        "\n-----------------------------\n"
                );
            }

        } catch (Exception e) {

            area.setText("Error: " + e.getMessage());
        }
    }
}
package com.Library;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DueDateTracking extends JFrame {

    JTextArea area;

    DueDateTracking() {

        setTitle("Due Date Tracking");
        setSize(800, 500);
        setLayout(new BorderLayout());

        area = new JTextArea();
        area.setFont(new Font("Arial", Font.PLAIN, 14));
        area.setEditable(false);

        add(new JScrollPane(area), BorderLayout.CENTER);

        loadDueDates();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    void loadDueDates() {

        try {

            Connection con = DatabaseConnection.getConnection();

            String sql = "SELECT * FROM issued_books";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            area.append(
                "ISSUE ID\tBOOK ID\tMEMBER ID\tDUE DATE\tSTATUS\n"
            );

            area.append(
                "------------------------------------------------------------\n"
            );

            while (rs.next()) {

                int issueId = rs.getInt("issue_id");
                int bookId = rs.getInt("book_id");
                int memberId = rs.getInt("member_id");

                Date dueDateSQL = rs.getDate("due_date");
                Date returnDate = rs.getDate("return_date");

                LocalDate dueDate =
                        dueDateSQL.toLocalDate();

                String status;

                if (returnDate != null) {

                    status = "Returned";

                } else {

                    LocalDate today = LocalDate.now();

                    long days =
                            ChronoUnit.DAYS.between(today, dueDate);

                    if (days < 0) {

                        status = "OVERDUE";

                    } else if (days == 0) {

                        status = "DUE TODAY";

                    } else if (days <= 3) {

                        status = "DUE SOON";

                    } else {

                        status = "ACTIVE";
                    }
                }

                area.append(
                    issueId + "\t" +
                    bookId + "\t" +
                    memberId + "\t" +
                    dueDate + "\t" +
                    status + "\n"
                );
            }

            con.close();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                this,
                "Error: " + e.getMessage()
            );
        }
    }

    public static void main(String[] args) {

        new DueDateTracking();
    }
}
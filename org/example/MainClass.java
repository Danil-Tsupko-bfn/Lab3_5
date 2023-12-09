package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class MainClass {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/your_database";
        String username = "danilstudent";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {

            CarTableCreator.createTable(connection);
            CustomerTableCreator.createTable(connection);

            System.out.println("Tables successfully created!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

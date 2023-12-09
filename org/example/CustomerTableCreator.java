package org.example;

import java.sql.Connection;
import java.sql.Statement;

public class CustomerTableCreator {

    public static void createTable(Connection connection) {
        try {
            Statement statement = connection.createStatement();

            String createCustomerTable = "CREATE TABLE Customer (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT," +
                    "name VARCHAR(255) NOT NULL," +
                    "email VARCHAR(255) NOT NULL UNIQUE," +
                    "phone_number VARCHAR(20)" +
                    ")";
            statement.executeUpdate(createCustomerTable);

            System.out.println("Customer table created successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

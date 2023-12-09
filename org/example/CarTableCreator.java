package org.example;

import java.sql.Connection;
import java.sql.Statement;

public class CarTableCreator {

    public static void createTable(Connection connection) {
        try {
            Statement statement = connection.createStatement();

            String createCarTable = "CREATE TABLE Car (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT," +
                    "brand VARCHAR(255) NOT NULL," +
                    "model VARCHAR(255) NOT NULL," +
                    "manufacturing_year INT," +
                    "horsepower DOUBLE," +
                    "price DECIMAL(10,2)" +
                    ")";
            statement.executeUpdate(createCarTable);

            System.out.println("Car table created successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

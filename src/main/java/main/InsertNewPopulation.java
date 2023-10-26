package main;

import java.sql.*;
import java.util.LinkedList;

public class InsertNewPopulation {
    private Connection conn = DBConnect.getConn().conn;
    InsertNewPopulation() {
        insert();
    }
    private void insert() {
        String newColumnName = "2024_population";
        String filepath = "data/new_population.csv";

        LinkedList<Population> latestPopulation = ReadCSV.readData(filepath);

        try {
            PreparedStatement alterStatement = conn.prepareStatement("ALTER TABLE population ADD " + newColumnName + " int(11)");
            alterStatement.executeUpdate("ALTER TABLE population ADD " + newColumnName + " int(11)");

            PreparedStatement updateStatement = conn.prepareStatement("UPDATE population SET " + newColumnName + " = ? WHERE country_name = ?");
            for (Population p: latestPopulation) {
                updateStatement.setInt(1, p.getPopulation());
                updateStatement.setString(2, p.getCountryName());
                updateStatement.addBatch();
            }

            updateStatement.executeBatch();
            alterStatement.close();

            System.out.println("========================================================");
            System.out.println("        New population data added successfully.         ");
            System.out.println("========================================================");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

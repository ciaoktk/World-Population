package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdatePopulation {
    private Scanner sc = new Scanner(System.in);
    private Check check = new Check();
    private Connection conn = DBConnect.getConn().conn;
    UpdatePopulation() {
        update();
    }
    private void update() {
        String year, isoName = "";
        do {
            System.out.print("Enter year (2020, 2021, 2022 or 2023): ");
            year = sc.nextLine();
        } while(!check.checkYear(year));
        String updateColumn = "" + year + "_population";

        boolean isoStatus = false;
        while(!isoStatus) {
            try {
                System.out.print("Enter country ISO name: ");
                isoName = sc.nextLine();

                if(check.checkISO(isoName)) {
                    isoStatus = true;
                }
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.print("Enter update population amount: ");
        int newPopulation = sc.nextInt();

        try {
            PreparedStatement updateStatement = conn.prepareStatement("UPDATE population SET " + updateColumn + " = ? WHERE iso_name = ?");

            updateStatement.setInt(1, newPopulation);
            updateStatement.setString(2, isoName.toUpperCase());
            updateStatement.addBatch();

            updateStatement.executeBatch();
            updateStatement.close();

            System.out.println("========================================================");
            System.out.println("         Population data updated successfully.          ");
            System.out.println("========================================================");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

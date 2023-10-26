package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Check {
	public boolean checkMenuOption(String input) {
		return switch (input) {
			case "1", "2", "3", "4", "5", "6" -> true;
			default -> {
				System.out.println("Enter only number between 1 and 6.");
				yield false;
			}
		};
	}
	public boolean checkRankOption(String input) {
		return switch (input) {
			case "1", "2" -> true;
			default -> {
				System.out.println("Enter only number 1 or 2.");
				yield false;
			}
		};
	}
	public boolean checkYear(String input) {
		return switch (input) {
			case "2020", "2021", "2022", "2023" -> true;
			default -> {
				System.out.println("Please choose year 2020, 2021, 2022 or 2023.");
				yield false;
			}
		};
	}

	public boolean checkISO(String input) throws Exception {
		Connection conn = DBConnect.getConn().conn;
		try {
			PreparedStatement selectStatement = conn.prepareStatement("SELECT iso_name FROM population");
			ResultSet resultSet = selectStatement.executeQuery();

			while (resultSet.next()) {
				if(resultSet.getString("iso_name").equalsIgnoreCase(input)) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new Exception("Please enter correct ISO name in three letters.");
	}
}

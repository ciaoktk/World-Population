package main;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    private Scanner sc = new Scanner(System.in);
    private Check check = new Check();
    private Connection conn;
    Menu() {
        conn = DBConnect.getConn().conn;
        displayMenu();
    }
    private int menu() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("                          Menu                          ");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("1. Inserting new population data");
        System.out.println("2. Updating population data");
        System.out.println("3. Re-ranking the world rank");
        System.out.println("4. Reporting");
        System.out.println("5. Exit");
        System.out.println("========================================================");

        String option;
        boolean optionStatus = false;
        do {
            System.out.print("Enter menu number between 1 and 5: ");
            option = sc.nextLine();
        } while(!check.checkMenuOption(option));
        return Integer.parseInt(option);
    }
    private void displayMenu() {
        switch(menu()) {
            case 1: new InsertNewPopulation(); break;
            case 2: new UpdatePopulation(); break;
            case 3: new ReRankWorldRank(); break;
            case 4: new Report(); break;
            case 5: {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                System.exit(0);
            }
        }
        displayMenu();
    }

    public static void main(String[] args) {
        new Menu();
    }
}

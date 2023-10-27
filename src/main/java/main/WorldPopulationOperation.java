package main;

import java.sql.Connection;
import java.util.Scanner;

public interface WorldPopulationOperation {
    Scanner sc = new Scanner(System.in);
    Connection conn = DBConnect.getConn().conn;
    Check check = new Check();
    void operate();
}

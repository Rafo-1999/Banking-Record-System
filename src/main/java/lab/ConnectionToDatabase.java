package lab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionToDatabase {

  public static void main(String[] args)throws ClassNotFoundException {
    var url = "jdbc:postgresql://localhost:5432/postgres";

    String username = "postgres";
    String password = "postgres";

    Class.forName("org.postgresql.Driver");

    try (Connection connection = DriverManager.getConnection(url, username, password)) {
      System.out.println("Connection Successful");
    } catch (SQLException exception) {
      System.out.println("No Connection");
    }

  }

}

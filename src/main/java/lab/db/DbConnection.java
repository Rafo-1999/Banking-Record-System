package lab.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DbConnection {
  private static final String DB_URI = "jdbc:postgresql://localhost:5432/postgres";
  private static final String USERNAME = "postgres";
  private static final String PASSWORD = "postgres";

  static {
    try {
      Class.forName("org.postgresql.Driver");
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  private DbConnection(){
  }

  public static Connection dbConnection(){
    try {
      return DriverManager.getConnection(DB_URI, USERNAME, PASSWORD);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
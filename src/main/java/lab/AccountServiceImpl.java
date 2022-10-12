package lab;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import lab.db.DbConnection;

public class AccountServiceImpl implements AccountService, AutoCloseable {
  private final Connection connection;

  public AccountServiceImpl() {
    this.connection = DbConnection.dbConnection();
  }

  @Override
  public void createAccount(String name, String surname) {
    createAccount(name, surname, 0.0);
  }

  @Override
  public void createAccount(String name, String surname, double money) {
    try {

      int personID = createPerson(name, surname);
      int bankAccaunt_Id = createBankAccount(personID, money);


      System.out.println("Account created with id " + personID + " and linked bank account " + bankAccaunt_Id);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

  }

  private int createBankAccount(int personID, double money) throws SQLException {
    String createUserQuery = "INSERT INTO bank_account (person_id, money) VALUES (?, ?)";

    var statement = connection.prepareStatement(createUserQuery, Statement.RETURN_GENERATED_KEYS);
    statement.setInt(1, personID);
    statement.setDouble(2, money);

    statement.executeUpdate();

    ResultSet rs = statement.getGeneratedKeys();
    if (rs.next()) {
      return rs.getInt(1);
    }
    throw new SQLException("Error creating bank account");
  }

  private int createPerson(String name, String surname) throws SQLException {
    String createUserQuery = "insert into person(name, surname) values(?,?)";

    var statement = connection.prepareStatement(createUserQuery, Statement.RETURN_GENERATED_KEYS);
    statement.setString(1, name);
    statement.setString(2, surname);
    statement.executeUpdate();

    ResultSet rs = statement.getGeneratedKeys();
    if (rs.next()) {
      return rs.getInt(1);
    }
    throw new SQLException("Error creating user");
  }

  @Override
  public void showAllUsers() throws SQLException {
    var stmt = connection.createStatement();
    String query = "SELECT * FROM person";
    ResultSet rs = stmt.executeQuery(query);

    while (rs.next()) {
      System.out.printf("%d\t%s%n", rs.getInt("id"), rs.getString("name"));
    }
    rs.close();
  }

  @Override
  public void transferMoney(int from, int to, double money) throws SQLException {
    try {
      System.out.println("Transfer money from person_id " + from + " to " + to+ " = " + money + "$");

      connection.setAutoCommit(false);
//      var statement =connection.createStatement();
//      String getMoney="SELECT * FROM bank_account(money)";
//      ResultSet resultSet=statement.executeQuery(getMoney);
//      while (resultSet.next()){
//        System.out.printf("%d\t%s%n",resultSet.getDouble("person_id"),resultSet.getDouble("money"));
//      }
//      resultSet.close();


//      PreparedStatement preparedStatement=connection.prepareStatement(getMoney);
//      ResultSet resultSet=preparedStatement.executeQuery(getMoney);
//
//      while (resultSet.next()){
//        System.out.printf("%d\t%s%n",resultSet.getDouble("person_id"),resultSet.getDouble("money"));
//
//      }
//      preparedStatement.executeUpdate();
//
//      resultSet.close();


      String updateRequest = "update bank_account set money=? where person_id=?";

      PreparedStatement firstUserStatement = connection.prepareStatement(updateRequest);
      firstUserStatement.setDouble(1, money);
      firstUserStatement.setDouble(2, from);

      PreparedStatement secondUserStatement = connection.prepareStatement(updateRequest);
      secondUserStatement.setDouble(1, money);
      secondUserStatement.setDouble(2, to);


      firstUserStatement.executeUpdate();
      secondUserStatement.executeUpdate();
      connection.commit();
    } catch (SQLException e) {
      connection.rollback();
    }
  }

  @Override
  public void close() throws SQLException {
    if (connection == null) {
      return;
    }

    connection.close();
  }
}
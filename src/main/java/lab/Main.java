package lab;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Scanner;
import lab.db.DbConnection;

public class Main {

  public static void main(String[] args) throws SQLException {

    Scanner sc = new Scanner(System.in);

    while (true) {
      AccountService accountService = new AccountServiceImpl();

      System.out.println("Welcome to Bank");
      System.out.println("Please choose what you need");
      System.out.println("N1 -> Create Account");
      System.out.println("N2 -> See all accounts");
      System.out.println("N3 -> Transfer Money");
      System.out.println("N4 -> Delete Account");
      System.out.println("N5 -> Exit the Program");
      System.out.print("     Input Number->");
      Integer input = 0;

      String inp = sc.nextLine();
      try {
        input = Integer.valueOf(inp);
      } catch (Exception e) {
        System.out.println("Input valid data!");
    continue;

      }

      switch (input) {

        case 1:

          System.out.println(
              "Create person Account,input <name>,<surname> and <balance> ");

          accountService.createAccount(sc.next(), sc.next(), sc.nextDouble());
          createUserTable();
          System.out.println("Has also been created bank account ");
          createBankAccountTable();

          break;

        case 2:

          System.out.println("All accounts! ->");
          accountService.showAllUsers();
          break;
        case 3:
          System.out.println("Transfer money from one account to another");
          System.out.println("Input first and second account and money");

          accountService.transferMoney(sc.nextInt(), sc.nextInt(), sc.nextInt());
          break;
        case 4:

          System.out.println("Write  id of the program,do you want to delete");
          sc.nextInt();
          accountService.close();
          System.out.println("Account deleted!");
          break;

        default:
          if (input != 5) {
            System.out.println("Invalid entry!");
            break;
          }

      }

      if (input == 5) {
        System.out.println(
            "Exited Successfully!\n Thank You :)");
      }

    }
  }





  private static void createUserTable() throws SQLException {
    Connection connection = DbConnection.dbConnection();
    Statement statement = connection.createStatement();
    String sql = """
        create table IF NOT EXISTS person
        (
            id      serial primary key,
            name    varchar(255),
            surname varchar(255)
        );
        """;

    statement.executeUpdate(sql);
  }

  private static void createBankAccountTable() throws SQLException {
    Connection connection = DbConnection.dbConnection();
    Statement statement = connection.createStatement();
    String sql = """
        create table IF NOT EXISTS bank_account
        (
            id      serial primary key,
            person_id integer REFERENCES person,
            money NUMERIC
        );
        """;

    statement.executeUpdate(sql);
  }
}
package lab;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import lab.entity.User;

public interface AccountService {

  void createAccount(String name, String surname);
  void createAccount(String name, String surname, double money);

  void showAllUsers() throws SQLException;

  void transferMoney(int from,int to, double money) throws SQLException;


  void close(int id) throws SQLException;

}
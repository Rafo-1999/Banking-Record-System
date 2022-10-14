  package lab;

  import java.sql.Connection;
  import java.sql.PreparedStatement;
  import java.sql.ResultSet;
  import java.sql.SQLException;
  import java.sql.Statement;

  import lab.db.DbConnection;

  public class AccountServiceImpl implements AccountService {
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

        String getmoney="update bank_account set money=money-? where person_id=?";
        PreparedStatement getFirstUserStatement=connection.prepareStatement(getmoney);
        getFirstUserStatement.setDouble(1,money);
        getFirstUserStatement.setDouble(2,from);
        getFirstUserStatement.executeUpdate();

        String setmoney="update bank_account set money=money+? where person_id=?";
        PreparedStatement getSecondUserStatement=connection.prepareStatement(setmoney);
        getSecondUserStatement.setDouble(1,money);
        getSecondUserStatement.setDouble(2,to);
        getSecondUserStatement.executeUpdate();


        connection.commit();
      } catch (SQLException e) {
        connection.rollback();
      }
    }

    @Override
    public void close(int id) throws SQLException {
      if (connection == null) {
        return;
      }
      Statement statement= connection.createStatement();
      String query="DELETE FROM person WHERE id = ?";
      try(Connection connection1=this.connection;
          PreparedStatement preparedStatement=connection.prepareStatement(query) ){
              preparedStatement.setInt(1,id);

        preparedStatement.executeUpdate();
      }catch (SQLException e){
        System.out.println(e.getMessage());
      }

    }
  }
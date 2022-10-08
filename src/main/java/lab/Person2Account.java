package lab;

public class Person2Account {
  public String name;
  public String surname;
  public int customerID;
  public int accountNumber;

  public Person2Account(String name, String surname, int customerID, int accountNumber) {
    this.name = name;
    this.surname = surname;
    this.customerID = customerID;
    this.accountNumber = accountNumber;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public int getCustomerID() {
    return customerID;
  }

  public void setCustomerID(int customerID) {
    this.customerID = customerID;
  }

  public int getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(int accountNumber) {
    this.accountNumber = accountNumber;
  }
}

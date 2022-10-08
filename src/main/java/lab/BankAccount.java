package lab;

public class BankAccount {

  double balance;

  public void account() {
    balance = 0.0;

  }

  public void addMoney(double money) {
    balance = balance + money;

  }
  public void transferMoney(double money,BankAccount transferFrom,BankAccount transferTo){
    if (transferFrom.balance>=money){
          transferFrom.balance=transferFrom.balance-money;
          transferTo.balance=transferTo.balance+money;
      System.out.println("Money transfer completed");
    }else {
      System.out.println("Transfer failed");
    }
  }

}

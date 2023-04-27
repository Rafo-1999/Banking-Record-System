# Banking-Record-System

My program gives an console interface for bank account management by bank staff. It is written in Java programming language, using Intellij IDEA. I`ve used several technologies such as Java Core, OOP, JDBC, PostgreSQL, SQL, Maven, Docker, Git/Github.

## Working process.

Program asks the user for choosing operation to perform.

### N1 -> Create Account

               Asks for client name, surname and bank account. After entering the data prints the number of current account.
               
### N2 -> See all accounts

               Prints all registered accounts.
               
### N3 -> Transfer Money

               Asks the user to enter IDs of accounts (in form: sender-receiver) and the amount of money.
               
### N4 -> Delete Account

               Asks the user to enter AccountID and deletes the account.
               
### N5 -> Exit the Program

          In case of user invalid input such as other symbol or number program gives "Invalid input data!"
          
## Program structure.

I created PostgreSql database. Started new project giving his build system -maven. Giving the pattern in docker-compose.yml I connected it with docker. In this case pom.xml file is created having maven dependecie. In this case the advantage is that after every restart of PC the connected is being automatic.

I created DbConnection.java class,in which I wrote the database connection. I created AccountServiceImpl class, in which I wrote all the methods,which were implemented from AccountService. I created User and BankAccount,in which I declared all the variables. In the database I created Bank account ,in which client`s accountID,balance and account are stored.

I tested the programm with main class,in which I called all the methods and wrote exceptions respectively.

I`ve created Github repository and pushed the project on master branch.

Style is followed from the Google coding style checkstyle.xml file

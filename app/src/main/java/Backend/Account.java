package Backend;

import Database.DatabaseConnection;

import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Account extends Client {

    private int accountNumber;
    private double balance;
    private int cardVerificationValue;
    private Date expirationDate;

    public Account(Client client, double initialBalance) {
        super(client.getName());
        this.accountNumber = generateAccountNumber();
        this.balance = initialBalance;
        this.cardVerificationValue = generateCardVerificationValue();
        this.expirationDate = calculateExpirationDate();
    }

    public double getBalance() { return balance; }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getAccountNumber() {
        return generateAccountNumber();
    }

    public int getCardVerificationValue() {
        return generateCardVerificationValue();
    }

    public Date getExpirationDate() {
        return calculateExpirationDate();
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " deposited successfully into account number " + accountNumber);
        } else {
            System.out.println("Invalid amount. Deposit amount must be greater than zero.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(amount + " withdrawn successfully from account number " + accountNumber);
        } else {
            System.out.println("Invalid amount or insufficient balance.");
        }
    }

    public void updateAccount(double newBalance, int newCVV, Date newExpirationDate) {
        if (newBalance >= 0) {
            this.balance = newBalance;
        }
        if (newCVV >= 0) {
            this.cardVerificationValue = newCVV;
        }
        if (newExpirationDate != null) {
            this.expirationDate = newExpirationDate;
        }
    }

    private int generateCardVerificationValue() {
        return (int) (Math.random() * (999 - 100 + 1) + 100);
    }

    private int generateAccountNumber() {
        return (int) (Math.random() * (9999 - 1000 + 1) + 1000);
    }

    private Date calculateExpirationDate() {
        Date creationDate = new Date();

        long expirationTimeMillis = creationDate.getTime() + (5L * 365L * 24L * 60L * 60L * 1000L);
        return new Date(expirationTimeMillis);
    }

    private void updateBalanceInDatabase() {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // Get a connection to the database
            connection = DatabaseConnection.getConnection();

            // Prepare the SQL statement
            String sql = "UPDATE accounts SET balance = ? WHERE account_number = ?";
            statement = connection.prepareStatement(sql);
            statement.setDouble(1, balance);
            statement.setInt(2, accountNumber);

            // Execute the statement
            statement.executeUpdate();
            System.out.println("Account balance updated in the database.");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the connection and statement
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

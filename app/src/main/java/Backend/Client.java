package Backend;

import Database.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Client {

    private String name;
    private int phoneNumber;
    private  String address;
    private Account clientAccount;

    public Client(String name){
        this.name = name;
    }

    public Client(String name, int phoneNumber, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Method to save the client data to the database
    public void saveToDatabase() {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // Get a connection to the database
            connection = DatabaseConnection.getConnection();

            // Prepare the SQL statement
            String sql = "INSERT INTO clients (name, phone_number, address) VALUES (?, ?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setInt(2, phoneNumber);
            statement.setString(3, address);

            // Execute the statement
            statement.executeUpdate();
            System.out.println("Client data saved to the database.");

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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JdbcPr;

/**
 *
 * @author Lenovo
 */
import java.sql.*;

public class PR5 {
    public static void main(String[] args) throws Exception {
        String urldb = "jdbc:mysql://localhost:3306/bank";
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn;
        conn = DriverManager.getConnection(urldb, "root", "");
        System.out.println(conn);
        if (conn != null) {
            Statement stmt;
            stmt = conn.createStatement();
            
            String insertQuery = "INSERT INTO bank (AccountNo,CustomerName,Balance,PhoneNo,Address) VALUES (6,'JENY',20000,9758218765,'THALTEJ')";
            stmt.executeUpdate(insertQuery);

            // Update the balance of a record in the Bank table
            String updateQuery = "UPDATE Bank SET Balance = 40000 WHERE AccountNo = 2";
            stmt.executeUpdate(updateQuery);

            // Delete a record from the Bank table
            String deleteQuery = "DELETE FROM Bank WHERE AccountNo = 3";
            stmt.executeUpdate(deleteQuery);

            // Retrieve and print values of customers with balance greater than 20000
            String selectQuery = "SELECT * FROM Bank WHERE Balance > 20000";
            ResultSet resultSet = stmt.executeQuery(selectQuery);

            while (resultSet.next()) {
                int accountNo = resultSet.getInt("AccountNo");
                String customerName = resultSet.getString("CustomerName");
                int balance = resultSet.getInt("Balance");
                String phone = resultSet.getString("PhoneNo");
                String address = resultSet.getString("Address");

                System.out.println("Account No: " + accountNo);
                System.out.println("Customer Name: " + customerName);
                System.out.println("Balance: " + balance);
                System.out.println("Phone No: " + phone);
                System.out.println("Address: " + address);
                System.out.println();
            }
            conn.close();
        }
    }
}
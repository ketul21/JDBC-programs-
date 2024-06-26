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

public class PR4 {
    public static void main(String[] args) throws Exception {
        String urldb = "jdbc:mysql://localhost:3306/employee";
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn;
        conn = DriverManager.getConnection(urldb, "root", "");
        System.out.println(conn);
        if (conn != null) {
            Statement stmt;
            stmt = conn.createStatement();
            String query = "UPDATE emp SET Salary = Salary + 500 WHERE Age > 40";
            int rowsUpdated = stmt.executeUpdate(query);
            System.out.println("Number of records updated: " + rowsUpdated);
            String selectQuery = "SELECT * FROM emp WHERE Age > 40";
            ResultSet resultSet = stmt.executeQuery(selectQuery);

            while (resultSet.next()) {
                String Name = resultSet.getString("Name");
                int Age = resultSet.getInt("Age");
                int Salary = resultSet.getInt("Salary");
                
                System.out.println("Customer Name: " + Name);
                System.out.println("Account No: " + Age);
                System.out.println("Balance: " + Salary);
                System.out.println();
            }
            conn.close();
        }
    }
}

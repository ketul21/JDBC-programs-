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
public class PR2 {

    public static void main(String[] args) throws Exception {
        String urldb = "jdbc:mysql://localhost:3306/student";
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn;
        conn = DriverManager.getConnection(urldb, "root", "");
        System.out.println(conn);
        if (conn != null) {
            String insertQuery = "Insert into stud1 values (?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);

            preparedStatement.setString(1, "ANCHITA");
            preparedStatement.setInt(2, 180);
            preparedStatement.setString(3, "CE");
            preparedStatement.executeUpdate();

            preparedStatement.setString(1, "KENIN");
            preparedStatement.setInt(2, 186);
            preparedStatement.setString(3, "CE");
            preparedStatement.executeUpdate();

            preparedStatement.setString(1, "SOHAM");
            preparedStatement.setInt(2, 188);
            preparedStatement.setString(3, "CE");
            preparedStatement.executeUpdate();

            preparedStatement.close();
            conn.close();
        }
    }
}
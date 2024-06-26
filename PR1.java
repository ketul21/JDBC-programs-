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

public class PR1 {

    public static void main(String[] args) throws Exception {
        String urldb = "jdbc:mysql://localhost:3306/student";
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn;
        conn = DriverManager.getConnection(urldb, "root", "");
        System.out.println(conn);
        if (conn != null) {
            Statement stmt;
            String sql = "select * from stud";
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println("Name:" + rs.getString(1));
                System.out.println("RollNo:" + rs.getInt(2));
            }
            rs.close();
            conn.close();
        }
    }

}

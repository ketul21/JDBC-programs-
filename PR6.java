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

import java.io.*;
import java.sql.*;
import java.util.*;

public class PR6 {
    public static void main(String[] args) throws Exception {
        String urldb = "jdbc:mysql://localhost:3306/photo";
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn;
        conn = DriverManager.getConnection(urldb, "root", "");
        System.out.println(conn);
        if (conn != null) {
            Scanner sin = new Scanner(System.in);
            int id = sin.nextInt();
            String fname = sin.next();
            File f = new File(fname);
            if(f.isFile()){
                FileInputStream fis = new FileInputStream(f);
                String sql = "Insert Into car values(?,?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, id);
                pstmt.setBinaryStream(2, fis, f.length());
                int rows = pstmt.executeUpdate();
                String sql1 = "Select PHOTO From car";
                pstmt = conn.prepareStatement(sql1);
                ResultSet rs = pstmt.executeQuery();
                while(rs.next()){
                    Blob img = rs.getBlob("PHOTO");
                    byte barr[] = img.getBytes(1, (int)img.length());
                    FileOutputStream fos = new FileOutputStream("retimage.png");
                    fos.write(barr);
                }
                pstmt.close();
            }
            conn.close();
        }
    }
}
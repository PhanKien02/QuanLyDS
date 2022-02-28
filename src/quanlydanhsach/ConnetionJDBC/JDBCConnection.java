package quanlydanhsach.ConnetionJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

 
public class JDBCConnection {
    public static Connection getConnection() {
    	 String DB_URL = "jdbc:sqlserver://localhost:1433;"
    	            + "databaseName=DanhSach;";
    	  String USER_NAME = "sa";
    	 String PASSWORD = "123456";
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD );
            if(conn != null){
                 System.out.println("connect successfully!");
            }
            else{
                System.out.println("connect failure!");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("connect failure!");
        }
        return conn;
    }
}
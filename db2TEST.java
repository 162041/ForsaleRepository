package com;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class DButil {
    public static Connection getConnection() {
        Connection con = null;
        try{
            Class.forName("org.h2.Driver");	//

            //ƴ     ݿ      ַ
            String dbURL = "jdbc:h2:D:/temps/大兵";

            String db_User = "sa";	//   ݿ  û

            String db_pwd = "";	//   ݿ  û

            con = DriverManager.getConnection(dbURL, db_User, db_pwd);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void closeConnection(Connection conn,PreparedStatement ps,ResultSet rs) {
        try{
            if(ps != null) {
                ps.close();
            }
            if(conn != null) {
                conn.close();
            }
            if(rs != null) {
                rs.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

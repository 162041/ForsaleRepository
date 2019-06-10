package com;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("flowid"));
        deletemsg(id);
        req.getRequestDispatcher("/FindServlet").forward(req,resp);
    }

    public void  deletemsg(int id){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            String driverClass="com.mysql.jdbc.Driver";
            String url="jdbc:mysql://localhost:3306/web02?useUnicode=true&characterEncoding=utf-8";
            String user="root";
            String password="zxhzxhzk";
            Class.forName(driverClass);
            connection=DriverManager.getConnection(url, user, password);
            String sql="DELETE FROM liuyan where id= ?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{

            try {
                if(preparedStatement !=null){
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                if(connection !=null){
                    connection.close();
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
}

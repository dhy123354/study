package com.JDBC;

import java.sql.*;

public class JDBCdemo6 {
    public static void main(String[] args) {
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            String sql = "select * from department";
            conn = DriverManager.getConnection("jdbc:mysql:///db4","root","root");
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                //获取数据
                //6.2 获取数据
                int id = rs.getInt(1);
                String name = rs.getString("dep_name");
                String balance = rs.getString(3);

                System.out.println(id + "---" + name + "---" + balance);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            if (rs != null){
                try {
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

            if(stmt != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

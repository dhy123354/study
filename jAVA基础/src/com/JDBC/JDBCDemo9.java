package com.JDBC;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo9 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = JdbcUtils.getConnection();
            connection.setAutoCommit(false);
            ps = connection.prepareStatement("update account set balance = balance - ? where name=?" );
            ps.setInt(1, 500);
            ps.setString(2,"Jack");
            ps.executeUpdate();
            //出现异常
//            System.out.println(100 / 0);

            ps = connection.prepareStatement("update account set balance = balance + ? where name=?");
            ps.setInt(1, 500);
            ps.setString(2,"Rose");
            ps.executeUpdate();

            connection.commit();
            System.out.println("转账成功");
        } catch (Exception throwables) {
            throwables.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("转账失败：");
        }finally {
            JdbcUtils.close(connection, (Statement) ps);
        }
    }
}

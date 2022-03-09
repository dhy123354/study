package com.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCDome3 {
    public static void main(String[] args) {
        List<emp> list = new JDBCDome3().findAll();
        System.out.println(list);
        System.out.println(list.size());
    }

    public List<emp> findAll(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<emp> list = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///db5", "root", "root");
            String sql = "select * from emp";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            emp emp = null;
            list = new ArrayList<>();
            while (rs.next()){
                int id = rs.getInt("id");
                String ename = rs.getString("ename");
                int job_id = rs.getInt("job_id");
                int mgr = rs.getInt("mgr");
                Date joindate = rs.getDate("joindate");
                double salary = rs.getDouble("salary");
                double bonus = rs.getDouble("bonus");
                int dept_id = rs.getInt("dept_id");

                emp = new emp();
                emp.setId(id);
                emp.setName(ename);
                emp.setJob_id(job_id);
                emp.setMgr(mgr);
                emp.setJoindate(joindate);
                emp.setSalary(salary);
                emp.setBonus(bonus);
                emp.setDept_id(dept_id);

                //装载集合
                list.add(emp);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

}

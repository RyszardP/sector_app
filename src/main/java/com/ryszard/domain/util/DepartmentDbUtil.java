package com.ryszard.domain.util;

import com.ryszard.domain.vo.Department;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDbUtil implements ConnectionClose {

    private DataSource dataSource;

    public DepartmentDbUtil(DataSource theDataSource) {
        dataSource = theDataSource;
    }

    public List<Department> getDepartments() throws Exception {
        List<Department> departments = new ArrayList<>();

        Connection myConnection = null;
        Statement myStatement = null;
        ResultSet myResultSet = null;
        try {
            myConnection = dataSource.getConnection();
            String sql = "select * from department order by department_name";
            myStatement = myConnection.createStatement();
            myResultSet = myStatement.executeQuery(sql);
            while (myResultSet.next()) {
                int departmentId = myResultSet.getInt("department_id");
                String departmentName = myResultSet.getString("department_name");
                Department tempDepartment = new Department(departmentId, departmentName);
                departments.add(tempDepartment);
            }
            return departments;
        } finally {

            close(myConnection, myStatement, myResultSet);
        }
    }

    public void close(Connection myConnection, Statement myStatement, ResultSet myResultSet) {
        try {
            if (myResultSet != null) {
                myResultSet.close();
            }
            if (myStatement != null) {
                myStatement.close();
            }
            if (myConnection != null) {
                myConnection.close();
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public void addDepartment(Department theDepartment) throws Exception {
        Connection myConnection = null;
        PreparedStatement myPreparedStatement = null;
        try {
            myConnection = dataSource.getConnection();
            String sql = "insert into department "
                    + "(department_name) "
                    + "values (?)";

            myPreparedStatement = myConnection.prepareStatement(sql);
            myPreparedStatement.setString(1, theDepartment.getDepartmentName());
            myPreparedStatement.execute();
        } finally {
            close(myConnection, myPreparedStatement, null);
        }
    }

    public Department getDepartment(String theDepartmentId) throws Exception {

        Department theDepartment = null;
        Connection myConnection = null;
        PreparedStatement myPreparedStatement = null;
        ResultSet myResultSet = null;
        int departmentId;
        try {
            departmentId = Integer.parseInt(theDepartmentId);
            myConnection = dataSource.getConnection();
            String sql = "select * from department where department_id=?";
            myPreparedStatement = myConnection.prepareStatement(sql);
            myPreparedStatement.setInt(1, departmentId);
            myResultSet = myPreparedStatement.executeQuery();
            if (myResultSet.next()) {
                String departmentName = myResultSet.getString("department_name");
                theDepartment = new Department(departmentId, departmentName);
            } else {
                throw new Exception("Could not find department id: " + departmentId);
            }
            return theDepartment;
        } finally {
            close(myConnection, myPreparedStatement, myResultSet);
        }
    }

    public void updateDepartment(Department theDepartment) throws Exception {
        Connection myConnection = null;
        PreparedStatement myPreparedStatement = null;
        try {
            myConnection = dataSource.getConnection();
            String sql = "update department "
                    + "set department_name=? "
                    + "where department_id=?";
            myPreparedStatement = myConnection.prepareStatement(sql);
            myPreparedStatement.setString(1, theDepartment.getDepartmentName());
                      myPreparedStatement.execute();
        } finally {
                       close(myConnection, myPreparedStatement, null);
        }
    }

    public void deleteDepartment(String theDepartmentId) throws Exception {
        Connection myConnection = null;
        PreparedStatement myPreparedStatement = null;
        try {
                       int departmentId = Integer.parseInt(theDepartmentId);
            myConnection = dataSource.getConnection();
            String sql = "delete from department where department_id=?";
            myPreparedStatement = myConnection.prepareStatement(sql);
            myPreparedStatement.setInt(1, departmentId);
            myPreparedStatement.execute();
        } finally {
            close(myConnection, myPreparedStatement, null);
        }
    }
}

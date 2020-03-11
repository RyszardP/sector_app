package com.ryszard.domain.util;

import com.ryszard.domain.vo.User;

import javax.sql.DataSource;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class UserDbUtil implements ConnectionClose {

    private DataSource dataSource;

   // SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    public UserDbUtil(DataSource theDataSource) {
        dataSource = theDataSource;
    }

    public List<User> getUsers() throws Exception {
        List<User> users = new ArrayList<>();
        Connection myConnection = null;
        Statement myStatement = null;
        ResultSet myResultSet = null;

        try {
            myConnection = dataSource.getConnection();
            String sql = "select * from user order by user_name";
            myStatement = myConnection.createStatement();
            myResultSet = myStatement.executeQuery(sql);
            while (myResultSet.next()) {
                int userId = myResultSet.getInt("user_id");
                String userName = myResultSet.getString("user_name");
                String userSurname = myResultSet.getString("user_surname");
                String login = myResultSet.getString("user_login");
                String password = myResultSet.getString("user_password");
                Timestamp userBirthDate = Timestamp.valueOf(myResultSet.getString("user_birthday"));
                User tempUser = new User(userId, userName, userSurname, login, password, userBirthDate);
                users.add(tempUser);
            }
            return users;
        } finally {
            close(myConnection, myStatement, myResultSet);
        }
    }

    public void close(Connection myConn, Statement myStmt, ResultSet myRs) {
        try {
            if (myRs != null) {
                myRs.close();
            }
            if (myStmt != null) {
                myStmt.close();
            }
            if (myConn != null) {
                myConn.close();
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public void addUser(User theUser) throws Exception {

        Connection myConnection = null;
        PreparedStatement myPreparedStatement = null;

        try {
            myConnection = dataSource.getConnection();
            String sql = "insert into user "
                    + "(user_name, user_surname, user_login, user_password, user_birthday) "
                    + "values (?, ?, ?, ?, ?)";
            myPreparedStatement = myConnection.prepareStatement(sql);
            myPreparedStatement.setString(1, theUser.getUserName());
            myPreparedStatement.setString(2, theUser.getUserSurname());
            myPreparedStatement.setString(3, theUser.getLogin());
            myPreparedStatement.setString(4, theUser.getPassword());
            myPreparedStatement.setString(5, String.valueOf(theUser.getBirthDate()));
            myPreparedStatement.execute();
        } finally {
            close(myConnection, myPreparedStatement, null);
        }
    }

    public User getUser(String theUserId) throws Exception {
        User theUser = null;
        Connection myConnection = null;
        PreparedStatement myPreparedStatement = null;
        ResultSet myResultSet = null;
        int userId;

        try {
            userId = Integer.parseInt(theUserId);
            myConnection = dataSource.getConnection();
            String sql = "select * from user where user_id=?";
            myPreparedStatement = myConnection.prepareStatement(sql);
            myPreparedStatement.setInt(1, userId);
            myResultSet = myPreparedStatement.executeQuery();
            if (myResultSet.next()) {
                String userName = myResultSet.getString("user_name");
                String userSurname = myResultSet.getString("user_surname");
                String userLogin = myResultSet.getString("user_login");
                String userPassword = myResultSet.getString("user_password");
                Timestamp userBirthday = Timestamp.valueOf(myResultSet.getString("user_birthday"));
                theUser = new User(userId, userName, userSurname, userLogin, userPassword, userBirthday);
            } else {
                throw new Exception("Could not find user id: " + userId);
            }
            return theUser;
        } finally {
            close(myConnection, myPreparedStatement, myResultSet);
        }
    }

    public void updateUser(User theUser) throws Exception {

        Connection myConnection = null;
        PreparedStatement myPreparedStatement = null;

        try {
            myConnection = dataSource.getConnection();
            String sql = "update user "
                    + "set user_name=?, user_surname=?, user_login=?, user_password=?, user_birthday=? "
                    + "where user_id=?";
            myPreparedStatement = myConnection.prepareStatement(sql);
            myPreparedStatement.setString(1, theUser.getUserName());
            myPreparedStatement.setString(2, theUser.getUserSurname());
            myPreparedStatement.setString(3, theUser.getLogin());
            myPreparedStatement.setString(4, theUser.getPassword());
            myPreparedStatement.setString(5, String.valueOf(theUser.getBirthDate()));
            myPreparedStatement.setInt(6, theUser.getUserId());
            myPreparedStatement.execute();
        } finally {
            close(myConnection, myPreparedStatement, null);
        }
    }

    public void deleteUser(String theUserId) throws Exception {
        Connection myConnection = null;
        PreparedStatement myPreparedStatement = null;
        try {

            int userId = Integer.parseInt(theUserId);
            myConnection = dataSource.getConnection();
            String sql = "delete from user where user_id=?";
            myPreparedStatement = myConnection.prepareStatement(sql);
            myPreparedStatement.setInt(1, userId);
            myPreparedStatement.execute();
        } finally {
            close(myConnection, myPreparedStatement, null);
        }
    }
}

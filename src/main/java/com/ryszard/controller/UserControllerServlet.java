package com.ryszard.controller;

import com.ryszard.domain.util.UserDbUtil;
import com.ryszard.domain.vo.User;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.sql.Timestamp;
import java.util.List;

@WebServlet("/UserControllerServlet")
public class UserControllerServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private UserDbUtil userDbUtil;

    @Resource(name = "jdbc/factory_data")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            userDbUtil = new UserDbUtil(dataSource);
        } catch (Exception exc) {
            throw new ServletException(exc);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            String theCommand = request.getParameter("command");
            if (theCommand == null) {
                theCommand = "LIST";
            }
            switch (theCommand) {

                case "LIST":
                    listUsers(request, response);
                    break;

                case "ADD":
                    addUser(request, response);
                    break;

                case "LOAD":
                    loadUser(request, response);
                    break;

                case "UPDATE":
                    updateUser(request, response);
                    break;

                case "DELETE":
                    deleteUser(request, response);
                    break;

                default:
                    listUsers(request, response);
            }

        } catch (Exception exc) {
            throw new ServletException(exc);
        }

    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String theUserId = request.getParameter("userId");
        userDbUtil.deleteUser(theUserId);
        listUsers(request, response);
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int userId = Integer.parseInt(request.getParameter("userId"));
        String userName = request.getParameter("userName");
        String userSurname = request.getParameter("userSurname");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        Timestamp birthDate = Timestamp.valueOf(request.getParameter("birthDate"));
        User theUser = new User(userId, userName, userSurname, login, password, birthDate);
        userDbUtil.updateUser(theUser);
        listUsers(request, response);

    }

    private void loadUser(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String theUserId = request.getParameter("userId");
        User theUser = userDbUtil.getUser(theUserId);
        request.setAttribute("THE_USER", theUser);

        RequestDispatcher dispatcher =
                request.getRequestDispatcher("/update-user-form.jsp");
        dispatcher.forward(request, response);
    }

    private void addUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String userName = request.getParameter("userName");
        String userSurname = request.getParameter("userSurname");
        String userLogin = request.getParameter("userLogin");
        String userPassword = request.getParameter("userPassword");
        Timestamp userBirthday = Timestamp.valueOf(request.getParameter("userBirthday"));
        User theUser = new User(userName, userSurname, userLogin, userPassword, userBirthday);
        userDbUtil.addUser(theUser);
        listUsers(request, response);
    }

    private void listUsers(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        List<User> users = userDbUtil.getUsers();
        request.setAttribute("USER_LIST", users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list-users.jsp");
        dispatcher.forward(request, response);
    }

}





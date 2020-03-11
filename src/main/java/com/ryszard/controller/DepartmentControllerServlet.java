package com.ryszard.controller;

import com.ryszard.domain.util.DepartmentDbUtil;
import com.ryszard.domain.vo.Department;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.util.List;

@WebServlet("/DepartmentControllerServlet")
public class DepartmentControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private DepartmentDbUtil departmentDbUtil;

    @Resource(name = "jdbc/factory_data")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            departmentDbUtil = new DepartmentDbUtil(dataSource);
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
                    listDepartments(request, response);
                    break;
                case "ADD":
                    addDepartment(request, response);
                    break;
                case "LOAD":
                    loadDepartment(request, response);
                    break;
                case "UPDATE":
                    updateDepartment(request, response);
                    break;
                case "DELETE":
                    deleteDepartment(request, response);
                    break;
                default:
                    listDepartments(request, response);
            }
        } catch (Exception exc) {
            throw new ServletException(exc);
        }

    }

    private void deleteDepartment(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String theDepartmentId = request.getParameter("departmentId");
        departmentDbUtil.deleteDepartment(theDepartmentId);
        listDepartments(request, response);
    }

    private void updateDepartment(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int departmentId = Integer.parseInt(request.getParameter("departmentId"));
        String departmentName = request.getParameter("department_name");
        Department theDepartment = new Department(departmentName);
        departmentDbUtil.updateDepartment(theDepartment);
        listDepartments(request, response);
    }

    private void loadDepartment(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String theDepartmentId = request.getParameter("studentId");
        Department theDepartment = departmentDbUtil.getDepartment(theDepartmentId);
        request.setAttribute("THE_DEPARTMENT", theDepartment);
        RequestDispatcher dispatcher =
                request.getRequestDispatcher("/update-department-form.jsp");
        dispatcher.forward(request, response);
    }

    private void addDepartment(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String departmentName = request.getParameter("departmentName");
        Department theDepartment = new Department(departmentName);
        departmentDbUtil.addDepartment(theDepartment);
        listDepartments(request, response);
    }

    private void listDepartments(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        List<Department> departments = departmentDbUtil.getDepartments();
        request.setAttribute("DEPARTMENT_LIST", departments);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list-departments.jsp");
        dispatcher.forward(request, response);
    }

}

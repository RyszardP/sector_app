package com.ryszard.dao.impls;

import com.ryszard.dao.EmployeeDao;
import com.ryszard.dao.connectionPool.ConnectionPool;
import com.ryszard.dao.connectionPool.ConnectionPoolException;
import com.ryszard.domain.vo.Employee;
import com.ryszard.exception.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    private static final String DELETE_BY_ID = "DELETE FROM employee WHERE employee_id = ?";
    private static final String SELECT_BY_ID = "SELECT * FROM employee WHERE employee_id = ?";
    private static final String SELECT_ALL_EMPLOYEES = "SELECT * FROM employee";
    private static final String UPDATE_EMPLOYEE = "UPDATE employee SET employee_sector_id = ? and employee_position = ?" +
            " WHERE employee_id = ? LIMIT 1";
    private static final String CREATE_EMPLOYEE = "INSERT INTO employee (employee_sector, employee_position) " +
            " VALUES (?, ?)";
    private static final String LAST_INSERT_ID = "SELECT last_insert_id() as lastId";

    private static final String EMPLOYEE_SECTOR_ID = "employeeSectorId";
    private static final String EMPLOYEE_POSITION = "employeePosition";

    private static final ConnectionPool pool = ConnectionPool.getInstance();

    public EmployeeDaoImpl() {
    }


    private static class SingletonHolder {
        private static final EmployeeDao instance = new EmployeeDaoImpl();
    }

    @Override
    public List<Employee> findAll() throws DaoException {
        List<Employee> employeeList = new ArrayList<>();
        try (Connection connect = pool.getConnection();
             PreparedStatement statement = connect.prepareStatement(SELECT_ALL_EMPLOYEES)) {
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                Employee employee = new Employee();
                employee.setEmployeeSectorId(set.getLong(EMPLOYEE_SECTOR_ID));
                employee.setEmployeePosition(set.getString(EMPLOYEE_POSITION));
                employeeList.add(employee);
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
        return employeeList;
    }

    @Override
    public Employee findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Employee save(Employee entity) {
        return null;
    }

    @Override
    public Employee update(Employee entity) {
        return null;
    }

    @Override
    public List<Employee> search(Employee entity) {
        return null;
    }
}

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

    private static final String EMPLOYEE_SECTOR_ID = "employeeSector_id";
    private static final String EMPLOYEE_POSITION = "employee_position";
    private static final String EMPLOYEE_ID = "employee_id";
    private static final String LAST_ID_ATTRIBUTE = "lastId";

    private static final ConnectionPool pool = ConnectionPool.getInstance();

    private EmployeeDaoImpl() {
    }


    private static class SingletonHolder {
        private static final EmployeeDao instance = new EmployeeDaoImpl();
    }

    public static EmployeeDao getInstance() {
        return SingletonHolder.instance;
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
    public Employee findById(Integer id) throws DaoException {
        try (Connection connect = pool.getConnection();
             PreparedStatement statement = connect.prepareStatement(SELECT_BY_ID)) {
            statement.setInt(1, Math.toIntExact(id));
            ResultSet set = statement.executeQuery();

            if (set.next()) {
                Employee employee = new Employee();
                employee.setEmployeeId(set.getLong(EMPLOYEE_ID));
                employee.setEmployeeSectorId(Long.valueOf(set.getString(EMPLOYEE_SECTOR_ID)));
                employee.setEmployeePosition(set.getString(EMPLOYEE_POSITION));
                return employee;
            } else {
                return null;
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("id Exception", e);
        }
    }

    @Override
    public boolean delete(Integer id) throws DaoException  {
        try (Connection connect = pool.getConnection();
             PreparedStatement statement = connect.prepareStatement(DELETE_BY_ID)) {
            statement.setLong(1, id);
            return true;
        } catch (SQLException | ConnectionPoolException e) {
            e.printStackTrace();
            throw new DaoException("Exception! ", e);
        }
    }

    @Override
    public int create(Employee entity) throws DaoException {
        try(Connection connect = pool.getConnection();
            PreparedStatement statement = connect.prepareStatement(CREATE_EMPLOYEE);
            PreparedStatement statementTwo = connect.prepareStatement(LAST_INSERT_ID)) {
            statement.setString(1, String.valueOf(entity.getEmployeeSectorId()));
            statement.setString(2,entity.getEmployeePosition());
            statement.executeUpdate();
            ResultSet set = statementTwo.executeQuery();
            set.next();
            return set.getInt(LAST_ID_ATTRIBUTE);
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
    }

    @Override
    public Employee save(Employee entity) {
        return null;
    }

    @Override
    public Long update(Employee entity) throws DaoException {
        try (Connection connect = pool.getConnection();
             PreparedStatement statement = connect.prepareStatement(UPDATE_EMPLOYEE)) {
            statement.setString(1, String.valueOf(entity.getEmployeeSectorId()));
            statement.setString(2,entity.getEmployeePosition());
            int rows = statement.executeUpdate();
            return 0L;
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
    }


    @Override
    public List<Employee> search(Employee entity) {
        return null;
    }


}

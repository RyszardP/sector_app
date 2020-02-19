package com.ryszard;

import com.ryszard.dao.EmployeeDao;
import com.ryszard.dao.connectionPool.ConnectionPool;
import com.ryszard.dao.connectionPool.ConnectionPoolException;
import com.ryszard.dao.factory.DaoFactory;

public class Main {
    public static void main(String[] args) throws ConnectionPoolException {
        ConnectionPool.getInstance().init();
        DaoFactory factory = DaoFactory.getDaoFactory();
        EmployeeDao employeeDao = factory.getEmployeeDao();

    }
}

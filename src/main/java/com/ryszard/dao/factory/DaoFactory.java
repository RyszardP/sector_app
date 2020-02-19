package com.ryszard.dao.factory;

import com.ryszard.dao.EmployeeDao;

public abstract class DaoFactory {
    public static DaoFactory getDaoFactory() {
        return SQLDaoFactory.getInstance();
    }

    public abstract EmployeeDao getEmployeeDao();
}

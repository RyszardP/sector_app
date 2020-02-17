package com.ryszard.dao.factory;

public class DaoFactory {
    public static DaoFactory getDaoFactory() {
        return SQLDaoFactory.getInstance();
    }
}

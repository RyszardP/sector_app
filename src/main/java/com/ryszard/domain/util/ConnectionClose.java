package com.ryszard.domain.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public interface ConnectionClose {

    void close(Connection myConnection, Statement myStatement, ResultSet myResultSet);
}

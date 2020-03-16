package com.ryszard.domain.util;

import com.ryszard.domain.vo.Fault;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FaultDbUtil implements ConnectionClose {

    private DataSource dataSource;

    public FaultDbUtil(DataSource theDataSource) {
        dataSource = theDataSource;
    }

    public List<Fault> getFaults() throws Exception {
        List<Fault> faults = new ArrayList<>();

        Connection myConnection = null;
        Statement myStatement = null;
        ResultSet myResultSet = null;

        try {

            myConnection = dataSource.getConnection();
            String sql = "select * from fault order by fault_type";
            myStatement = myConnection.createStatement();
            myResultSet = myStatement.executeQuery(sql);
            while (myResultSet.next()) {
                int faultId = myResultSet.getInt("fault_id");
                String faultType = myResultSet.getString("fault_type");
                Date faultDate = myResultSet.getDate("fault_date");
                Date faultFinish = myResultSet.getDate("fault_finish");
                int faultSectorId = myResultSet.getInt("fault_sector_id");
                int faultBrigadeId = myResultSet.getInt("fault_brigade_id");

                Fault tempFault = new Fault(faultId, faultType, faultDate, faultFinish, faultSectorId, faultBrigadeId);

                faults.add(tempFault);
            }
            return faults;
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

    public void addFault(Fault theFault) throws Exception {

        Connection myConnection = null;
        PreparedStatement myStatement = null;

        try {
            myConnection = dataSource.getConnection();

            String sql = "insert into fault "
                    + "(fault_type, fault_date, fault_finish,fault_sector_id,fault_brigade_id) "
                    + "values (?, ?, ?,?,?)";

            myStatement = myConnection.prepareStatement(sql);
            myStatement.setString(1, theFault.getFaultType());
            myStatement.setString(2, theFault.getFaultDate());
            myStatement.setString(3, theFault.getFaultFinish());
            myStatement.setInt(4, theFault.getFaultSectorId());
            myStatement.setInt(5, theFault.getFaultBrigadeId());
            myStatement.execute();
        } finally {
            close(myConnection, myStatement, null);
        }
    }

    public Fault getFault(String theFaultId) throws Exception {

        Fault theFault = null;

        Connection myConnection = null;
        PreparedStatement myPreparedStatement = null;
        ResultSet myResultSet = null;
        int faultId;

        try {
            faultId = Integer.parseInt(theFaultId);
            myConnection = dataSource.getConnection();
            String sql = "select * from fault where fault_id=?";
            myPreparedStatement = myConnection.prepareStatement(sql);
            myPreparedStatement.setInt(1, faultId);
            myResultSet = myPreparedStatement.executeQuery();
            if (myResultSet.next()) {
                String faultType = myResultSet.getString("fault_type");
                Date faultDate = myResultSet.getDate("fault_date");
                Date faultFinish = myResultSet.getDate("fault_finish");
                int faultSectorId = Integer.parseInt(myResultSet.getString("fault_sector_id"));
                int faultBrigadeId = Integer.parseInt(myResultSet.getString("fault_brigade_id"));
                theFault = new Fault(faultId, faultType, faultDate, faultFinish, faultSectorId, faultBrigadeId);
            } else {
                throw new Exception("Could not find student id: " + faultId);
            }

            return theFault;
        } finally {
            close(myConnection, myPreparedStatement, myResultSet);
        }
    }

    public void updateFault(Fault theFault) throws Exception {

        Connection myConnection = null;
        PreparedStatement myPreparedStatement = null;

        try {

            myConnection = dataSource.getConnection();

            String sql = "update fault "
                    + "set fault_type=?, fault_date=?, fault_finish=?,fault_sector_id=?, fault_brigade_id=? "
                    + "where fault_id=?";

            myPreparedStatement = myConnection.prepareStatement(sql);
            myPreparedStatement.setString(1, theFault.getFaultType());
            myPreparedStatement.setString(2, theFault.getFaultDate());
            myPreparedStatement.setString(3, theFault.getFaultFinish());
            myPreparedStatement.setInt(4, theFault.getFaultSectorId());
            myPreparedStatement.setInt(5, theFault.getFaultBrigadeId());
            myPreparedStatement.execute();
        } finally {
            close(myConnection, myPreparedStatement, null);
        }
    }

    public void deleteFault(String theFaultId) throws Exception {

        Connection myConnection = null;
        PreparedStatement myPreparedStatement = null;

        try {
            int faultId = Integer.parseInt(theFaultId);
            myConnection = dataSource.getConnection();
            String sql = "delete from fault where fault_id=?";
            myPreparedStatement = myConnection.prepareStatement(sql);
            myPreparedStatement.setInt(1, faultId);
            myPreparedStatement.execute();
        } finally {
            close(myConnection, myPreparedStatement, null);
        }
    }
}

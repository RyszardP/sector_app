package com.ryszard.domain.util;

import com.ryszard.domain.vo.Sector;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SectorDbUtil implements ConnectionClose {

    private DataSource dataSource;

    public SectorDbUtil(DataSource theDataSource) {
        dataSource = theDataSource;
    }

    public List<Sector> getStudents() throws Exception {

        List<Sector> sectors = new ArrayList<>();

        Connection myConnection = null;
        Statement myStatement = null;
        ResultSet myResultSet = null;
        try {
            myConnection = dataSource.getConnection();
            String sql = "select * from sector order by sector_name";
            myStatement = myConnection.createStatement();
            myResultSet = myStatement.executeQuery(sql);
            while (myResultSet.next()) {
                int sectorId = myResultSet.getInt("sector_id");
                String sectorName = myResultSet.getString("first_name");
                int sectorDepartmentId = myResultSet.getInt("sector_department_id");
                Sector tempSector = new Sector(sectorId, sectorName, sectorDepartmentId);
                sectors.add(tempSector);
            }
            return sectors;
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

    public void addSector(Sector theSector) throws Exception {

        Connection myConnection = null;
        PreparedStatement myPreparedStatement = null;

        try {
            myConnection = dataSource.getConnection();
            String sql = "insert into sector "
                    + "(sector_name, sector_department_id) "
                    + "values (?, ?)";

            myPreparedStatement = myConnection.prepareStatement(sql);
            myPreparedStatement.setString(1, theSector.getSectorName());
            myPreparedStatement.setInt(2, theSector.getSectorDepartmentId());
            myPreparedStatement.execute();
        } finally {
            close(myConnection, myPreparedStatement, null);
        }
    }

    public Sector getSector(String theSectorId) throws Exception {

        Sector theSector = null;
        Connection myConnection = null;
        PreparedStatement myPreparedStatement = null;
        ResultSet myResultSet = null;
        int sectorId;

        try {
            sectorId = Integer.parseInt(theSectorId);
            myConnection = dataSource.getConnection();
            String sql = "select * from sector where sector_id=?";
            myPreparedStatement = myConnection.prepareStatement(sql);
            myPreparedStatement.setInt(1, sectorId);
            myResultSet = myPreparedStatement.executeQuery();
            if (myResultSet.next()) {
                String sectorName = myResultSet.getString("sector_name");
                int sectorDepartmentId = myResultSet.getInt("sector_department_id");
                theSector = new Sector(sectorId, sectorName, sectorDepartmentId);
            } else {
                throw new Exception("Could not find student id: " + sectorId);
            }
            return theSector;
        } finally {
            close(myConnection, myPreparedStatement, myResultSet);
        }
    }

    public void updateSector(Sector theSector) throws Exception {

        Connection myConnection = null;
        PreparedStatement myPreparedStatement = null;

        try {
            myConnection = dataSource.getConnection();
            String sql = "update sector "
                    + "set sector_name=?, sector_department_id=? "
                    + "where sector_id=?";
            myPreparedStatement = myConnection.prepareStatement(sql);
            myPreparedStatement.setString(1, theSector.getSectorName());
            myPreparedStatement.setInt(2, theSector.getSectorDepartmentId());
            myPreparedStatement.execute();
        } finally {
            close(myConnection, myPreparedStatement, null);
        }
    }

    public void deleteSector(String theSectorId) throws Exception {

        Connection myConnection = null;
        PreparedStatement myPreparedStatement = null;

        try {
            int sectorId = Integer.parseInt(theSectorId);
            myConnection = dataSource.getConnection();
            String sql = "delete from sector where sector_id=?";
            myPreparedStatement = myConnection.prepareStatement(sql);
            myPreparedStatement.setInt(1, sectorId);
            myPreparedStatement.execute();
        } finally {

            close(myConnection, myPreparedStatement, null);
        }
    }
}

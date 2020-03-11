package com.ryszard.controller;

import com.ryszard.domain.util.SectorDbUtil;
import com.ryszard.domain.vo.Sector;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet("/SectorControllerServlet")
public class SectorControllerServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private SectorDbUtil sectorDbUtil;

    @Resource(name = "jdbc/factory_data")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            sectorDbUtil = new SectorDbUtil(dataSource);
        } catch (Exception exc) {
            throw new ServletException(exc);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String theCommand = request.getParameter("command");
            if (theCommand == null) {
                theCommand = "LIST";
            }
            switch (theCommand) {
                case "LIST":
                    listSectors(request, response);
                    break;
                case "ADD":
                    addSector(request, response);
                    break;
                case "LOAD":
                    loadSector(request, response);
                    break;
                case "UPDATE":
                    updateSector(request, response);
                    break;
                case "DELETE":
                    deleteSector(request, response);
                    break;
                default:
                    listSectors(request, response);
            }

        } catch (Exception exc) {
            throw new ServletException(exc);
        }

    }

    private void deleteSector(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        String theSectorId = request.getParameter("sectorId");
        sectorDbUtil.deleteSector(theSectorId);
        listSectors(request, response);
    }

    private void updateSector(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int sectorId = Integer.parseInt(request.getParameter("sectorId"));
        String sectorName = request.getParameter("sectorName");
        int sectorDepartmentId = Integer.parseInt(request.getParameter("sectorDepartmentId"));
        Sector theSector = new Sector(sectorId, sectorName, sectorDepartmentId);
        sectorDbUtil.updateSector(theSector);
        listSectors(request, response);

    }

    private void loadSector(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String theSectorId = request.getParameter("sectorId");
        Sector theSector = sectorDbUtil.getSector(theSectorId);
        request.setAttribute("THE_SECTOR", theSector);

        RequestDispatcher dispatcher =
                request.getRequestDispatcher("/update-sector-form.jsp");
        dispatcher.forward(request, response);
    }



    private void addSector(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String sectorName = request.getParameter("sectorName");
        int sectorDepartmentId = Integer.parseInt(request.getParameter("sectorDepartmentId"));
        Sector theSector = new Sector(sectorName,sectorDepartmentId);

        sectorDbUtil.addSector(theSector);
        listSectors(request, response);
    }

    private void listSectors(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        List<Sector> sectors = sectorDbUtil.getSectors();
        request.setAttribute("SECTOR_LIST", sectors);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list-sectors.jsp");
        dispatcher.forward(request, response);
    }

}

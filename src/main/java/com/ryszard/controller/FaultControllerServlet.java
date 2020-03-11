package com.ryszard.controller;

import com.ryszard.domain.util.FaultDbUtil;
import com.ryszard.domain.vo.Fault;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

@WebServlet("/FaultControllerServlet")
public class FaultControllerServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private FaultDbUtil faultDbUtil;

    @Resource(name = "jdbc/factory_data")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();

        try {
            faultDbUtil = new FaultDbUtil(dataSource);
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
                    listFaults(request, response);
                    break;

                case "ADD":
                    addFault(request, response);
                    break;

                case "LOAD":
                    loadFault(request, response);
                    break;

                case "UPDATE":
                    updateFault(request, response);
                    break;

                case "DELETE":
                    deleteFault(request, response);
                    break;

                default:
                    listFaults(request, response);
            }

        } catch (Exception exc) {
            throw new ServletException(exc);
        }

    }

    private void deleteFault(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        String theFaultId = request.getParameter("faultId");
        faultDbUtil.deleteFault(theFaultId);
        listFaults(request, response);
    }

    private void updateFault(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        int faultId = Integer.parseInt(request.getParameter("faultId"));
        String faultType = request.getParameter("faultType");
        Timestamp faultDate = Timestamp.valueOf(request.getParameter("faultDate"));
        Timestamp faultFinish = Timestamp.valueOf(request.getParameter("faultFinish"));
        int faultSectorId = Integer.parseInt(request.getParameter("faultSectorId"));
        int faultBrigadeId = Integer.parseInt(request.getParameter("faultBrigadeId"));
        Fault theFault = new Fault(faultId, faultType, faultDate, faultFinish, faultSectorId, faultBrigadeId);
        faultDbUtil.updateFault(theFault);
        listFaults(request, response);
    }

    private void loadFault(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        String theFaultId = request.getParameter("faultId");
        Fault theFault = faultDbUtil.getFault(theFaultId);
        request.setAttribute("THE_FAULT", theFault);
        RequestDispatcher dispatcher =
                request.getRequestDispatcher("/update-fault-form.jsp");
        dispatcher.forward(request, response);
    }

    private void addFault(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String faultType = request.getParameter("faultType");
        Timestamp faultDate = Timestamp.valueOf(request.getParameter("faultDate"));
        Timestamp faultFinish = Timestamp.valueOf(request.getParameter("faultFinish"));
        int faultSectorId = Integer.parseInt(request.getParameter("faultSectorId"));
        int faultBrigadeId = Integer.parseInt(request.getParameter("faultBrigadeId"));
        Fault theFault = new Fault(faultType, faultDate, faultFinish, faultSectorId,faultBrigadeId);
        faultDbUtil.addFault(theFault);
        listFaults(request, response);
    }

    private void listFaults(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        List<Fault> faults = faultDbUtil.getFaults();
        request.setAttribute("FAULT_LIST", faults);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list-faults.jsp");
        dispatcher.forward(request, response);
    }

}

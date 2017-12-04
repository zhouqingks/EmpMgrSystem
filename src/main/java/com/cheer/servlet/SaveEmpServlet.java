package com.cheer.servlet;


import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cheer.domain.Emp;
import com.cheer.service.EmpService;


@WebServlet("/servlet/saveEmp")
public class SaveEmpServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    private static final Logger LOGGER = LogManager.getLogger(SaveEmpServlet.class);

    private static final String Emp = null;

    public SaveEmpServlet()
    {}

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException,
        IOException
    {
        LOGGER.info("doGet method is invoked...");
        String empno = request.getParameter("empno");
        String ename = request.getParameter("ename");
        String job = request.getParameter("job");
        String mgr = request.getParameter("mgr");
        String sal = request.getParameter("sal");
        String comm = request.getParameter("comm");
        String deptno = request.getParameter("deptno");

        Emp emp = new Emp(Integer.valueOf(empno), ename, job, Integer.valueOf(mgr), new Date(0),
            Double.valueOf(sal), Double.valueOf(comm), Integer.valueOf(deptno));
        EmpService empService = (EmpService)this.getServletContext().getAttribute("empService");
        empService.save(emp);
        response.sendRedirect("../emp.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException,
        IOException
    {
        doGet(request, response);
    }

}

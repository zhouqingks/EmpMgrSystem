package com.cheer.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cheer.domain.Emp;
import com.cheer.service.EmpService;


public class DelEmpServlet extends HttpServlet
{

    /**
     * 意义，目的和功能，以及被用到的地方<br>
     */
    private static final long serialVersionUID = 1L;

    private static final Logger LOGGER = LogManager.getLogger(DelEmpServlet.class);

    public DelEmpServlet()
    {}

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException,
        IOException
    {
        LOGGER.info("doGet method is invoked...");
        String empno = request.getParameter("empno");

        EmpService empService = (EmpService)this.getServletContext().getAttribute("empService");

        Emp emp = new Emp();
        emp.setEmpno(Integer.valueOf(empno));

        empService.delete(emp);

        response.sendRedirect("../emp.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException,
        IOException
    {
        doGet(request, response);
    }

}

package com.cheer.servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@WebServlet(name = "validateServlet", urlPatterns = {"/servlet/validate"})
public class ValidateServlet extends HttpServlet
{

    private static final Logger LOGGER = LogManager.getLogger(ValidateServlet.class);

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException,
        IOException
    {
        LOGGER.info("doGet method is invoked...");
        
        response.setContentType("application/json;charset=utf-8");
        PrintWriter pw = response.getWriter();
        String username = request.getParameter("username");
        
        if ("admin123".equals(username))
        {
            pw.print("{\"result\":1}");
            pw.close();
        }
        else
        {
            pw.print("{\"result\":0}");
            pw.close();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException,
        IOException
    {

        this.doGet(request, response);
    }

}

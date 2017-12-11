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

import com.cheer.domain.User;
import com.cheer.service.EmpService;
import com.cheer.service.UserService;


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
        
        UserService userService = (UserService)this.getServletContext().getAttribute("userService");
        response.setContentType("application/json");
        PrintWriter pw = response.getWriter();
        String username = request.getParameter("username");
        
        User user = userService.find(username);
        
        if (user != null)
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

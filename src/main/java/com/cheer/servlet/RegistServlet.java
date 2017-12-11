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
import com.cheer.service.UserService;


@WebServlet(name = "regist", urlPatterns = {"/servlet/regist"})
public class RegistServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    
    private static final Logger LOGGER = LogManager.getLogger(RegistServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException,
        IOException
    {
        LOGGER.info("doGet method is invoked...");
        String username = request.getParameter("username");
        LOGGER.info("username = {}", username);
        String password = request.getParameter("password");
        LOGGER.info("password = {}", password);
        
        UserService userService = (UserService)this.getServletContext().getAttribute("userService");
        
        User user = new User(username, password);
        
        userService.save(user);
        
        response.sendRedirect("../login.jsp");
        
        
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException,
        IOException
    {
        this.doGet(request, response);
    }

}

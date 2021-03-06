package com.cheer.servlet;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Servlet implementation class Login
 */
@WebServlet("/servlet/login1")
public class Login extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    
    private static final Logger LOGGER = LogManager.getLogger(Login.class);

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login()
    {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException,
        IOException
    {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        LOGGER.info(username);
        LOGGER.info(password);
        HttpSession session = request.getSession();
        if ("admin".equals(username) && "admin".equals(password))
        {
            session.setAttribute("username", username);
            response.sendRedirect(request.getContextPath() + "/hello.jsp");
        }
        else
        {
            session.setAttribute("err", "账号密码不对");
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException,
        IOException
    {
        doGet(request, response);
    }

}

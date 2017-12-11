package com.cheer.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cheer.domain.User;
import com.cheer.service.UserService;


@WebServlet(name = "login", urlPatterns = {"/servlet/login"})
public class LoginServlet extends HttpServlet
{
    private static final Logger LOGGER = LogManager.getLogger(LoginServlet.class);

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException,
        IOException
    {
        String userName = null;
        String password = null;

        // 从客户端获取Cookie
        Cookie[] cookies = request.getCookies();

        for (Cookie cookie : cookies)
        {
            LOGGER.info("Cookie:{}={}", cookie.getName(), cookie.getValue());
            // 检查cookie里是否有username的cookie
            if ("username".equals(cookie.getName()))
            {
                userName = cookie.getValue();
                continue;
            }

            // 检查cookie里是否有password的cookie
            if ("password".equals(cookie.getName()))
            {
                password = cookie.getValue();
            }
        }
        
        LOGGER.info("username= {}, password={}", userName, password);

        // 从前台表单页面里获取name值为？的input的value值
        userName = request.getParameter("username") != null ? request.getParameter(
            "username") : userName;
        password = request.getParameter("password") != null ? request.getParameter(
            "password") : password;
        LOGGER.info(userName);
        LOGGER.info(password);
        HttpSession session = request.getSession();
        UserService userService = (UserService)this.getServletContext().getAttribute("userService");
        User user = userService.find(userName);
        
        // on/null
        String autoLogin = request.getParameter("autoLogin");
        LOGGER.info("autoLogin={}", autoLogin);
        if (user!=null && user.getPassword().equals(password))
        {
            session.setAttribute("isLogin", true);
            session.setAttribute("username", userName);
         // 如果选择了保存自动登录就设置cookie
            if ("on".equals(autoLogin))
            {
                LOGGER.info("服务端设置的Cookie...");
                Cookie usernameCookie = new Cookie("username", userName);
                Cookie passwordCookie = new Cookie("password", password);
                usernameCookie.setMaxAge(3600);
                passwordCookie.setMaxAge(3600);
                usernameCookie.setPath("/");
                passwordCookie.setPath("/");

                response.addCookie(usernameCookie);
                response.addCookie(passwordCookie);

            }
            response.sendRedirect(request.getContextPath() + "/emp.jsp");
        }
        else
        {
            session.setAttribute("err", "账号密码不对");
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException,
        IOException
    {

        this.doGet(request, response);
    }

}

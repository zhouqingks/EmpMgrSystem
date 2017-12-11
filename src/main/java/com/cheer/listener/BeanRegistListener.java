
package com.cheer.listener;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cheer.dao.EmpDao;
import com.cheer.dao.UserDao;
import com.cheer.dao.impl.EmpDaoImpl;
import com.cheer.dao.impl.UserDaoImpl;
import com.cheer.service.EmpService;
import com.cheer.service.UserService;
import com.cheer.service.impl.EmpServiceImpl;
import com.cheer.service.impl.UserServiceImpl;


@WebListener
public class BeanRegistListener implements ServletContextListener
{

    private static final Logger LOGGER = LogManager.getLogger(BeanRegistListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce)
    {
        LOGGER.info("ServletContext Listener......");
        ServletContext application = sce.getServletContext();

        EmpDao empDao = new EmpDaoImpl();

        EmpService empService = new EmpServiceImpl(empDao);

        application.setAttribute("empService", empService);
        
        UserDao userDao = new UserDaoImpl();
        
        UserService userService = new UserServiceImpl(userDao);
        
        application.setAttribute("userService", userService);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce)
    {

    }

}

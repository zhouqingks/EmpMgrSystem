package com.cheer.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


// 过滤器经典使用场景：登录状态检查
@WebFilter(filterName = "authorizeFilter", urlPatterns = {"/*"}, initParams = {
    // 排除登录页面/登录Servlet/注册页面/注册Servlet以及静态资源（js、css、图片等）
    @WebInitParam(name = "excludeUri", value = "login.jsp,/servlet/login,regist.jsp,/servlet/validate,/servlet/regist,.js,.css,.img,.png")})
public class AuthorizeFilter implements Filter
{

    private String[] excludeUris;

    /**
     * @see Filter#destroy()
     */
    public void destroy()
    {

    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException,
        ServletException
    {
        HttpServletResponse rsp = (HttpServletResponse)response;
        HttpServletRequest req = (HttpServletRequest)request;
        String uri = req.getRequestURI();

        if (this.checkUri(uri))
        {
            HttpSession session = req.getSession();
            Object obj = session.getAttribute("isLogin");

            // 看session里面是有登录状态isLogin=true
            if (obj == null || !(Boolean)obj)
            {
                String loginPath = req.getContextPath() + "/login.jsp";
                rsp.sendRedirect(loginPath);
            }
            else
            {
                chain.doFilter(request, response);
            }
        }
        else
        {
            chain.doFilter(request, response);
        }

    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig)
        throws ServletException
    {
        String excludeUri = fConfig.getInitParameter("excludeUri");
        this.excludeUris = excludeUri.split(",");
        for (int i = 0; i < this.excludeUris.length; i++)
        {
            // 去除前后空格
            this.excludeUris[i] = this.excludeUris[i].trim();
        }
    }

    private boolean checkUri(String uri)
    {

        for (String s : this.excludeUris)
        {
            if (uri.endsWith(s))
            {
                return false;
            }

        }

        return true;
    }

}

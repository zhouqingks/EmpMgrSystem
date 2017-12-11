package com.cheer.filter;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

// 过滤器经典使用场景：设置字符集
@WebFilter(filterName = "encodeFilter", urlPatterns = {"/*"}, initParams = {
    @WebInitParam(name = "encoding", value = "utf-8")})
public class EncodeFilter implements Filter
{

    private static final Logger LOGGER = LogManager.getLogger(EncodeFilter.class);

    private String encoding;

    /**
     * @see Filter#destroy()
     */
    public void destroy()
    {
        // TODO Auto-generated method stub
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException,
        ServletException
    {

        request.setCharacterEncoding(this.encoding);

        response.setCharacterEncoding(this.encoding);

        chain.doFilter(request, response);
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig)
        throws ServletException
    {
        String encoding = fConfig.getInitParameter("encoding");
        this.encoding = encoding;
    }

}

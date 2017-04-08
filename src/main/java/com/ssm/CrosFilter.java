package com.ssm;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class CrosFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
        //do something...
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        // do some logging... log4j

        //to login page and static resource

        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {
        //do something...
    }
}
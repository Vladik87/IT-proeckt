package com.filter;

import com.acedemmy.service.SecurityService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class AutFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        SecurityService securityService = new SecurityService();

        if(securityService.checkIfUserLogged(request)){
        filterChain.doFilter(servletRequest, servletResponse);
        }else {

        } request.getRequestDispatcher("/Enter.html");
    }
}

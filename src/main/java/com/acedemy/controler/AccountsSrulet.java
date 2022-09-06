package com.acedemy.controler;

import com.acedemmy.service.SecurityService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AccountsSrulet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SecurityService securityService = new SecurityService();
        resp.setCharacterEncoding("utf-8");
        if ( securityService.checkIfUserLogged(req) ) {

     req.getRequestDispatcher("/Accounts.jsp").forward(req, resp);
        }

    }
}

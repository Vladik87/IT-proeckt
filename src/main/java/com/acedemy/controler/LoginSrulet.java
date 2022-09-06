package com.acedemy.controler;

import com.acedemmy.service.SecurityService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginSrulet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("utf-8");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        PrintWriter writer = resp.getWriter();
        SecurityService securityService = new SecurityService();
        writer.println("<html>");
        writer.println("<body>");
        if ( securityService.checkIfUserLogged(req) && "vlad".equals(login) && "qwerty".equals(password) ) {
            writer.println("Hi" + login);
            HttpSession session = req.getSession();
            session.setAttribute("user", login);
        } else {
            writer.println("Access denied");
        }

        writer.println("</body>");
        writer.println("</html>");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();
        session.setAttribute("user", login);
        SecurityService securityService = new SecurityService();


        if (securityService.checkIfUserLogged(req) || "vlad".equals(login) && "qwerty".equals(password) ) {

            req.getRequestDispatcher("/Vlad.jsp").forward(req,resp);


        }

    }
}

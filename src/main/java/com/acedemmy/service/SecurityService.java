package com.acedemmy.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SecurityService {
   public boolean checkIfUserLogged(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String login = (String) session.getAttribute("user");
        return login != null;
    }
}

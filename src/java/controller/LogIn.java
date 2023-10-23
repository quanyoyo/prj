/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import model.Person;

/**
 *
 * @author aquan
 */
public class LogIn extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String pass = req.getParameter("pass");
        String r = req.getParameter("rem");
        
        //tao cookies
        Cookie cu = new Cookie("cemail", email);
        Cookie cr = new Cookie("crem", r);
        if (r != null) {
            //co tich
            cu.setMaxAge(60 * 60 * 24 * 365 * 10);//10 nam
            cr.setMaxAge(60 * 60 * 24 * 365 * 10);//10 nam
        } else {
            //khong tich
            cu.setMaxAge(0);
            cr.setMaxAge(0);
        }
        //save to browser
        resp.addCookie(cu);
        resp.addCookie(cr);

        Person person = new DAO().getPersonAccount(email, pass);

        HttpSession session = req.getSession();
        resp.getWriter().print(person);
        if (person == null) {
            req.setAttribute("msg", "Login Failed");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        } else {
            if (person.isIsActive() == true) {
                session.setAttribute("personSess", person);
                //session login
                session.setMaxInactiveInterval(60 * 60 * 24 * 365 * 10);
                resp.sendRedirect("home/list");
            } else {
                req.setAttribute("msg", "Your account is disabled");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }
        }
    }
}

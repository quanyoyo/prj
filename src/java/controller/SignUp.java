/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.Person;

/**
 *
 * @author aquan
 */
public class SignUp extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("signup.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String pass = req.getParameter("pass");
        String name = req.getParameter("name");
        String gender = req.getParameter("gender");
        String passR = req.getParameter("passR");
        //check pass != repeat password
        if (!pass.equals(passR)) {
            req.setAttribute("msg", "Those passwords didn’t match. Try again.");
            req.getRequestDispatcher("signup.jsp").forward(req, resp);
        } else {
            Person p = new DAO().checkPersonExist(email);
            if (p != null) {
                req.setAttribute("msg", "Account is existed");
                req.getRequestDispatcher("signup.jsp").forward(req, resp);
            } else {
                    new DAO().signUp(email,pass,name,gender);
                resp.sendRedirect("login");
            }
        }
    }
    
}

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
public class PersonUpdateInfo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Person p = new DAO().getPersonById(id);
        boolean gd= p.getGender().equalsIgnoreCase("Nam")?true:false;

        req.setAttribute("p", p);
        req.setAttribute("gd", gd);
        req.getRequestDispatcher("../personInfo.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String gender = req.getParameter("gender");
        String email = req.getParameter("email");
        String pass = req.getParameter("pass");

        new DAO().updatePersonInfo(name, gender, email, pass, id);
        resp.sendRedirect("list");
    }

}

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
import java.util.List;
import model.Person;

/**
 *
 * @author aquan
 */
public class PersonSearch extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String searchTxt = req.getParameter("personSearch");
        
        List<Person> listP = new DAO().getPersonByName(searchTxt);
        
        req.setAttribute("listP", listP);
        req.getRequestDispatcher("../person.jsp").forward(req, resp);
    }

}

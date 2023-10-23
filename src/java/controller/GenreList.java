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
import model.Genre;
import model.Person;

/**
 *
 * @author aquan
 */
public class GenreList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Person acc = (Person) req.getSession().getAttribute("personSess");
        if (acc.getType() == 1) {
            List<Genre> listG = new DAO().getAllGenre();

            req.setAttribute("listG", listG);
            req.getRequestDispatcher("../genre.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "../home/list");
        }
    }

}

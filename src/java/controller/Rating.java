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

/**
 *
 * @author aquan
 */
public class Rating extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int mid = Integer.parseInt(req.getParameter("mid"));

        new DAO().getMovieById(mid);
        req.setAttribute("mid", mid);
        req.getRequestDispatcher("rating.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("personSess") != null) {
            int pid = Integer.parseInt(req.getParameter("id"));
            int mid = Integer.parseInt(req.getParameter("mid"));
            String comment = req.getParameter("comment");
            Float rate = Float.parseFloat(req.getParameter("rate"));

            new DAO().addRating(pid, mid, comment, rate);
            resp.sendRedirect("detail?mid=" + mid);
        } else{
            resp.sendRedirect("login");
        }
    }
}

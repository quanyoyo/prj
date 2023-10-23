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
import model.Movie;

/**
 *
 * @author aquan
 */
public class HomeSearch extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String searchTxt = req.getParameter("searchTxt");
        List<Genre> listG = new DAO().getAllGenre();
        List<Movie> list = new DAO().getMovieByTit(searchTxt);
        
        req.setAttribute("listG", listG);
        req.setAttribute("listM", list);
        req.getRequestDispatcher("../home.jsp").forward(req, resp);
    }

}

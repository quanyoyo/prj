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
import model.Rate;

/**
 *
 * @author aquan
 */
public class HomeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Genre> listG = new DAO().getAllGenre();
        List<Movie> listM = new DAO().getAllMovie();
        List<Rate> listR = new DAO().getAllRate();
        
        req.setAttribute("listG", listG);
        req.setAttribute("listM", listM);
        req.setAttribute("listR", listR);
        req.getRequestDispatcher("../home.jsp").forward(req, resp);
    }

}

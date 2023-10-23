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
import model.Person;
import model.Rate;

/**
 *
 * @author aquan
 */
public class Detail extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int mid = Integer.parseInt(req.getParameter("mid"));
        Movie movie = new DAO().getMovieById(mid);
        List<Genre> listG = new DAO().getAllGenre();
        List<Rate> listR = new DAO().getAllRate();
        List<Person> listP = new DAO().getAllPerson();
        Rate rate = new DAO().getRateByMovieId(mid);

//        float count = 0, totalRate = 0;
//        for (Rate rate1 : listR) {
//            if (rate1.getMovieID() == rate.getMovieID()) {
//                if (rate.getNumericRating() > -1) {
//                    count++;
//                }
//            }
//        }
//        for (int i = 0; i < count; i++) {
//            totalRate += rate.getNumericRating();
//        }
//        float avgRate = totalRate / count;
//        listR.add(new Rate(avgRate));

//        Person p = new DAO().getPersonById(rate.getPersonID());
    
        req.setAttribute("listG", listG);
        req.setAttribute("listR", listR);
        req.setAttribute("m", movie);
        req.setAttribute("listP", listP);
        req.setAttribute("rate", rate);
        req.getRequestDispatcher("detail.jsp").forward(req, resp);
    }

}

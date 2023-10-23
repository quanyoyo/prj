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
public class AdminController extends HttpServlet {

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Person acc = (Person) req.getSession().getAttribute("personSess");
        if (acc.getType() == 1) {
            List<Genre> listg = new DAO().getAllGenre();
            List<Movie> listm = new DAO().getAllMovie();
            List<Person> listp = new DAO().getAllPerson();
            List<Rate> listr = new DAO().getAllRate();
            int countg = 0, countm = 0, countp = 0, countr = 0;
            for (Genre genre : listg) {
                if (genre.getGenreID() != -1) {
                    countg++;
                }
            }
            for (Movie movie : listm) {
                if (movie.getMovieID() != -1) {
                    countm++;
                }
            }
            for (Person person : listp) {
                if (person.getPersonID() != -1) {
                    countp++;
                }
            }
            for (Rate rate : listr) {
                if (rate.getComment() != null) {
                    countr++;
                }
            }
            req.setAttribute("countg", countg);
            req.setAttribute("countm", countm);
            req.setAttribute("countp", countp);
            req.setAttribute("countr", countr);
            req.getRequestDispatcher("admin.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/home/list");
        }
    }

}

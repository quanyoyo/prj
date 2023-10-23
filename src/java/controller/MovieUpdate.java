/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import model.Genre;
import model.Movie;
import model.Rate;

@MultipartConfig
public class MovieUpdate extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Movie movie = new DAO().getMovieById(id);
        List<Genre> listG = new DAO().getAllGenre();
        Rate r = new DAO().getRateByMovieId(id);
        req.setAttribute("r", r);
        req.setAttribute("movie", movie);
        req.setAttribute("listG", listG);
        req.getRequestDispatcher("../updateMovie.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title=req.getParameter("title");
        int year = Integer.parseInt(req.getParameter("year"));
        
        Part file = req.getPart("image");
        String image = file.getSubmittedFileName();
        String uploadPath = "C:/Users/UX3402ZA/Documents/NetBeansProjects/PROJECT-Q/web/image/" + image;
        try {
            FileOutputStream fos = new FileOutputStream(uploadPath);
            InputStream is = file.getInputStream();

            byte[] data = new byte[is.available()];
            is.read(data);
            fos.write(data);
            fos.close();
        } catch (IOException e) {
        }
        
        String des = req.getParameter("des");
        int genreID = Integer.parseInt(req.getParameter("genreID"));
        int id = Integer.parseInt(req.getParameter("id"));
//        float rate = Float.parseFloat(req.getParameter("rate"));
        String link = req.getParameter("link");
        
        new DAO().updateMovie(title, year, image, des, genreID, id, link);
//        new DAO().updateRatePoint(rate,id);
        resp.sendRedirect("list");
    }
}



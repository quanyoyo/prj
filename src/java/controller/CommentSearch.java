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
import model.Rate;

/**
 *
 * @author aquan
 */
public class CommentSearch extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String searchTxt = req.getParameter("search");
        List<Rate> list = new DAO().searchComment(searchTxt);
        req.setAttribute("listR", list);
        req.getRequestDispatcher("../comment.jsp").forward(req, resp);
    }
    
}

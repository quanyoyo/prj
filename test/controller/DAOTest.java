/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import model.*;

/**
 *
 * @author UX3402ZA
 */
public class DAOTest extends DBContext{
    
    public DAOTest() {
    }

    DAO dao = new DAO();
    @Test
    public void testGetAllMovie() {
        List<Movie> listm = dao.getAllMovie();
    }

    @Test
    public void testGetAllGenre() {
    }

    @Test
    public void testGetAllPerson() {
    }

    @Test
    public void testGetAllRate() {
    }

    @Test
    public void testChangeStatusPerson() {
    }

    @Test
    public void testGetPersonByName() {
    }

    @Test
    public void testGetGenreById() {
    }

    @Test
    public void testUpdateGenre() {
    }

    @Test
    public void testDeleteGenre() {
    }

    @Test
    public void testDeleteMovie() {
    }

    @Test
    public void testAddGenre() {
    }

    @Test
    public void testAddMovie() {
    }

    @Test
    public void testGetMovieById() {
    }

    @Test
    public void testUpdateMovie() {
    }

    @Test
    public void testGetPersonAccount() {
    }

    @Test
    public void testDeleteComment() {
    }

    @Test
    public void testGetMovieByTit() {
    }

    @Test
    public void testGetRateByComment() {
    }

    @Test
    public void testGetGenreByDes() {
    }

    @Test
    public void testGetMovieByGenreId() {
    }

    @Test
    public void testGetPersonById() {
    }

    @Test
    public void testCheckPersonExist() {
    }

    @Test
    public void testSignUp() {
    }

    @Test
    public void testGetRateByMovieId() {
    }

    @Test
    public void testUpdateRatePoint() {
    }

    @Test
    public void testUpdatePersonInfo() {
    }

    @Test
    public void testSearchComment() {
    }

    @Test
    public void testAddRating() {
    }
    
}

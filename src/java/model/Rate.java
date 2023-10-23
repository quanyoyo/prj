/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.DAO;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author aquan
 */
public class Rate {

    private int MovieID;
    private int PersonID;
    private String Comment;
    private float NumericRating;
    private Timestamp Time;
//    private float avgRating;

//    public float getAvgRating() {
//        return avgRating;
//    }
//
//    public void setAvgRating(float avgRating) {
//        this.avgRating = avgRating;
//    }
//
//    public Rate(float avgRating) {
//        this.avgRating = avgRating;
//    }
//    
    public Rate() {
    }

    public Rate(int MovieID, int PersonID, String Comment, float NumericRating, Timestamp Time) {
        this.MovieID = MovieID;
        this.PersonID = PersonID;
        this.Comment = Comment;
        this.NumericRating = NumericRating;
        this.Time = Time;
    }

    public int getMovieID() {
        return MovieID;
    }

    public void setMovieID(int MovieID) {
        this.MovieID = MovieID;
    }

    public int getPersonID() {
        return PersonID;
    }

    public void setPersonID(int PersonID) {
        this.PersonID = PersonID;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String Comment) {
        this.Comment = Comment;
    }

    public float getNumericRating() {
        return NumericRating;
    }

    public void setNumericRating(float NumericRating) {
        this.NumericRating = NumericRating;
    }

    public Timestamp getTime() {
        return Time;
    }

    public void setTime(Timestamp Time) {
        this.Time = Time;
    }

}

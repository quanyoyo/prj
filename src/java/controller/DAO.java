/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import model.Genre;
import model.Movie;
import model.Person;
import model.Rate;

/**
 *
 * @author aquan
 */
public class DAO extends DBContext {

    public List<Movie> getAllMovie() {
        List<Movie> listM = new ArrayList<>();
        try {
            String sql = "select * from Movies";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                listM.add(new Movie(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7)));
            }
        } catch (SQLException e) {
        }
        return listM;
    }

    public List<Genre> getAllGenre() {
        List<Genre> listG = new ArrayList<>();
//        doc data tu database
        try {
            String sql = "select * from Genres";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                listG.add(new Genre(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return listG;
    }

    public List<Person> getAllPerson() {
        List<Person> listP = new ArrayList<>();
        try {
            String sql = "select * from Persons";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                listP.add(new Person(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getBoolean(7)));
            }
        } catch (SQLException e) {
        }
        return listP;
    }

    public List<Rate> getAllRate() {
        List<Rate> listR = new ArrayList();
        try {
            String sql = "select * from Rates";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                listR.add(new Rate(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getFloat(4), rs.getTimestamp(5)));
            }
        } catch (SQLException e) {
        }
        return listR;
    }

    public void changeStatusPerson(boolean isactive, int id) {
        try {
            String sql = "UPDATE Persons\n"
                    + "   SET IsActive = ?\n"
                    + " WHERE PersonID=?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setBoolean(1, isactive);
            st.setInt(2, id);
            st.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public List<Person> getPersonByName(String searchTxt) {
        List<Person> listP = new ArrayList<>();
        try {
            String sql = "select * from Persons where Fullname like ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + searchTxt + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                listP.add(new Person(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getBoolean(7)));
            }
        } catch (SQLException e) {
        }
        return listP;
    }

    public Genre getGenreById(int id) {
        try {
            String sql = "select * from Genres where GenreID = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new Genre(rs.getInt(1), rs.getString(2));
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public void updateGenre(int id, String des) {
        try {
            String sql = "UPDATE Genres\n"
                    + "   SET [Description] = ?\n"
                    + " WHERE GenreID=?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, des);
            st.setInt(2, id);
            st.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void deleteGenre(int id) {
        try {
            String sql = "DELETE FROM Genres\n"
                    + "      WHERE GenreID=?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void deleteMovie(int id) {
        try {
            String sql = "DELETE FROM Movies\n"
                    + "      WHERE MovieID=?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
        }
    }

    void addGenre(String des) {
        try {
            String sql = "INSERT INTO Genres\n"
                    + "           ([Description])\n"
                    + "     VALUES(?)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, des);
            st.executeUpdate();
        } catch (SQLException e) {
        }
    }

    void addMovie(String title, int year, String image, String des, int genreID, String link) {
        try {
            String sql = "INSERT INTO [dbo].[Movies]\n"
                    + "           ([Title]\n"
                    + "           ,[Year]\n"
                    + "           ,[Image]\n"
                    + "           ,[Description]\n"
                    + "           ,[GenreID]\n"
                    + "           ,[Link])\n"
                    + "     VALUES\n"
                    + "           (?,?,?,?,?,?)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, title);
            st.setInt(2, year);
            st.setString(3, image);
            st.setString(4, des);
            st.setInt(5, genreID);
            st.setString(6, link);
            st.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public Movie getMovieById(int id) {
        try {
            String sql = "select * from Movies where MovieID=?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new Movie(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7));
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public void updateMovie(String title, int year, String image, String des, int genreID, int id, String link) {
        try {
            String sql = "UPDATE [dbo].[Movies]\n"
                    + "   SET [Title] = ?\n"
                    + "      ,[Year] = ?\n"
                    + "      ,[Image] = ?\n"
                    + "      ,[Description] = ?\n"
                    + "      ,[GenreID] = ?\n"
                    + "      ,[Link] = ?\n"
                    + " WHERE MovieID=?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, title);
            st.setInt(2, year);
            st.setString(3, image);
            st.setString(4, des);
            st.setInt(5, genreID);
            st.setInt(6, id);
            st.setString(7, link);
            st.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public Person getPersonAccount(String email, String pass) {
        try {
            String sql = "select * from Persons where Email=? and Password=?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, email);
            st.setString(2, pass);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new Person(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getInt(6), rs.getBoolean(7));
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public void deleteComment(int id, int mid) {
        try {
            String sql = "DELETE FROM [dbo].[Rates]\n"
                    + "      WHERE PersonID=? and MovieID=?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.setInt(2, mid);
            st.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public List<Movie> getMovieByTit(String searchTxt) {
        List<Movie> list = new ArrayList<>();
        try {
            String sql = "select * from Movies where Title like ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + searchTxt + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Movie(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7)));
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public List<Rate> getRateByComment(String searchTxt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<Genre> getGenreByDes(String searchTxt) {
        List<Genre> list = new ArrayList<>();
        try {
            String sql = "select * from Genres where Description like ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + searchTxt + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Genre(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public List<Movie> getMovieByGenreId(int id) {
        List<Movie> list = new ArrayList<>();
        try {
            String sql = "select * from Movies where  GenreID = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Movie(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7)));
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public Person getPersonById(int id) {
        try {
            String sql = "select * from Persons where PersonID = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new Person(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getInt(6), rs.getBoolean(7));
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public Person checkPersonExist(String email) {
        String sql = "select * from Persons \n"
                + "where [Email] =?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, email);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new Person(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getInt(6), rs.getBoolean(7));
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public void signUp(String email, String pass, String name, String gender) {
        String sql = "INSERT INTO [dbo].[Persons]\n"
                + "           ([Email]\n"
                + "           ,[Password]\n"
                + "           ,[Fullname]\n"
                + "           ,[Gender]\n"
                + "           ,[Type]\n"
                + "           ,[IsActive])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,2,1)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, email);
            st.setString(2, pass);
            st.setString(3, name);
            st.setString(4, gender);
            st.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public Rate getRateByMovieId(int id) {
        try {
            String sql = "select * from Rates where MovieID = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new Rate(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getFloat(4), rs.getTimestamp(5));
            }
        } catch (SQLException e) {
        }
        return null;
    }

    void updateRatePoint(float rate, int id) {
        try {
            String sql = "UPDATE [dbo].[Rates]\n"
                    + "   SET [NumericRating] = ?\n"
                    + " WHERE MovieID=?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setFloat(1, rate);
            st.setInt(2, id);
            st.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void updatePersonInfo(String name, String gender, String email, String pass, int id) {
        try {
            String sql = "UPDATE [dbo].[Persons]\n"
                    + "   SET [Fullname] = ?\n"
                    + "      ,[Gender] = ?\n"
                    + "      ,[Email] = ?\n"
                    + "      ,[Password] = ?\n"
                    + " WHERE PersonID=?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, gender);
            st.setString(3, email);
            st.setString(4, pass);
            st.setInt(5, id);
            st.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public List<Rate> searchComment(String searchTxt) {
        List<Rate> list = new ArrayList<>();
        try {
            String sql = "select * from Rates where Comment like ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + searchTxt + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Rate(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getFloat(4), rs.getTimestamp(5)));
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public void addRating(int pid, int mid, String comment, Float rate) {
        try {
            String sql = "INSERT INTO [dbo].[Rates]\n"
                    + "           ([MovieID]\n"
                    + "           ,[PersonID]\n"
                    + "           ,[Comment]\n"
                    + "           ,[NumericRating]\n"
                    + "           ,[Time])\n"
                    + "     VALUES\n"
                    + "           (?,?,?,?,CURRENT_TIMESTAMP)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, mid);
            st.setInt(2, pid);
            st.setString(3, comment);
            st.setFloat(4, rate);
            st.executeUpdate();
        } catch (SQLException e) {
        }
    }
}   

<%-- 
    Document   : updateMovie
    Created on : 24-Aug-2022, 01:24:53
    Author     : aquan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="<%=request.getContextPath()%>/css/label.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Update movie</h1>
        <form action="update" method="post" enctype="multipart/form-data">
            <label>MovieID</label>
            <input type="number" name="id" value="${movie.getMovieID()}" readonly/><br/>
            <label>Title</label>
            <input type="text" name="title" value="${movie.getTitle()}"/><br/>
            <label>Year</label>
            <input type="number" name="year" value="${movie.getYear()}"/><br/>
            <label>Image</label>
            <input type="file" name="image" value="${movie.getImage()}"/>
            <br/>
            <label>Description</label>
            <input type="text" name="des" value="${movie.getDescription()}"/><br/>
            <label>Genre</label>
            <select name="genreID">
                <c:forEach items="${listG}" var="g">
                    <option value="${g.getGenreID()}" ${movie.getGenreID()==g.getGenreID()?"selected":""}>${g.getDescription()}</option>
                </c:forEach>
            </select>
            <br/>
            <%--
            <c:if test="${r.getNumericRating()!=null}">
                <label>Rate</label>
                <input type="text" name="rate" value="${r.getNumericRating()}" readonly/><br/>
                <br/>
            </c:if>
            --%>
            <label>Link</label>
            <input type="text" name="link" value="${movie.getLink()}" required/><br/>
            <br/>
            <input type="submit" value="Update"/>
        </form>
    </body>
</html>

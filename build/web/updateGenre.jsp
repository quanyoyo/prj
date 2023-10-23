<%-- 
    Document   : updateGenre
    Created on : 23-Aug-2022, 23:13:01
    Author     : aquan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="<%=request.getContextPath()%>/css/label.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Update genre</h1>
        <br/><br/>
        <form action="update" method="post">
            <div>
                <label>GenreID: </label>
                <input type="number" name="id" value="${genre.getGenreID()}" readonly/><br/>
                <label>Description: </label>
                <input type="text" name="des" value="${genre.getDescription()}"/><br/>
                <input type="submit" value="Save"/>
            </div>
        </form>
    </body>
</html>

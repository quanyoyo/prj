<%-- 
    Document   : createGenre
    Created on : 23-Aug-2022, 23:49:00
    Author     : aquan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add Genre</h1>
        <form action="create" method="post">
            <div class="genre">
                <label>Description: </label>
                <input type="text" name="des"/><br/>
                <input type="submit" value="Save"/>
            </div>
        </form>
    </body>
</html>

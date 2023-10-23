<%-- 
    Document   : admin
    Created on : 24-Aug-2022, 21:43:05
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
        <%@include file="header.jsp"%>
        <div class="content">
            <%@include file="left.jsp"%>
            <div class="content-right">
                <form action="admin">
                    <h1>Dashboard</h1>
                    <br/><br/><br/>
                    <div class="admin-right">
                        <div class="item">
                            Movie
                            <input type="number" name="movies" value="${countm}" readonly/><br/>
                        </div>
                        <div class="item">
                            Genres
                            <input type="number" name="genres" value="${countg}" readonly/><br/>
                        </div>
                        <div class="item">
                            Person
                            <input type="number" name="persons" value="${countp}" readonly/><br/>
                        </div>
                        <div class="item">
                            Comment
                            <input type="number" name="comments" value="${countr}" readonly/>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <%@include file="footer.jsp"%>
    </body>
</html>

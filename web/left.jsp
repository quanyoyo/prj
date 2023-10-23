<%-- 
    Document   : left
    Created on : 25-Aug-2022, 07:12:54
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
        <div class="content">
            <div class="content-left">
                <ul>
                    <li><a href="<%=request.getContextPath()%>/genre/list">Genre</a></li>
                    <li><a href="<%=request.getContextPath()%>/movie/list">Movie</a></li>
                    <li><a href="<%=request.getContextPath()%>/person/list">Person</a></li>
                    <li><a href="<%=request.getContextPath()%>/comment/list">Comment</a></li>
                    <!--<li><a href="rating">Rating</a></li>-->
                </ul>
            </div>
        </div>
    </body>
</html>

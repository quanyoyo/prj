<%-- 
    Document   : home
    Created on : 23-Aug-2022, 11:19:36
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
            <div  class="content-left">
                <h2>Category</h2>
                <c:forEach items="${listG}" var="g">
                    <ul>
                        <li><a href="genre?id=${g.getGenreID()}">${g.getDescription()}</a></li>
                    </ul>
                </c:forEach>
            </div>
            <div class="content-right">
                <div class="home-right">
                    <c:forEach items="${listM}" var="m">
                        <div class="item">
                            <a href="../detail?mid=${m.getMovieID()}"><img src="../image/${m.getImage()}" alt="Movie"/></a><br/>
                            <a href="../detail?mid=${m.getMovieID()}"><b>${m.getTitle()}</b></a><br/>
                            <p>Year: ${m.getYear()}</p>
                            <c:forEach items="${listR}" var="r">
                                <c:if test="${m.getMovieID()==r.getMovieID()}">         
                                    <p>Point: ${r.getNumericRating()}</p>
                                </c:if>
                            </c:forEach>
                            <button><a href="../detail?mid=${m.getMovieID()}">Rating</a></button>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
        <%@include file="footer.jsp"%>
    </body>
</html>

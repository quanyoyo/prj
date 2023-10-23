<%-- 
    Document   : movie
    Created on : 24-Aug-2022, 21:57:32
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
                <h1>List Movies</h1>
                <br/>
                <form action="search">
                    Name: <input type="text" name="search" placeholder="Movie name"/>
                    <input type="submit" value="Search"/><br/>
                </form>
                <br/>
                <br/>
                <form action="movie">
                    <h3><a href="create">Create</a></h3>
                    <br/>
                    <table border="1">
                        <%--<c:if test="${listM!=null}">--%>
                        <tr>
                            <th>Id</th>
                            <th>Name</th>
                            <th>Genre</th>
                            <th>Rating</th>
                            <th>Image</th>
                            <th>Link</th>
                            <th colspan="2"></th>
                        </tr>
                        <%--</c:if>--%>
                        <c:forEach items="${listM}" var="m">
                            <tr>
                                <td>${m.getMovieID()}</td>
                                <td>${m.getTitle()}</td>
                                <c:forEach items="${listG}" var="g">
                                    <c:if test="${m.getGenreID()==g.getGenreID()}">
                                        <td>${g.getDescription()}</td>
                                    </c:if>
                                </c:forEach>
                                <%-- 
                                <c:forEach items="${listR}" var="r">
                                    <c:if test="${m.getMovieID()==r.getMovieID()}">
                                        <c:if test="${r.getNumericRating()!=null}">
                                            <td>${r.getNumericRating()}</td>
                                        </c:if>
                                    </c:if>
                                </c:forEach>
                                --%>
                                <td>${m.getImage()}</td>
                                <td>${m.getLink()}</td>
                                <td><a href="update?id=${m.getMovieID()}">Update</a></td>
                                <td><a href="delete?id=${m.getMovieID()}" onclick="return doDelete('${m.getMovieID()}')">Delete</a></td>
                            </tr>
                        </c:forEach>
                    </table>
                </form>
            </div>
        </div>
        <%@include file="footer.jsp"%>
    </body>
    <script type="text/javascript">
        function doDelete(id) {
            if (confirm("Do you want to delete this movie")) {
                return true;
            }
            return false;
        }
    </script>
</html>

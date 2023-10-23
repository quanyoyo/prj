<%-- 
    Document   : genre
    Created on : 24-Aug-2022, 21:55:43
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
                <h1>List genre</h1>
                <br/>
                <form action="search">
                    Name: <input type="text" name="search"/>
                    <input type="submit" value="Search"/><br/>
                </form>
                <br/>
                <form action="genre">
                    <h3><a href="create">Create</a></h3>
                    <table border="1">
                        <tr>
                            <th>Id</th>
                            <th>Description</th>
                            <th colspan="2"></th>
                        </tr>
                        <c:forEach items="${listG}" var="g">
                            <tr>
                                <td>${g.getGenreID()}</td>
                                <td>${g.getDescription()}</td>
                                <td><a href="update?id=${g.getGenreID()}">Update</a></td>
                                <td><a href="delete?id=${g.getGenreID()}" onclick="return doDelete('${g.getGenreID()}')">Delete</a></td>
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
            if (confirm("Do you want to delete this genre")) {
                return true;
            }
            return false;
        }
    </script>
</html>

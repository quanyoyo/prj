
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
                <h1>List comment</h1>
                <br/>
                <form action="search">
                    Comment: <input type="text" name="search" placeholder="Comment..."/>
                    <input type="submit" value="Search"/><br/>
                </form>
                <br/>
                <form action="comment">
                    <div>
                        <table border="1">
                            <tr>
                                <th>MovieId</th>
                                <th>PersonId</th>
                                <th>Comment</th>
                                <th></th>
                            </tr>
                            <c:forEach items="${listR}" var="r">
                                <tr>
                                    <td>${r.getMovieID()}</td>
                                    <td>${r.getPersonID()}</td>
                                    <td>${r.getComment()}</td>
                                    <td><a href="delete?mid=${r.getMovieID()}" onclick="return doDelete('${r.getMovieID()}')">Delete</a></td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </form>
            </div>
        </div>
        <%@include file="footer.jsp"%>
    </body>
    <script type="text/javascript">
        function doDelete(id) {
            if (confirm("Do you want to delete this comment")) {
                return true;
            }
            return false;
        }
    </script>
</html>

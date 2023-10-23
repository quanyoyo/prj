<%@include file="header1.jsp"%>
<div class="content">
    <form action="movie">
        <h1>List Movies</h1>
        <h3><a href="create">Create</a></h3>
        <div class="search">
            Name: <input type="text" name="movieSearch"/>
            <input type="submit" value="Search"/><br/>
        </div>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Genre</th>
                <th>Rating</th>
                <th>Image</th>
                <th colspan="2"></th>
            </tr>
            <c:forEach items="${listM}" var="m">
                <tr>
                    <td>${m.getMovieID()}</td>
                    <td>${m.getTitle()}</td>
                    <c:forEach items="${listG}" var="g">
                        <c:if test="${m.getGenreID()==g.getGenreID()}">
                            <td>${g.getDescription()}</td>
                        </c:if>
                    </c:forEach>
                    <c:forEach items="${listR}" var="r">
                        <c:if test="${m.getMovieID()==r.getMovieID()}">
                            <td>${r.getNumericRating()}</td>
                        </c:if>
                        <c:if test="${m.getMovieID()!=r.getMovieID()}">
                            <td></td>
                        </c:if>
                    </c:forEach>
                    <td>${m.getImage()}</td>
                    <td><a href="update?id=${m.getMovieID()}">Update</a></td>
                    <td><a href="delete?id=${m.getMovieID()}" onclick="return doDelete('${m.getMovieID()}')">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
        <br/>
        <a href="../admin">Back to Admin page</a>
    </form>
</div>
<%@include file="footer.jsp"%>
<script type="text/javascript">
    function doDelete(id) {
        if (confirm("Do you want to delete this movie")) {
            return true;
        }
        return false;
    }
</script>

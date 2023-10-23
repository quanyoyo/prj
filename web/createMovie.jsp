<%-- 
    Document   : createMovie
    Created on : 24-Aug-2022, 00:53:53
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
        <h1>Add movie</h1>
        <br/><br/>
        <form action="create" method="post" enctype="multipart/form-data" onsubmit="return CheckYear()"; name="frm">
            <label>Title</label>
            <input type="text" name="title" required/><br/>
            <label>Year</label>
            <input type="number" name="year" required/><br/>
            <label>Image</label>
            <input type="file" name="image" required/><br/>
            <label>Description</label>
            <input type="text" name="des" required/><br/>
            <label>Link</label>
            <input type="text" name="link" /><br/>
            <label>Genre</label>
            <select name="genreID" required>
                <c:forEach items="${listG}" var="g">
                    <option value="${g.getGenreID()}">${g.getDescription()}</option>
                </c:forEach>
            </select>
            <br/>
            <input type="submit" value="Add"/>
        </form>
    </body>
    <script type="text/javascript">
        function CheckYear() {
            var year = document.forms["frm"]["year"].value;
            var year_int = parseInt(year)
            var msg = "";
            var flag = true;

            if (year_int <0 || year_int > 2022) {
                msg += "Year can not in the past or in the future.\n";
                flag = false;
            }
            if (flag === false) {
                alert(msg);
                return false;
            }
            return true;
        }
    </script>
</html>

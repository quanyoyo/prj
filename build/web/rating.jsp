<%-- 
    Document   : rating
    Created on : 23-Aug-2022, 14:39:29
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
        <%@include file="header.jsp"%>
        <div class="content">
            <div class="content-right">
                <form action="rating" method="post" onsubmit="return CheckInput();" name="frm">
                    <h1>Rating</h1>
                    <label>MovieID: </label>
                    <input type="number" name="mid" value="${mid}" readonly/><br/>
                    <label>PersonID: </label>
                    <input type="number" name="id" value="<%=acc.getPersonID()%>" readonly/><br/>
                    <label>Comment: </label>
                    <input type="text" name="comment"/><br/>
                    <label>Rate: </label>
                    <input type="text" name="rate"/><br/>
                    <input type="submit" value="Save"/>
                </form>
            </div>
        </div>
    <%@include file="footer.jsp"%>
    </body>
    <script type="text/javascript">
        function CheckInput() {
            var email = document.forms["frm"]["comment"].value;
            var rate = document.forms["frm"]["rate"].value;
            let rate_int = parseInt(rate)
            var msg = "";
            var flag = true;

            if (email === "") {
                msg += "Comment not empty.\n";
                flag = false;
            }
            if (rate === ""|| rate_int<0 || rate_int>10) {
                msg += "Rating not empty.\n";
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

<%-- 
    Document   : login1
    Created on : 25-Aug-2022, 09:22:05
    Author     : aquan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="login-form">
            <form action="login" method="post" onsubmit="return CheckInput();" name="frm">
                <h2 class="text-center">Log in</h2> 
                <div class="alert-danger text-center" role="alert">
                    ${msg}
                </div>
                <br/>
                <c:set var="cookie" value="${pageContext.request.cookies}"/>
                <div class="form-group">
                    <input type="text" name="email" class="form-control" placeholder="Email" 
                           value="${cookie.cemail.value}">
                </div>
                <div class="form-group">
                    <input type="password" name="pass" class="form-control" placeholder="Password" >
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary btn-block">Log in</button>
                </div>
                <div class="clearfix">
                    <input type="checkbox"
                           ${cookie.crem.value!=null?"checked":""} name="rem" value="ON"/> Remember me
                </div>   
            </form>
            <p class="text-center"><a href="signup">Create an Account</a></p>
            <p class="text-center"><a href="home/list">Back to home</a></p>
        </div>
    </body>
    <script type="text/javascript">
        function CheckInput() {
            var email = document.forms["frm"]["email"].value;
            var pass = document.forms["frm"]["pass"].value;
            var msg = "";
            var flag = true;

            if (email === "") {
                msg += "Email not empty.\n";
                flag = false;
            }
            if (pass === "") {
                msg += "Password not empty.\n";
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

<%-- 
    Document   : signup
    Created on : 25-Aug-2022, 09:25:19
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
            <form action="signup" method="post" onsubmit="return CheckInput();" name="frm">
                <h2 class="text-center">Sign up</h2>   
                <div class="alert-danger text-center" role="alert">
                    ${msg}
                </div>
                <br/>
                <div class="form-group">
                    <input type="text" name="email" class="form-control" placeholder="Email">
                </div>
                <div class="form-group">
                    <input type="text" name="name" class="form-control" placeholder="Full name">
                </div>
                <div class="form-group">
                    <input type="radio" name="gender" value="Nam" checked/>Male
                    <input type="radio" name="gender" value="Nữ"/>Female
                </div>
                <div class="form-group">
                    <input type="password" name="pass" class="form-control" placeholder="Password">
                </div>
                <div class="form-group">
                    <input type="password" name="passR" class="form-control" placeholder="Repeat Password">
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary btn-block">Sign up</button>
                </div>
                <a href="login" id="cancel_signup">Back</a>
            </form>
        </div>
    </body>
    <script type="text/javascript">
        function CheckInput() {
            var email = document.forms["frm"]["email"].value;
            var pass = document.forms["frm"]["pass"].value;
            var passR = document.forms["frm"]["passR"].value;
            var name = document.forms["frm"]["name"].value;
            let res = /^[a-zA-Z]+$/.test('sfjd');
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
            if (passR === "") {
                msg += "Password repeat not empty.\n";
                flag = false;
            }
            if (name === "") {
                msg += "Name not empty.\n";
                flag = false;
            }
            if (!res) {
                msg += "Name must not has special character.\n";
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

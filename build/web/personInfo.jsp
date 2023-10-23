<%-- 
    Document   : personInfo
    Created on : 25-Aug-2022, 21:15:01
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
        <h1>Information</h1>
        <form action="info" method="post" onsubmit="return CheckInput();" name="frm">
            <label>PersonID</label>
            <input type="number" name="id" value="${p.getPersonID()}" readonly/><br/>
            <label>Full name</label>
            <input type="text" name="name" value="${p.getFullname()}"/><br/>
            <label>Gender</label>
            <input type="radio" name="gender" value="Nam" ${gd?"checked":""} />Male
            <input type="radio" name="gender" value="Nữ" ${gd?"":"checked"}/>Female
            
            <br/>
            <label>Email</label>
            <input type="text" name="email" value="${p.getEmail()}" required/><br/>
            <label>Password</label>
            <input type="password" name="pass" value="${p.getPassword()}" required/><br/>
            <input type="submit" value="Update"/>
            <br/><br/>
            <a href="../home/list">Back</a>
        </form>
    </body>
    <script>
        function CheckInput() {
            
            let res = /^[a-zA-Z]+$/.test('sfjd');
            var msg = "";
            var flag = true;

           
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

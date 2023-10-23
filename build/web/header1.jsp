<%@page import="model.Person"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%
            Person acc = (Person)request.getSession().getAttribute("personSess");
        %>
        <div class="container">
                <did class="header">
                    <%
                         if(acc!=null){
                    %>
                    Welcome: <%=acc.getEmail()%> | 
                    <a href="<%=request.getContextPath()%>/logout">Logout</a>
                    <%
                    }else{
                    %>
                    <a href="login">Login</a>
                    <%
                    }
                    %>
                </did>

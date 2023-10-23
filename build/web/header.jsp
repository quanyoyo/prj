<%-- 
    Document   : headerHome
    Created on : 24-Aug-2022, 18:51:12
    Author     : aquan
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container"></div>
        <div class="header">
            <%
                Person acc = (Person)request.getSession().getAttribute("personSess");
            %>
            <ul>
                <li><a href="<%=request.getContextPath()%>/home/list"><b>PHIM HAY</b></a></li>
                <li style="width: 30px;"></li>
                <li><a href="<%=request.getContextPath()%>/home/list">Home</a></li>
                <li style="width: 20px;"></li>
                    <c:if test="${personSess.getType()==1}">
                    <li><a href="<%=request.getContextPath()%>/admin">Management</a></li>
                    </c:if>
                <li>
                    <form action="<%=request.getContextPath()%>/home/search">
                        <div class="search">
                            <input type="text" name="searchTxt" placeholder="Enter the movie's name"/>
                            <input id="button" type="submit" value="Search"/>
                        </div>
                    </form>
                </li>
                <li>
                    <%
                         if(acc!=null){
                    %>
                    <a href="info?id=<%=acc.getPersonID()%>">Hello <%=acc.getFullname()%> </a>| 
                    <a href="<%=request.getContextPath()%>/logout">Logout</a>
                    <%
                    }else{
                    %>
                    <a href="<%=request.getContextPath()%>/login">Login</a>
                    <%
                    }
                    %>
                </li>
            </ul>
        </div>
    </body>
</html>

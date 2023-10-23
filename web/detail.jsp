<%-- 
    Document   : detail
    Created on : 25-Aug-2022, 01:13:18
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
            <form action="detail">
                <div class="content-left">
                    <img style="height: 380px; width: 310px;" src="image/${m.getImage()}" alt="${m.getImage()}"/>
                </div>
                <div class="content-right">
                    <h1>${m.getTitle()}</h1>
                    <button><a href="${m.getLink()}" style="text-decoration:none">Watch movie</a></button>
                    <br/>
                    <c:forEach items="${listG}" var="g">
                        <c:if test="${m.getGenreID()==g.getGenreID()}">
                            <p><b>Genre:</b>${g.getDescription()}</p>
                        </c:if>
                    </c:forEach>
                    <c:forEach items="${listR}" var="r">
                        <c:if test="${m.getMovieID()==r.getMovieID()}">
                            <p><b>Point:</b>${r.getNumericRating()}</p>
                        </c:if>
                    </c:forEach>
                    <p><b>Description:</b>${m.getDescription()}</p>
                    <c:if test="${personSess.getPersonID()!=null}">
                        <p><button><a href="rating?mid=${m.getMovieID()}">Rating</a></button></p>
                    </c:if>
                    <br/>
                    <h2>Comment</h2>
                    <br/>
                    <div style="color: darkgray">
                        <c:forEach items="${listP}" var="p">
                            <c:if test="${p.getPersonID()==rate.getPersonID()}">
                                <p><b>${p.getFullname()}: </b>${rate.getComment()}</p>
                            </c:if>
                        </c:forEach>
                    </div>
                </div>
            </form>
        </div>
        <%@include file="footer.jsp"%>
    </body>
    <script>
        function checkLink() {
            if (href === null) {
                alert('Chịu')
            }
        }
    </script>
</html>

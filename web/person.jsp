
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
                <h1>List person</h1>
                <br/>
                <form action="search">
                    Name: <input type="text" name="personSearch" placeholder="search..."/>
                    <input type="submit" value="Search"/><br/>
                </form>
                <br/>
                <form action="searchid" onsubmit="return CheckID()"; name="frm">
                    ID: <input type="number" name="id" placeholder="Person ID"/>
                    <input type="submit" value="Search"/><br/>
                </form>
                <br/>
                <form action="list">
                    <div>
                        <table border="1">
                            <tr>
                                <th>Id</th>
                                <th>FullName</th>
                                <th>Gender</th>
                                <th>Email</th>
                                <th>Type</th>
                                <th>Active</th>
                                <th colspan="2"></th>
                            </tr>
                            <c:if test="${p.getPersonID()!=null}">
                                <c:if test="${p.getType()!=1}">
                                    <tr>
                                        <td>${p.getPersonID()}</td>
                                        <td>${p.getFullname()}</td>
                                        <td>${p.getGender()}</td>
                                        <td>${p.getEmail()}</td>
                                        <td>${p.getType()}</td>
                                        <td>${p.isIsActive()?"Yes":"No"}</td>
                                        <td><a href="disable?id=${p.getPersonID()}" onclick="return changeStat('${p.getPersonID()}')">Disable</a></td>
                                        <td><a href="enable?id=${p.getPersonID()}" onclick="return changeStat('${p.getPersonID()}')">Enable</a></td>
                                    </tr>
                                </c:if>
                            </c:if>
                            <c:forEach items="${listP}" var="p">
                                <c:if test="${p.getType()!=1}">
                                    <tr>
                                        <td>${p.getPersonID()}</td>
                                        <td>${p.getFullname()}</td>
                                        <td>${p.getGender()}</td>
                                        <td>${p.getEmail()}</td>
                                        <td>${p.getType()}</td>
                                        <td>${p.isIsActive()?"Yes":"No"}</td>
                                        <td><a href="disable?id=${p.getPersonID()}" onclick="return changeStat('${p.getPersonID()}')">Disable</a></td>
                                        <td><a href="enable?id=${p.getPersonID()}" onclick="return changeStat('${p.getPersonID()}')">Enable</a></td>
                                    </tr>
                                </c:if>
                            </c:forEach>
                        </table>
                    </div>
                </form>
            </div>
        </div>
        <%@include file="footer.jsp"%>
    </body>
    <script ty[e="text/javascript">
        function changeStat(id) {
            if (confirm("Do you want to change status of this person")) {
                return true;
            }
            return false;
        }
        function CheckID() {
            var id = document.forms["frm"]["id"].value;
            var id_int = parseInt(id)
            var msg = "";
            var flag = true;

            if (id_int <0 ) {
                msg += "Id can not be negative.\n";
                flag = false;
            }if (id === "1" ) {
                msg += "This account is admin so you can not see.\n";
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

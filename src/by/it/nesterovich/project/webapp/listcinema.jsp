<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
        <legend>List cinema</legend>

    <form class="form-horizontal" action="do?command=ListCinema" method="get">
        <fieldset>
            <table>
                <div class="row">
                    <div class=col-md-1><b>ID</b></div>
                    <div class=col-md-1><b>Name</b></div>
                    <div class=col-md-4><b>Address</b></div>
                </div>
                <c:forEach items="${cinemas}" var="cinema">
                    <tr>
                        <div class="row">
                            <div class=col-md-1>${cinema.id}</div>
                            <div class=col-md-1>${cinema.name}</div>
                            <div class=col-md-4>${cinema.address}</div>
                        </div>
                    </tr>
                </c:forEach>
            </table>
        </fieldset>
    </form>
</body>
</html>

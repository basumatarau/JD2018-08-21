<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
    <legend>Reserved ticket</legend>

    <form class="form-horizontal" action="do?command=ReservedTicket" method="get">
        <fieldset>
            <table>
                <div class="row">
                    <div class=col-md-1><b>Users id</b></div>
                    <div class=col-md-1><b>Code</b></div>
                    <div class=col-md-1><b>Cost</b></div>
                    <div class=col-md-1><b>Film</b></div>
                    <div class=col-md-1><b>Cinema</b></div>
                </div>
                <c:forEach items="${reservedTickets}" var="reservedTicket">
                    <tr>
                        <div class="row">
                            <div class=col-md-1>${reservedTicket.users_id}</div>
                            <div class=col-md-1>${reservedTicket.code}</div>
                            <div class=col-md-1>${reservedTicket.cost}</div>
                            <div class=col-md-1>${reservedTicket.films_id}</div>
                            <div class=col-md-1>${reservedTicket.cinemas_id}</div>
                        </div>
                    </tr>
                </c:forEach>
            </table>
        </fieldset>
    </form>

</body>
</html>

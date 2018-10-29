<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>

    <form class="form-horizontal" action="do?command=ListCompany" method="get">
        <fieldset>
            <table>
                <div class="row">
                    <div class=col-md-1><b>ID</b></div>
                    <div class=col-md-2><b>Name</b></div>
                    <div class=col-md-1><b>Type</b></div>
                    <div class=col-md-3><b>AmountAgents</b></div>
                    <div class=col-md-1><b>Address</b></div>
                </div>
                <c:forEach items="${companies}" var="company">
                    <tr>
                        <div class="row">
                            <div class=col-md-1>${company.id}</div>
                            <div class=col-md-2>${company.name}</div>
                            <div class=col-md-1>${company.type}</div>
                            <div class=col-md-3>${company.amount_agents}</div>
                            <div class=col-md-1>${company.address}</div>
                        </div>
                    </tr>
                </c:forEach>
            </table>
        </fieldset>
    </form>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html lang="en">
<%@ include file="include/head.htm" %>
<body>

<div class="container">
    <%@ include file="include/menu.jsp" %>
    <p>All venues for: ${user.login}</p>

    <c:forEach items="${venues}" var="venue">
        <div class="jumbotron">
              <h1 class="display-4">${venue.name}</h1>
              <p class="lead">${venue.description}</p>
              <hr class="my-4">
              <p>Fee: ${venue.fee}</p>
        </div>
    </c:forEach>

</div>
</body>
</html>

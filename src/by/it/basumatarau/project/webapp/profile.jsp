<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html lang="en">
<%@ include file="include/head.htm" %>
<body>

<div class="container">
    <%@ include file="include/menu.jsp" %>
    <p>PROFILE: ${user.login}</p>

    <form class="form-horizontal" action="do?command=Profile" method="post">
        <fieldset>

            <!-- Button -->
            <div class="form-group">
              <label class="col-md-4 control-label" for="logoutbutton"></label>
              <div class="col-md-4">
                <button id="logoutbutton" name="logoutbutton" class="btn btn-danger">Logout</button>
              </div>
            </div>

        </fieldset>
    </form>

    <div class="container">
        <c:forEach items="${usrVenues}" var="venue">
            <div class="jumbotron">
                  <h1 class="display-4">${venue.name}</h1>
                  <p class="lead">${venue.description}</p>
                  <hr class="my-4">
                  <p>Fee: ${venue.fee}</p>
            </div>
        </c:forEach>
    </div>

</div>
</body>
</html>



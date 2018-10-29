<html>
<%@ include file="include/head.htm" %>
<body>
    <div class="container">
    <%@ include file="include/menu.htm" %>
     <p>UserData: ${user}</p>

     <p>UserTickets: ${tickets}</p>

    <form class="form-horizontal" action="do?command=Profile" method="post">
    <%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
    <fieldset>

    <!-- Form Name -->
    <legend>Profile</legend>

    <!-- Button -->
    <div class="form-group">
      <label class="col-md-4 control-label" for="logout"></label>
      <div class="col-md-4">
        <button id="logout" name="logout" class="btn btn-warning">logout</button>
      </div>
    </div>

    </fieldset>
    </form>

    </div>
</body>
</html>



<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>

    <form class="form-horizontal" action="do?command=UserCabinet" method="post">
        <fieldset>

            <legend>User cabinet</legend>
            <p>${user}<br></p>

            <div><a href="do?command=ReservedTicket">Reserved ticket</a></div>
            <div><a href="do?command=ListFilm">List film</a></div>
            <div><a href="do?command=UserInfo">Info user</a></div>

            <div class="form-group">
                <label class="col-md-4 control-label" for="logout"></label>
                <div class="col-md-4">
                    <button id="logout" name="logout" class="btn btn-danger">Logout</button>
                </div>
            </div>

        </fieldset>
    </form>

</body>
</html>

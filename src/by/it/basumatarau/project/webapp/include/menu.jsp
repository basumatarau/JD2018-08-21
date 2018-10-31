<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!-- Menu: Buttons -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href=".">Home</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">

        <c:if test = "${user == null}">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="do?command=SignUp"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                <li><a href="do?command=Login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
            </ul>
        </c:if>

        <ul class="navbar-nav">
            <c:if test = "${user != null && user.roles_Id == 2}">
                <li class="nav-item">
                    <a class="nav-link" href="do?command=Admin">Admin</a>
                </li>
            </c:if>

            <li class="nav-item">
                <a class="nav-link" href="do?command=ListVenues">List Venues</a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="do?command=Reset">Reset</a>
            </li>

            <c:if test = "${user != null}">
                <li class="nav-item">
                    <a class="nav-link" href="do?command=Profile">Profile</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="do?command=CreateVenue">Create Venue</a>
                </li>
            </c:if>
        </ul>

        <c:if test = "${user != null}">
            <form class="navbar-form navbar-left" action="do?command=Profile" method="post">
                <button id="logoutbutton" name="logoutbutton" class="btn btn-danger">Logout</button>
            </form>
        </c:if>

        <form class="navbar-form navbar-right" action="do?command=Search">
              <div class="form-group">
                <input type="text" class="form-control" placeholder="Search">
              </div>
              <button type="submit" class="btn btn-default">Submit</button>
        </form>

    </div>
</nav>




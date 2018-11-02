<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!-- Menu: Buttons -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="do?command=Index">Home</a>
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
                <pjtags:navbartile command="Admin" label="Admin page"/>
            </c:if>
            <pjtags:navbartile command="ListVenues" label="Go to venues"/>

            <form class="navbar-form navbar-left" action="do?command=Reset" method="post">
                <button id="resetbutton" name="resetbutton" class="btn btn-warning">
                    <b>RESET</b>
                </button>
            </form>

            <c:if test = "${user != null}">
                <pjtags:navbartile command="Profile" label="Profile"/>
                <pjtags:navbartile command="CreateVenue" label="New Venue"/>
            </c:if>
        </ul>

        <c:if test = "${user != null}">
            <form class="navbar-form navbar-left" action="do?command=Profile" method="post">
                <button id="logoutbutton" name="logoutbutton" class="btn btn-danger">Logout</button>
            </form>
        </c:if>

        <form class="navbar-form navbar-right" action="do?command=Search" method="post">
              <div class="form-group">
                <input type="text" id="searchPattern" name="searchPattern" class="form-control" placeholder="Search">
              </div>
              <button type="submit" id="searchSubmit" name="searchSubmit" class="btn btn-default">Submit</button>
        </form>

    </div>
</nav>




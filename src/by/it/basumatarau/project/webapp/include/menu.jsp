<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!-- Menu: Buttons -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href=".">Home</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <c:if test = "${user == null}">
                <li class="nav-item">
                    <a class="nav-link" href="do?command=Login">Login</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="do?command=SignUp">Sign-up</a>
                </li>
            </c:if>

            <li class="nav-item">
                <a class="nav-link" href="do?command=ListVenues">List Venues</a>
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
    </div>
</nav>




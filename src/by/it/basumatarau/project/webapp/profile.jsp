<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html lang="en">
<%@ include file="include/head.htm" %>
<body>

<div class="container">
    <%@ include file="include/menu.jsp" %>
    <p>User login: ${user.login}</p>
    <p>User email: ${user.email}</p>

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

<div class="container">
    <h1>My venues</h>
    <div class="container">
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">Venue Name</th>
                    <th scope="col">Description</th>
                    <th scope="col">Opening</th>
                    <th scope="col">Fee</th>
                    <th scope="col">Place Name</th>
                    <th scope="col">Address</th>
                    <th scope="col"></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${userVenues}" var="venue">
                    <form class="update-venue-${venue.id}" action="do?command=Profile" method="post">
                        <tr name="venueRow" value="${venue.id}">
                            <td name="venueName" value="${venue.name}">${venue.name}</td>
                            <td name="description" value="${venue.description}">${venue.description}</td>
                            <td name="openingDeteTime" value="${venue.openingDeteTime}">${venue.openingDeteTime}</td>
                            <td name="fee" value="${venue.fee}">${venue.fee}</td>
                            <c:forEach items="${venuePlaces}" var="place">
                                <c:if test = "${place.id == venue.id}">
                                    <td name="placeName" value="${place.name}">${place.name}</td>
                                    <td name="placeAddress" value="${place.address}">${place.address}</td>
                                </c:if>
                            </c:forEach>
                            <td>
                                <button id="deleteVenue" value="deleteVenue" name="deleteVenue"
                                 class="btn btn-danger">
                                    delete
                                </button>
                            </td>
                        </tr>
                    </form>
                </c:forEach>
            </tbody>
        </table>
    </div>

</div>

</body>
</html>


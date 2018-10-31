<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html lang="en">
<%@ include file="include/head.htm" %>
<body>

<div class="container">
    <%@ include file="include/menu.jsp" %>
    <p>Search results for <b>${q}</b>:</p>
</div>

<div class="container">
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
                        </tr>
                    </form>
                </c:forEach>
            </tbody>
        </table>
    </div>

</div>

</body>
</html>

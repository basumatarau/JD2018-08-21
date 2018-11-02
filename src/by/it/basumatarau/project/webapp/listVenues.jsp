<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix = "pjtags" %>

<html lang="en">
<%@ include file="include/head.htm" %>
<body>

    <div class="container">
        <%@ include file="include/menu.jsp" %>
    </div>

    <div class="container">
        <h1>All venues:</h1>

        <pjtags:paginator
        command="ListVenues"
        totalEntries="${totalCount}"
        currentPage="${currentPage}"
        urlPrefix="startPage="
        perPage="${itemsPerPage}"/>

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
                <c:forEach items="${venues}" var="venue">
                    <form class="update-venue-${venue.id}" action="do?command=Profile" method="post">
                        <tr>
                            <input name="venueID" type="hidden" value="${venue.id}">
                            <input name="venueName" type="hidden" value="${venue.name}">
                            <td>${venue.name}</td>
                            <input name="venueDescription" type="hidden" value="${venue.description}"/>
                            <td>${venue.description}</td>
                            <input name="venueOpeningDeteTime" type="hidden" value="${venue.openingDeteTime}"/>
                            <td>${venue.openingDeteTime}</td>
                            <input name="fee" type="hidden" value="${venue.fee}"/>
                            <td>${venue.fee}</td>
                            <c:forEach items="${venuePlaces}" var="place">
                                <c:if test = "${place.id == venue.id}">
                                    <input name="placeName" type="hidden" value="${venue.users_Id}"/>
                                    <td>${place.name}</td>
                                    <input name="placeAddress" type="hidden" value="${venue.places_Id}"/>
                                    <td>${place.address}</td>
                                </c:if>
                            </c:forEach>
                        </tr>
                    </form>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>

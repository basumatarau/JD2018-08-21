<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>

    <form class="form-horizontal" action="do?command=ListFilm" method="get">
        <fieldset>


            <table>

                <div class="row">
                    <div class=col-md-1>ID</div>
                    <div class=col-md-2>Name</div>
                    <div class=col-md-1>Country</div>
                    <div class=col-md-1>Genre</div>
                    <div class=col-md-1.5>Year of issue</div>
                    <div class=col-md-1>Duration</div>
                    <div class=col-md-1.5>List cinema</div>
                </div>


                <c:forEach items="${films}" var="film">
                    <tr>
                        <td>${film.id}</td>
                        <td>${film.name}</td>
                        <td>${film.country}</td>
                        <td>${film.genre}</td>
                        <td>${film.yearOfIssue}</td>
                        <td>${film.duration}</td>
                    </tr>
                </c:forEach>


                <p>${films}<br></p>


            </table>


        </fieldset>
    </form>


</body>
</html>

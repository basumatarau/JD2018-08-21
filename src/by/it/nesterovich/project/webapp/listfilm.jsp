<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
        <legend>List film</legend>
        <div><a href="do?command=CreateFilm">Create film</a></div>

    <form class="form-horizontal" action="do?command=ListFilm" method="get">
        <fieldset>
            <table>
                <div class="row">
                    <div class=col-md-1><b>ID</b></div>
                    <div class=col-md-2><b>Name</b></div>
                    <div class=col-md-1><b>Country</b></div>
                    <div class=col-md-3><b>Genre</b></div>
                    <div class=col-md-2><b>Year of issue</b></div>
                    <div class=col-md-1><b>Duration</b></div>
                    <div class=col-md-2><b>List cinema</b></div>
                </div>
                <c:forEach items="${films}" var="film">
                    <tr>
                        <div class="row">
                            <div class=col-md-1>${film.id}</div>
                            <div class=col-md-2>${film.name}</div>
                            <div class=col-md-1>${film.country}</div>
                            <div class=col-md-3>${film.genre}</div>
                            <div class=col-md-2>${film.yearOfIssue}</div>
                            <div class=col-md-1>${film.duration}</div>
                            <div class=col-md-2><a href="do?command=ListCinema">List cinema</a></div>
                        </div>
                    </tr>
                </c:forEach>
            </table>
        </fieldset>
    </form>
</body>
</html>

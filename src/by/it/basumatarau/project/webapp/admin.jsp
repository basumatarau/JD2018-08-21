<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html lang="en">
<%@ include file="include/head.htm" %>
<body>

<div class="container">
    <%@ include file="include/menu.jsp" %>

    <div class="container">
        <div class="row">
            <div class=col-md-1>ID</div>
            <div class=col-md-2>Name</div>
            <div class=col-md-2>Password</div>
            <div class=col-md-3>Email</div>
            <div class=col-md-2>Role</div>
        </div>
    </div>

    <div class="container">
        <c:forEach items="${users}" var="user">
            <form class="update-user-${user.id}" action="do?command=Admin" method="post">

                <div class="row">
                    <div class="col-md-1">
                        <input name="id" class="form-control input-md" value="${user.id}"/>
                    </div>
                    <div class="col-md-2">
                        <input id="login" class="form-control input-md" name="login" value="${user.login}"/>
                    </div>
                    <div class="col-md-2">
                        <input id="password" class="form-control input-md" name="password" value="${user.password}"/>
                    </div>
                    <div class="col-md-3">
                        <input id="email" class="form-control input-md" name="email" value="${user.email}"/>
                    </div>
                    <div class="col-md-2">
                        <select class="form-control input-md" id="roles_id" name="roles_id">
                            <c:forEach items="${roles}" var="role">
                                <option value="${role.id}" role=${role.id} ${role.id==user.roles_Id?"selected":""}>
                                    ${role.role}
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-md-1">
                        <button id="updateUser" value="updateUser" name="updateUser" class="btn btn-success">
                            Update
                        </button>
                    </div>
                    <div class="col-md-1">
                        <button id="deleteUser" value="deleteUser" name="deleteUser" class="btn btn-danger">
                            Delete
                        </button>
                    </div>
                </div>
            </form>
        </c:forEach>
    </div>

</div>
</body>
</html>



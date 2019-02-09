<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<html lang="en">
<%@ include file="include/head.htm" %>
<body>

<script type="text/javascript">
    <%@include file="/js/signUpFormValidation.js" %>
</script>

<div class="container">

    <%@ include file="include/menu.jsp" %>
    ${message}

    <form class="form-horizontal" id="singUpForm" action="do?command=SignUp" method="post">
        <fieldset>

            <!-- Form Name -->
            <legend>Sign-up form</legend>

            <!-- Text input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="logininput">Login</label>
              <div class="col-md-4">
              <input id="logininput" name="logininput" type="text" placeholder="" value="testLogin" class="form-control input-md" required="">

              </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="emailinput">Email</label>
              <div class="col-md-4">
              <input id="emailinput" name="emailinput" type="text" placeholder="" value="testemail@mail.com" class="form-control input-md" required="">

              </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="passwordinput">Password</label>
              <div class="col-md-4">
                <input id="passwordinput" name="passwordinput" type="password" placeholder="" value="testpassword" class="form-control input-md" required="">

              </div>
            </div>

            <!-- Button -->
            <div class="form-group">
              <label class="col-md-4 control-label" for="signupsubmit"></label>
              <div class="col-md-4">
                <button id="signupsubmit" name="signupsubmit" type="submit" class="btn btn-primary">Sing me up</button>
              </div>
            </div>

        </fieldset>
    </form>
</div>
</body>
</html>





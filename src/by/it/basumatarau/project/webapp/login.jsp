<html lang="en">
<%@ include file="include/head.htm" %>
<body>

<div class="container">
    <%@ include file="include/menu.htm" %>

    <form class="form-horizontal" action="do?command=Login" method="post">
    <fieldset>
    <p>${user}<br></p>

    <!-- Form Name -->
    <legend>Authorization form</legend>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="logininput">Login</label>
      <div class="col-md-4">
      <input id="logininput" name="logininput" type="text" placeholder="" class="form-control input-md" required="">

      </div>
    </div>

    <!-- Password input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="passwordinput">Password</label>
      <div class="col-md-4">
        <input id="passwordinput" name="passwordinput" type="password" placeholder="" class="form-control input-md" required="">

      </div>
    </div>

    <!-- Button -->
    <div class="form-group">
      <label class="col-md-4 control-label" for="singlebutton"></label>
      <div class="col-md-4">
        <button id="singlebutton" name="singlebutton" class="btn btn-primary">Login</button>
      </div>
    </div>

    </fieldset>
    </form>

</div>
</body>
</html>


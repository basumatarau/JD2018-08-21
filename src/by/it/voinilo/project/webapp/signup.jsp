<html>
<%@ include file="include/head.htm" %>
<body>


<div class="container">

<%@ include file="include/menu.htm" %>

<form class="form-horizontal" action="do?command=SignUp" method="post">

</br>
</br>
</br>
</br>
</br>
<fieldset>


<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="login" align="left" >Login:</label>
  <div class="col-md-4">
  <input id="login" name="login" type="text" placeholder="" value="testlogin" class="form-control input-md">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="email"  align="left">Email:</label>
  <div class="col-md-4">
  <input id="email" name="email" type="text" placeholder="" value="testEmail" class="form-control input-md">

  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="password" align="left"> Password: </label>
  <div class="col-md-4">
    <input id="password" name="password" type="password" placeholder="" value="testPassword" class="form-control input-md">

  </div>
</div>

<!-- Button -->
<div class="form-group" >
  <label class="col-md-4 control-label" for="submit" ></label>
  <div class="col-md-4" align="right">
    <button id="submit" name="submit" class="btn btn-primary" >Submit</button>
  </div>
</div>


</fieldset>
</form>

</div>

</body>
</html>





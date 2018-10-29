<html>
<%@ include file="include/head.htm" %>
<body>


<div class="container" >

<%@ include file="include/menu.htm" %>
<form class="form-horizontal" action="do?command=Login" method="post">
</br>
</br>
</br>
</br>
</br>
<fieldset>

<hr>
<p>${user}<br></p>

<hr>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="login">Login</label>
  <div class="col-md-4">
  <input id="login" name="login" type="text" value="testLogin" placeholder="" class="form-control input-md">

  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="password">Password</label>
  <div class="col-md-4">
    <input id="password" name="password" type="password" value="testPassword" placeholder="" class="form-control input-md">

  </div>
</div>

<!-- Button -->
<div class="form-group" >
  <label class="col-md-4 control-label" for="submit" ></label>
  <div class="col-md-4" align="right">
    <button id="submit" name="submit" class="btn btn-primary" >SignIn</button>
  </div>
</div>

</fieldset>
</div>
</form>
</body>
</html>


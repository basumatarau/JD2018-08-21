<html>
<%@ include file="include/head.htm" %>
<body>

<%@ include file="include/menu.htm" %>
<div align="center">
<p>Cmd Login: ${message}</p>




<form class="form-horizontal">
</br>
</br>
</br>
</br>
</br>
<fieldset>





<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Login</label>
  <div class="col-md-4">
  <input id="textinput" name="textinput" type="text" placeholder="" class="form-control input-md">

  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="passwordinput">Password</label>
  <div class="col-md-4">
    <input id="passwordinput" name="passwordinput" type="password" placeholder="" class="form-control input-md">

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
</div>
</form>
</body>
</html>


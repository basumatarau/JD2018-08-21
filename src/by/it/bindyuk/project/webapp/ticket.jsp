<html>
<%@ include file="include/head.htm" %>
<body>
     <div class="container">
     <%@ include file="include/menu.htm" %>
     <form class="form-horizontal" action="do?command=Ticket" method="post">
     <%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<fieldset>

<!-- Form Name -->
<legend>Ticket Issuance</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="transport">Transport</label>
  <div class="col-md-4">
  <input id="transport" name="transport" type="text" placeholder="" class="form-control input-md" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="from">From</label>
  <div class="col-md-4">
  <input id="from" name="from" type="text" placeholder="" class="form-control input-md" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="to">To</label>
  <div class="col-md-4">
  <input id="to" name="to" type="text" placeholder="" class="form-control input-md" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="when">When</label>
  <div class="col-md-4">
  <input id="when" name="when" type="text" placeholder="" class="form-control input-md" required="">
    
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton"></label>
  <div class="col-md-4">
    <button id="singlebutton" name="singlebutton" class="btn btn-primary">BUY</button>
  </div>
</div>

</fieldset>
</form>
</div>
</body>
</html>

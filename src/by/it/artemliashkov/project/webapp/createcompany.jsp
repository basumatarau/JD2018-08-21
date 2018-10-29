<html>
<%@ include file="include/head.htm" %>
<body>
    <div class="container">
    <%@ include file="include/menu.htm" %>

<form class="form-horizontal" action="do?command=CreateCompany" method="post">
<fieldset>

<p>${user}<br></p>

<!-- Form Name -->
<legend>Form Create</legend>

<!-- Text input-->
<div class="form-group">
<label class="col-md-4 control-label" for="name">Name</label>
<div class="col-md-4">
<input id="name" name="name" value="TestName" type="text" placeholder="" class="form-control input-md" required="">

  </div>
</div>


<!-- Text input-->
<div class="form-group">
<label class="col-md-4 control-label" for="type">Type</label>
<div class="col-md-4">
<input id="surname" name="type" value="TestType" type="text" placeholder="" class="form-control input-md" required="">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
<label class="col-md-4 control-label" for="amount_agents">AmountAgents</label>
<div class="col-md-4">
<input id="description" name="amount_agents" value="AmountAgents" type="text" placeholder="" class="form-control input-md" required="">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
<label class="col-md-4 control-label" for="address">Address</label>
<div class="col-md-4">
<input id="address" name="address" value="TestAddress" type="text" placeholder="" class="form-control input-md" required="">

  </div>
</div>



<!-- Button -->
<div class="form-group">
   <label class="col-md-4 control-label" for="signupsubmit"></label>
   <div class="col-md-4">
     <button id="signupsubmit" name="signupsubmit" class="btn btn-success">SignUp</button>
  </div>
</div>

    </fieldset>
    </form>


</body>
</html>

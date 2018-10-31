<html>
<%@ include file="include/head.htm" %>
<body>
     <div class="container">
     <%@ include file="include/menu.htm" %>
     <form class="form-horizontal" action="do?command=SignUp" method="post">
     <%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
     <fieldset>

     <!-- Form Name -->
     <legend>New User</legend>

     <!-- Text input-->
     <div class="form-group">
       <label class="col-md-4 control-label" for="login">Login</label>
       <div class="col-md-4">
       <input id="login" name="login" type="text" placeholder="" class="form-control input-md" required="">

       </div>
     </div>

     <!-- Password input-->
     <div class="form-group">
       <label class="col-md-4 control-label" for="password">Password</label>
       <div class="col-md-4">
         <input id="password" name="password" type="password" placeholder="" class="form-control input-md" required="">

       </div>
     </div>

     <!-- Text input-->
     <div class="form-group">
       <label class="col-md-4 control-label" for="email">Email</label>
       <div class="col-md-4">
       <input id="email" name="email" type="text" placeholder="" class="form-control input-md" required="">

       </div>
     </div>

     <!-- Text input-->
     <div class="form-group">
       <label class="col-md-4 control-label" for="passportseries">Passport Series</label>
       <div class="col-md-4">
       <input id="passportseries" name="passportseries" type="text" placeholder="" class="form-control input-md" required="">

       </div>
     </div>

     <!-- Text input-->
          <div class="form-group">
            <label class="col-md-4 control-label" for="passportid">Passport ID</label>
            <div class="col-md-4">
            <input id="passportid" name="passportid" type="text" placeholder="" class="form-control input-md" required="">

            </div>
          </div>

     <!-- Text input-->
     <div class="form-group">
       <label class="col-md-4 control-label" for="bancard">Bancard Number</label>
       <div class="col-md-4">
       <input id="bancard" name="bancard" type="text" placeholder="" class="form-control input-md" required="">

       </div>
     </div>

     <!-- Text input-->
     <div class="form-group">
       <label class="col-md-4 control-label" for="cid">CID</label>
       <div class="col-md-4">
       <input id="cid" name="cid" type="text" placeholder="" class="form-control input-md" required="">

       </div>
     </div>

     <!-- Button -->
     <div class="form-group">
       <label class="col-md-4 control-label" for="signupsubmit"></label>
       <div class="col-md-4">
         <button id="signupsubmit" name="signupsubmit" class="btn btn-primary">Submit</button>
       </div>
     </div>


     </fieldset>
     </form>
     </div>
</body>
</html>








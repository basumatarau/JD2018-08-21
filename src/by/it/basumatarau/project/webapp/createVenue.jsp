<html lang="en">
<%@ include file="include/head.htm" %>
<body>

<div class="container">
    <%@ include file="include/menu.htm" %>
    <p>Cmd CreateVenue: ${message}</p>

    <form class="form-horizontal" action="do?command=createVenue" method="post">
        <fieldset>

            <!-- Form Name -->
            <legend>New Venue Form</legend>

            <!-- Text input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="nameinput">Venue Name</label>
              <div class="col-md-4">
              <input id="nameinput" name="nameinput" type="text" placeholder="" class="form-control input-md" required="">

              </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="descriptioninput">Venue Description</label>
              <div class="col-md-4">
              <input id="descriptioninput" name="descriptioninput" type="text" placeholder="" class="form-control input-md" required="">

              </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="placenameinput">Place Name</label>
              <div class="col-md-4">
              <input id="placenameinput" name="placenameinput" type="text" placeholder="" class="form-control input-md" required="">

              </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="addressinput">Address</label>
              <div class="col-md-4">
              <input id="addressinput" name="addressinput" type="text" placeholder="" class="form-control input-md" required="">

              </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="feeinput">Fee</label>
              <div class="col-md-4">
              <input id="feeinput" name="feeinput" type="text" placeholder="" class="form-control input-md" required="">

              </div>
            </div>

            <!-- DateTime input -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="datetimeinput">Date and time</label>
                <div class="col-md-4">
                    <div class='input-group date' id='datetimepicker1' showMeridian="false" language="ru">
                        <script type="text/javascript">
                                $(function () {
                                    $('#datetimepicker1').datetimepicker({
                                            format: 'YYYY-MM-DD hh:mm:ss',

                                            <!-- showMeridian: false,-->
                                        });
                                });
                        </script>
                        <input id="datetimeinput" name="datetimeinput" type="text" class="form-control input-md" required=""/>
                        <div class="input-group-addon">
                            <div class="glyphicon glyphicon-calendar"></div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Button -->
            <div class="form-group">
              <label class="col-md-4 control-label" for="venuesubmit"></label>
              <div class="col-md-4">
                <button id="venuesubmit" name="venuesubmit" class="btn btn-primary">post new venue</button>
              </div>
            </div>

        </fieldset>
    </form>


</div>
</body>
</html>

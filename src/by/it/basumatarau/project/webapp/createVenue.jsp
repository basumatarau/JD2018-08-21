<%@ include file="include/head.htm" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<html lang="en">
<body>

<div class="container">
    <%@ include file="include/menu.jsp" %>

    <script type="text/javascript">
        <%@include file="/js/createVenueFormValidation.js" %>
    </script>

    <script type="text/javascript">
        <%@include file="/js/dateTimePicker.js" %>
    </script>

    <form name="createVenueForm" id="createVenueForm" class="form-horizontal" class="needs-validation" action="do?command=createVenue" method="post">
        <fieldset>

            <!-- Form Name -->
            <legend>New Venue Form</legend>

            <!-- Text input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="nameinput">Venue Name</label>
              <div class="col-md-4">
              <input id="nameinput" name="nameinput" type="text" placeholder="" value="testVenueName" class="form-control input-md">
              </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="descriptioninput">Venue Description</label>
              <div class="col-md-4">
              <input id="descriptioninput" name="descriptioninput" type="text" placeholder="" value="testDescription" class="form-control input-md" required="">
              </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="placenameinput">Place Name</label>
              <div class="col-md-4">
              <input id="placenameinput" name="placenameinput" type="text" placeholder="" value="testPlaceName" class="form-control input-md" required="">

              </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="addressinput">Address</label>
              <div class="col-md-4">
              <input id="addressinput" name="addressinput" type="text" placeholder="" value="testaddress" class="form-control input-md" required="">

              </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="feeinput">Fee</label>
              <div class="col-md-4">
              <input id="feeinput" name="feeinput" type="text" placeholder="" value="5.5" class="form-control input-md" required="">

              </div>
            </div>

            <!-- DateTime input -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="datetimeinput">Date and time</label>
                <div class="col-md-4">
                    <div class='input-group date' id='createVenueDatetimePicker' showMeridian="false" language="ru">


                        <input id="datetimeinput" name="datetimeinput" type="text" class="form-control input-md" value="2018-11-06 12:25:00" required=""/>
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
                <button id="venuesubmit" type="submit" name="venuesubmit" class="btn btn-primary">post new venue</button>
              </div>
            </div>

        </fieldset>
    </form>


</div>
</body>
</html>

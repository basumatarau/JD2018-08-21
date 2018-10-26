<html>
<%@ include file="include/head.htm" %>
<body>
     <div class="container">
     <%@ include file="include/menu.htm" %>
     <form class="form-horizontal" action="do?command=Order" method="get">
     <fieldset>


    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">

    <title>Narrow Jumbotron Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="../../css/editor.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="narrow-jumbotron.css" rel="stylesheet">

  <body><ul class="list-group" style="border: 1px dashed rgb(66, 133, 244);">

</ul>

      <div class="jumbotron">
        <h1 class="display-3">Ticket has been ordered&nbsp;</h1>
        <p></p>
      </div>

        <p>TRANSPORT: ${transport}</p>
        <p>FROM: ${from}</p>
        <p>TO: ${to}</p>
        <p>DATE: ${date}</p>
  
</fieldset>
</div>
</body>
</html>
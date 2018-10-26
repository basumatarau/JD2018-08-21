<html>
<%@ include file="include/head.htm" %>
<body>
  <div class="container">
      <%@ include file="include/menu.htm" %>
       <form class="form-horizontal" action="do?command=ListForm" method="get">
          <fieldset>
               <table>
                   <div class="row">
                      <div class=col-md-1>ID</div>
                      <div class=col-md-2>Name</div>
                      <div class=col-md-1>Surname</div>
                      <div class=col-md-1>Address</div>
                      <div class=col-md-1>Description</div>
                      <div class=col-md-1.5>Age</div>
                      <div class=col-md-1>Information</div>
                      <div class=col-md-1>Aim</div>
                  </div>
                   <c:forEach items="${forms}" var="form">
                      <tr>
                          <td>${form.id}</td>
                          <td>${form.name}</td>
                          <td>${form.surname}</td>
                          <td>${form.address}</td>
                          <td>${form.description}</td>
                          <td>${form.age}</td>
                          <td>${form.information}</td>
                          <td>${form.aim}</td>
                      </tr>
                  </c:forEach>
                   <p>${forms}<br></p>
               </table>
           </fieldset>
      </form>
   </body>
  </html>
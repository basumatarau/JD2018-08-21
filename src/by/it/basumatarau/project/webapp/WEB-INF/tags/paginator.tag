<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<%@ attribute name="totalEntries" required="true" rtexprvalue="true" type="java.lang.Integer" %>
<%@ attribute name="currentPage" required="true" rtexprvalue="true" type="java.lang.Integer" %>
<%@ attribute name="urlPrefix" required="true" rtexprvalue="true" type="java.lang.String" %>
<%@ attribute name="command" required="true" rtexprvalue="true" type="java.lang.String" %>
<%@ attribute name="perPage" required="true" rtexprvalue="true" type="java.lang.Integer" %>

<%
    int pages = (((int)(totalEntries/perPage))+1);

    if(currentPage == null) currentPage = 1;

    if(currentPage > pages || currentPage < 1){
        currentPage = 1;
    }

    request.setAttribute("totalPages", pages);
    request.setAttribute("currentPage", currentPage);

    if(currentPage <= 2){
        request.setAttribute("first", "1");
        request.setAttribute("second", "2");
        request.setAttribute("third", "3");
        if(currentPage==2){
            request.setAttribute("secondActive", "active");
        }else{
            request.setAttribute("firstActive", "active");
        }

        switch(pages){
            case 1:
            request.setAttribute("secondAttr", "disabled");
            request.setAttribute("thirdAttr", "disabled");
            break;

            case 2:
            request.setAttribute("thirdAttr", "disabled");
            break;

            case 0:
            request.setAttribute("firstActive", "disabled");
            request.setAttribute("secondAttr", "disabled");
            request.setAttribute("thirdAttr", "disabled");
        }
    }else if(currentPage > pages-2){
        request.setAttribute("first", pages-2);
        request.setAttribute("second", pages-1);
        request.setAttribute("third", pages);

        if(currentPage == pages){
            request.setAttribute("thirdActive", "active");
        }else{
            request.setAttribute("secondActive", "active");
        }
    }else{
        request.setAttribute("first", (currentPage-1));
        request.setAttribute("second", (currentPage));
        request.setAttribute("third", (currentPage+1));
        request.setAttribute("secondActive", "active");
    }

    if(currentPage == pages){
        request.setAttribute("nextAttr", "");
    }else if(currentPage < pages){
        request.setAttribute("nextAttr", "disabled");
    }

    if(currentPage==1){
        request.setAttribute("prevAttr", "disabled");
    }else if(currentPage > 1){
        request.setAttribute("prevAttr", "");
    }

%>
<div class="container">
<div class="text-center">
    <ul class="pagination">
        <c:if test="${currentPage > 1}">
            <li class="page-item ${prevAttr}">
                <a class="page-link " href="do?command=${command}&${urlPrefix}${currentPage - 1}">Previous</a>
            </li>
        </c:if>

        <li class="page-item ${firstActive} ${firstAttr}"><a class="page-link" href="do?command=${command}&${urlPrefix}${first}">${first}</a></li>
        <li class="page-item ${secondActive} ${secondAttr}"><a class="page-link" href="do?command=${command}&${urlPrefix}${second}">${second}</a></li>
        <li class="page-item ${thirdActive} ${thirdAttr}"><a class="page-link" href="do?command=${command}&${urlPrefix}${third}">${third}</a></li>

        <c:if test="${currentPage < totalPages}">
            <li class="page-item ${nextAttr}">
                <li class="page-item"><a class="page-link" href="do?command=${command}&${urlPrefix}${currentPage + 1}">Next</a></li>
            </li>
        </c:if>
    </ul>
</div>
<div>
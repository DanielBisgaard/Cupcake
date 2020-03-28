
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="includes/header2.inc"%>





<h1 class="text-center">Velkommen til login siden</h1>


<c:forEach items = "${users}" var = "user">
    <p>Users = ${user}</p>
</c:forEach>
        <c:if test = "${requestScope.error!= null}" >

           <h2>Error ! </h2>
            ${requestScope.error}

        </c:if>

<%@include file="includes/footer.inc"%>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="includes/header2.inc"%>



<a href="employeeRegister.jsp">employee</a>

<h1>Velkommen til login side</h1>



        <c:if test = "${requestScope.error!= null}" >

           <h2>Error ! </h2>
            ${requestScope.error}

        </c:if>

<%@include file="includes/footer.inc"%>

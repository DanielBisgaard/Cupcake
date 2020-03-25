<%-- 
    Document   : employeepage.jsp
    Created on : Aug 24, 2017, 6:31:57 AM
    Author     : kasper
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../includes/header3.inc"%>

<h1>Hello ${sessionScope.email} </h1>
<h1>Velkommen til hjem. You are now logged in as an EMPLOYEE of our wonderful site.</h1>




<c:if test = "${requestScope.error!= null}" >

    <h2>Error ! </h2>
    ${requestScope.error}

</c:if>


<%@include file="../includes/footer.inc"%>


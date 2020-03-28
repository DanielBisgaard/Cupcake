<%-- 
    Document   : customerpage
    Created on : Aug 22, 2017, 2:33:37 PM
    Author     : kasper
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../includes/header3.inc"%>




        <h1 class="text-center">Hello ${sessionScope.email} </h1>





<p class="text-center">You are now logged in as a customer of our wonderful site.</p>

<%@include file="../includes/footer.inc"%>
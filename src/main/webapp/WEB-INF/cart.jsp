<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: baske
  Date: 26/03/2020
  Time: 15.55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../includes/header3.inc" %>



<h1 class="text-center">Bestillingsliste</h1>
<hr>

</hr>
<ul class="text-center">
    <c:set var="count" value="0" scope="page" />
    <c:set var="OLP" value="0" scope="page" />
    <c:forEach items="${sessionScope.xy}"  var="OL">
        <li><p>Top ingrediens:<strong> ${OL.topIngredient}</strong></p>
        <p>Bund ingrediens:<strong> ${OL.botIngredient}</strong></p>
        <p>Pris pr. cupcake:<strong> ${OL.price}</strong></p>
        <p>Antal cupcakes:<strong> ${OL.count}</strong></p>
        <p>Ordrelinje ID:<strong> ${OL.orderLineID}</strong></p></li>



        <form action="FrontController" method="get">


        <input type="hidden" name="taget" value="deleteorderline">
            <input type="hidden" name="OrderLineID" value="${OL.orderLineID}">
                    <input type="hidden" name="email" value="${sessionScope.email}">


            <div class="text-center">
                <button type="submit" class="btn btn-primary">Slet</button>
            </div>
        </form>
        <hr>

        </hr>
        <c:set var="OLP" value="${OL.count * OL.price}" scope="page"/>
        <c:set var="count" value="${count + OLP}" scope="page"/>
    </c:forEach>

</ul>
<p class="text-center">Sammenlagt pris:<strong> ${count}</strong></p>


<%@include file="../includes/footer.inc"%>

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



<h1 class="text-center">Ordre liste</h1>
<hr>

</hr>
<ul class="text-center">

    <c:forEach items="${sessionScope.linjer}"  var="OUL">
        <li><p>Ordre ID:<strong> ${OUL.orderID}</strong></p>
        <p>Bruger ID:<strong> ${OUL.userID}</strong></p>
        <p>Betalt dato:<strong> ${OUL.paidTime}</strong></p>
        <p>Email:<strong> ${OUL.email}</strong></p>
        <p>Credit:<strong> ${OUL.credit}</strong></p></li>

        <form action="FrontController" method="get">


        <input type="hidden" name="taget" value="deleteorder">
            <input type="hidden" name="orderID" value="${OUL.orderID}">



            <div class="text-center">
                <button type="submit" class="btn btn-primary">Slet</button>
            </div>
        </form>
        <hr>

        </hr>

    </c:forEach>

</ul>





<%@include file="../includes/footer.inc"%>

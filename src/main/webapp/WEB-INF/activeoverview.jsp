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



<h1 class="text-center">Aktive ordrelinjer</h1>
<hr>

</hr>
<ul class="text-center">

    <c:forEach items="${sessionScope.xy}"  var="OUL">
        <li><p>Ordre ID:<strong> ${OUL.orderID}</strong></p>
        <p>Bruger ID:<strong> ${OUL.userID}</strong></p>
        <p>Top ingrediens:<strong> ${OUL.topIngredient}</strong></p>
        <p>Bund ingrediens:<strong> ${OUL.botIngredient}</strong></p>
        <p>Produkt ID:<strong> ${OUL.productID}</strong></p>
        <p>Cupcake pris:<strong> ${OUL.price}</strong></p>
        <p>Antal:<strong> ${OUL.count}</strong></p>
        </li> <hr>

        </hr>

    </c:forEach>

</ul>





<%@include file="../includes/footer.inc"%>

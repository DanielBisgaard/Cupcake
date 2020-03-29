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



<h1 class="text-center">Brugere</h1>
<hr>

</hr>
<ul class="text-center">
    <c:forEach items="${sessionScope.xyz}"  var="U">
        <li>
            <p>Email:<strong> ${U.email}</strong></p>
            <p>Password:<strong> ${U.password}</strong></p>
            <p>Employee/Customer:<strong> ${U.role}</strong></p>
            <p>Kredit:<strong> ${U.credit} kr</strong></p>



        </li>

        <hr>

        </hr>

    </c:forEach>

</ul>





<%@include file="../includes/footer.inc"%>

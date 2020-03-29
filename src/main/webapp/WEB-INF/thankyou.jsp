
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../includes/header3.inc"%>


<h1 class="text-center">Tak for dit køb!</h1>
<h2 class="text-center"><Strong>OBS!</Strong> Grundet corona-virus, bedes du hente og nyde dine cupcakes hjemme - ikke i Olskers Cafe</h2>
<h2 class="text-center"><Strong>Tak!</Strong></h2>




<c:if test = "${requestScope.error!= null}" >

    <h2>Error ! </h2>
    ${requestScope.error}

</c:if>
</body>
</html>

<%@include file="../includes/footer.inc"%>

<%--
  Created by IntelliJ IDEA.
  User: baske
  Date: 26/03/2020
  Time: 15.55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Halloooo
<c:forEach items="${orderlines}" var="item">
    ${item}<br>
</c:forEach>
</body>
</html>

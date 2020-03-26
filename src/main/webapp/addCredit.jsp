<%--
  Created by IntelliJ IDEA.
  User: Bruger
  Date: 3/26/2020
  Time: 1:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<li>
    <form action="FrontController" method="post">
        <input type="hidden" name="taget" value="addCredit">
        <p class="hint-text">Fill in this form to create your account!</p>
        <div class="form-group">
            <input type="text" class="form-control" name="email" placeholder="Email" required="required">
        </div>
        <div class="form-group">
            <input type="password" class="form-control" name="credit" placeholder="credit" required="required">
        </div>

        <input type="submit" class="btn btn-primary btn-block" value="Sign up">
    </form>
</li>
</body>
</html>

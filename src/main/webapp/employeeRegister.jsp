<%--
  Created by IntelliJ IDEA.
  User: Bruger
  Date: 3/25/2020
  Time: 12:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
<head>
    <title>Employee Registration</title>
    <form name="registerEmployee" action="FrontController" method="POST">
        <p class="hint-text">Fill in this form to create your account!</p>
        <input type="hidden" name="target" value="registerEmployee">
        <div class="form-group">
            Email:
            <input type="text" class="form-control" name="email" placeholder="E-mail" required="required">
        </div>
        <div class="form-group">
            Password:
            <input type="password"  class="form-control" name="password1" placeholder="password" required="required">
            <br>
            Retype Password:
            <input type="password"  class="form-control" name="password2" placeholder="password" required="required">

        </div>
        <label class="checkbox-inline"><input type="checkbox" required="required"> I accept the <a href="#">Terms &amp; Conditions</a></label>
        <div class="form-group">
            <input type="submit" class="btn btn-primary btn-block" value="Submit">
        </div>
    </form>
</head>
<body>

</body>
</html>

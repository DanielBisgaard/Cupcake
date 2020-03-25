<%--
  Created by IntelliJ IDEA.
  User: Bruger
  Date: 3/25/2020
  Time: 3:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<li class="nav-item">
    <a href="#" data-toggle="dropdown" class="btn btn-primary dropdown-toggle get-started-btn mt-1 mb-1">Sign up</a>
    <ul class="dropdown-menu form-wrapper">
        <li>
            <form action="FrontController" method="post">
                <input type="hidden" name="taget" value="registerEmployee">
                <p class="hint-text">Fill in this form to create your account!</p>
                <div class="form-group">
                    <input type="text" class="form-control" name="email" placeholder="Email" required="required">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" name="password1" placeholder="Password" required="required">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" name="password2" placeholder="Confirm Password" required="required">
                </div>
                <div class="form-group">
                    <label class="checkbox-inline"><input type="checkbox" required="required"> I accept the <a href="#">Terms &amp; Conditions</a></label>
                </div>
                <input type="submit" class="btn btn-primary btn-block" value="Sign up">
            </form>
        </li>
</body>
</html>

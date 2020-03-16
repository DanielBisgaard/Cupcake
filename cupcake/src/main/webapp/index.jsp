
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file ="includes/CSS.inc"%>
<%@include file ="includes/navbar.inc"%>
<%@include file="includes/header.inc"%>



<!DOCTYPE html>
<html>
    <head>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->

    </head>
    <body>

    <table>
        <tr>

            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title class="text-center">Login side</title>

            <td style="color:white">

                <div class="container login-container">
                    <div class="row">
                        <div class="outer">
                            <div class="middle">
                                <div class="inner">

                        <div class="text-center" class="col-md-6 login-form-1">
                            <h3>Login</h3>

                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Din Email" value="" />
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control" placeholder="Dit Password" value="" />
                            </div>
                            <div class="form-group">
                                <input type="submit" class="btnSubmit" value="Login" />
                            </div>
                            <div class="form-group">
                                <a  style="font-size:20px"
                                    href="#" class="btnForgetPwd">Glemt Password?</a>
                            </div>

                        </div>

                                    <div class="text-center" class="col-md-6 login-form-1">
                                        <h3>Registrer</h3>
                                    </div>

                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Din Email" value="" />
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control" placeholder="Dit Password" value="" />
                            </div>
                            <div class="form-group">
                                <input type="submit" class="btnSubmit" value="Registrer"/>
                            </div>
                            </div>

                                </div>
                            </div>
                        </div>
            </td>
        </tr>
    </table>
    </td>
    </tr>
    </table>


<%--        Bare lige se I har en ide om hvad vi forslå I ikke gør ! det hedder scpript lets --%>
<%--        <% String error = (String) request.getAttribute( "error");--%>
<%--           if ( error != null) { --%>
<%--               out.println("<H2>Error!!</h2>");--%>
<%--               out.println(error);--%>
<%--           }--%>
<%--        %>--%>

        <c:if test = "${requestScope.error!= null}" >

           <h2>Error ! </h2>
            ${requestScope.error}

        </c:if>
    </body>
</html>

<%@include file="includes/footer.inc"%>

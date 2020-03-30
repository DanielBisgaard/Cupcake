<%-- 
    Document   : employeepage.jsp
    Created on : Aug 24, 2017, 6:31:57 AM
    Author     : kasper
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="../includes/header3.inc" %>

<h1 class="text-center">Hello ${sessionScope.email} </h1>
<div class="row">

    <div class="col-md-4"></div>
<div class="col-md-4">
<form action="FrontController" method="post">
    <input type="hidden" name="taget" value="activeoverview">
    <div class="text-center">
        <label>
            <button class="btn btn-primary">Aktive ordre</button>
        </label>
    </div> </form>
<br>
<a href="FrontController?taget=overview"><div class="text-center">
    <label>
        <button class="btn btn-primary">Ordre</button>
    </label>
</div> </a>
<br>
<a href="FrontController?taget=getusers"><div class="text-center">
    <label>
        <button class="btn btn-primary">Brugere</button>
    </label>
</div> </a>
</div>
</div>
<hr></hr>
<br>
<div class="row">

    <div class="col-md-4"></div>


    <div class="col-md-4">
        <h2 class="text-center">Registrer ny medarbejder profil.</h2>
        <form action="FrontController" method="post">

            <input type="hidden" name="taget" value="registerEmployee">

            <div class="form-group">
                <label for="email">Indtast email:</label>
                <input type="text" class="form-control" id="email" name="email">
            </div>


            <div class="form-group">
                <label for="password1">Indtast kodeord:</label>
                <input type="password" class="form-control" id="password1" name="password1">
            </div>

            <div class="form-group">
                <label for="password2">Indtast kodeord igen:</label>
                <input type="password" class="form-control" id="password2" name="password2">
            </div>

            <div class="text-center">
                <button type="submit" class="btn btn-primary">Tilføj bruger</button>
            </div>
        </form>
    </div>
</div>
    <hr></hr>

    <form action="FrontController" method="post">
        <input type="hidden" name="taget" value="addCredit">
<div class="row">

    <div class="col-md-4"></div>

    <div class="col-md-4">

            <p class="hint-text">Sæt konto værdi</p>
            <div class="form-group">
                <input type="text" class="form-control" name="amail" placeholder="Email" required="required">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="credit" placeholder="credit" required="required">
            </div>

            <div class="text-center">
                <button type="submit" class="btn btn-primary">Sæt kredit</button>
            </div>

    </div>
</div>
</form>
    <hr></hr>





<%@include file="../includes/footer.inc" %>


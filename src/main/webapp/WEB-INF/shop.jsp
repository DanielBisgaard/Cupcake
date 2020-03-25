
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../includes/header3.inc"%>


<h1 class="text-center">Velkommen til shoppen</h1>
<br>
<div class="square bg img1">
    <div class="content">
        <div class="table">
            <div class="table-cell">
                Chokolade
            </div>
        </div>
    </div>
</div>
<div class="square bg img2">
    <div class="content">
        <div class="table">
            <div class="table-cell">
                Vanilje
            </div>
        </div>
    </div>
</div>
<div class="square bg img3">
    <div class="content">
        <div class="table">
            <div class="table-cell">
                Muskat
            </div>
        </div>
    </div>
</div>
<div class="square bg img4">
    <div class="content">
        <div class="table">
            <div class="table-cell">
                Pistacie
            </div>
        </div>
    </div>
</div>
<div class="square bg img5">
    <div class="content">
        <div class="table">
            <div class="table-cell">
                Mandel
            </div>
        </div>
    </div>
</div>


<br>
<br>



        <c:if test = "${requestScope.error!= null}" >

           <h2>Error ! </h2>
            ${requestScope.error}

        </c:if>


<%@include file="../includes/footer.inc"%>

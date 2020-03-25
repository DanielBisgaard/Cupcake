
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="includes/header2.inc"%>


<h1 class="text-center">Velkommen til shoppen</h1>
<br>
<h2 class="text-center">Vælg cupcake top</h2>
<a href="index.jsp">
    <div class="square bg img6">
        <div class="content">
            <div class="table">
                <div class="table-cell">
                    <h3>Chokolade</h3>
                </div>
            </div>
        </div>
    </div>
</a>
<a href="index.jsp">
    <div class="square bg img7">
        <div class="content">
            <div class="table">
                <div class="table-cell">
                    <h3>Blåbær</h3>
                </div>
            </div>
        </div>
    </div>
</a>
<a href="index.jsp">
    <div class="square bg img8">
        <div class="content">
            <div class="table">
                <div class="table-cell">
                    <h3>Hindbær</h3>
                </div>
            </div>
        </div>
    </div>
</a>
<a href="index.jsp">
    <div class="square bg img9">
        <div class="content">
            <div class="table">
                <div class="table-cell">
                    <h3>Knas</h3>
                </div>
            </div>
        </div>
    </div>
</a>
<a href="index.jsp">
    <div class="square bg img10">
        <div class="content">
            <div class="table">
                <div class="table-cell">
                    <h3>Jordbær</h3>
                </div>
            </div>
        </div>
    </div>
</a>
<a href="index.jsp">
    <div class="square bg img11">
        <div class="content">
            <div class="table">
                <div class="table-cell">
                    <h3>Rom / Rosin</h3>
                </div>
            </div>
        </div>
    </div>
</a>
<a href="index.jsp">
    <div class="square bg img12">
        <div class="content">
            <div class="table">
                <div class="table-cell">
                    <h3>Appelsin</h3>
                </div>
            </div>
        </div>
    </div>
</a>
<a href="index.jsp">
    <div class="square bg img13">
        <div class="content">
            <div class="table">
                <div class="table-cell">
                    <h3>Citron</h3>
                </div>
            </div>
        </div>
    </div>
</a>
<a href="index.jsp">
    <div class="square bg img14">
        <div class="content">
            <div class="table">
                <div class="table-cell">
                    <h3>Blue cheese</h3>
                </div>
            </div>
        </div>
    </div>
</a>

<br>
<br>
<br>
<br><br>
<br><br>
<br>
<h2 class="text-center">Vælg cupcake bund</h2>
<a href="index.jsp">
    <div class="square bg img1">
        <div class="content">
            <div class="table">
                <div class="table-cell">
                    <h3>Chokolade</h3>
                </div>
            </div>
        </div>
    </div>
</a>
<a href="index.jsp">
    <div class="square bg img2">
        <div class="content">
            <div class="table">
                <div class="table-cell">
                    <h3>Vanilje</h3>
                </div>
            </div>
        </div>
    </div>
</a>
<a href="index.jsp">
    <div class="square bg img3">
        <div class="content">
            <div class="table">
                <div class="table-cell">
                    <h3>Muskat</h3>
                </div>
            </div>
        </div>
    </div>
</a>
<a href="index.jsp">
    <div class="square bg img4">
        <div class="content">
            <div class="table">
                <div class="table-cell">
                    <h3>Pistacie</h3>
                </div>
            </div>
        </div>
    </div>
</a>
<a href="index.jsp">
    <div class="square bg img5">
        <div class="content">
            <div class="table">
                <div class="table-cell">
                    <h3>Mandel</h3>
                </div>
            </div>
        </div>
    </div>
</a>

<br>
<br>



<c:if test = "${requestScope.error!= null}" >

    <h2>Error ! </h2>
    ${requestScope.error}

</c:if>


<%@include file="includes/footer.inc"%>

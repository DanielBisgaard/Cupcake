<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="../includes/header3.inc" %>


<h1 class="text-center">Velkommen til shoppen</h1>
<br>
<h2 class="text-center">Vælg cupcake top</h2>

<form action="FrontController" method="post">

    <input type="hidden" name="taget" value="cart">

    <input type="hidden" name="email" value="${sessionScope.email}">


    <div class="form-group">
        <div class="square bg img6">
            <div class="content">
                <div class="table">
                    <div class="table-cell">
                        <div class="radio">
                            <input type="radio" name="toppen" id="1" value="1">
                            <label for="1">
                                <div class="test">
                                    Chokolade
                                </div>
                            </label>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="square bg img7">
            <div class="content">
                <div class="table">
                    <div class="table-cell">
                        <div class="radio">
                            <input type="radio" name="toppen" id="2" value="2">
                            <label for="2">
                                <div class="test">
                                    Blåbær
                                </div>
                            </label>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="square bg img8">
            <div class="content">
                <div class="table">
                    <div class="table-cell">
                        <div class="radio">
                            <input type="radio" name="toppen" id="3" value="3">
                            <label for="3">
                                <div class="test">
                                    Hindbær
                                </div>
                            </label>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="square bg img9">
            <div class="content">
                <div class="table">
                    <div class="table-cell">
                        <div class="radio">
                            <input type="radio" name="toppen" id="4" value="4">
                            <label for="4">
                                <div class="test">
                                    Knas
                                </div>
                            </label>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="square bg img10">
            <div class="content">
                <div class="table">
                    <div class="table-cell">
                        <div class="radio">
                            <input type="radio" name="toppen" id="5" value="5">
                            <label for="5">
                                <div class="test">
                                    Jordbær
                                </div>
                            </label>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="square bg img11">
            <div class="content">
                <div class="table">
                    <div class="table-cell">
                        <div class="radio">
                            <input type="radio" name="toppen" id="6" value="6">
                            <label for="6">
                                <div class="test">
                                    Rom / rosin
                                </div>
                            </label>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="square bg img12">
            <div class="content">
                <div class="table">
                    <div class="table-cell">
                        <div class="radio">
                            <input type="radio" name="toppen" id="7" value="7">
                            <label for="7">
                                <div class="test">
                                    Appelsin
                                </div>
                            </label>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="square bg img13">
            <div class="content">
                <div class="table">
                    <div class="table-cell">
                        <div class="radio">
                            <input type="radio" name="toppen" id="8" value="8">
                            <label for="8">
                                <div class="test">
                                    Citron
                                </div>
                            </label>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <div class="square bg img14">
            <div class="content">
                <div class="table">
                    <div class="table-cell">
                        <div class="radio">
                            <input type="radio" name="toppen" id="9" value="9">
                            <label for="9">
                                <div class="test">
                                    Blue cheese
                                </div>
                            </label>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <br>
    <br>
    <br>
    <br><br>
    <br><br>
    <br>
    <h2 class="text-center">Vælg cupcake bund</h2>


    <div class="form-group">


        <div class="square bg img1">
            <div class="content">
                <div class="table">
                    <div class="table-cell">
                        <div class="radio">
                            <input type="radio" name="bunden" id="chokolade" value="chokolade">
                            <label for="chokolade">
                                <div class="test">
                                    Chokolade
                                </div>
                            </label>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <div class="square bg img2">
            <div class="content">
                <div class="table">
                    <div class="table-cell">
                        <div class="radio">
                            <input type="radio" name="bunden" id="vanilla" value="vanilla">
                            <label for="vanilla">
                                <div class="test">
                                    Vanilje
                                </div>
                            </label>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <div class="square bg img3">
            <div class="content">
                <div class="table">
                    <div class="table-cell">
                        <div class="radio">
                            <input type="radio" name="bunden" id="nutmeg"  value="nutmeg">
                            <label for="nutmeg">
                                <div class="test">
                                    Muskat
                                </div>
                            </label>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <div class="square bg img4">
            <div class="content">
                <div class="table">
                    <div class="table-cell">
                        <div class="radio">
                            <input type="radio" name="bunden" id="pistachio" value="pistachio">
                            <label for="pistachio">
                                <div class="test">
                                    Pistacie
                                </div>
                            </label>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <div class="square bg img5">
            <div class="content">
                <div class="table">
                    <div class="table-cell">
                        <div class="radio">
                            <input type="radio" name="bunden" id="almond"  value="Almond">
                            <label for="almond">
                                <div class="test">
                                    Mandel
                                </div>
                            </label>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="square">
        <div class="content">
            <div class="table">
                <div class="table-cell">

                </div>
            </div>
        </div>
    </div>

    <div class="col-md-4">

        <div class="form-group">
            <label for="count">Hvor mange af denne cupcake vil du have?</label>
            <input type="number" class="form-control" id="count" name="count">
        </div>

        <div class="text-center">
            <button type="submit" class="btn btn-primary">Tilføj til kurv</button>
        </div>
    </div>
    <br>
    <br>
</form>


<c:if test="${requestScope.error!= null}">

    <h2>Error ! </h2>
    ${requestScope.error}

</c:if>


<%@include file="../includes/footer.inc" %>

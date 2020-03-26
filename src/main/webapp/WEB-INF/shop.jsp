<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="../includes/header3.inc" %>


<h1 class="text-center">Velkommen til shoppen</h1>
<br>
<h2 class="text-center">Vælg cupcake top</h2>

<form action="FrontController" method="post">

    <input type="hidden" name="taget" value="home">


    <div class="form-group">
        <div class="square bg img6">
            <div class="content">
                <div class="table">
                    <div class="table-cell">
                        <div class="radio">
                            <input type="radio" name="toppen" id="chocolate" >
                            <label for="chocolate">
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
                            <input type="radio" name="toppen" id="blueberry">
                            <label for="blueberry">
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
                            <input type="radio" name="toppen" id="rasberry">
                            <label for="rasberry">
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
                            <input type="radio" name="toppen" id="crispy">
                            <label for="crispy">
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
                            <input type="radio" name="toppen" id="strawberry">
                            <label for="strawberry">
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
                            <input type="radio" name="toppen" id="rumraisin">
                            <label for="rumraisin">
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
                            <input type="radio" name="toppen" id="orange">
                            <label for="orange">
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
                            <input type="radio" name="toppen" id="lemon">
                            <label for="lemon">
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
                            <input type="radio" name="toppen" id="bluecheese">
                            <label for="bluecheese">
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
                            <input type="radio" name="bunden" id="choko">
                            <label for="choko">
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
                            <input type="radio" name="bunden" id="vanilla">
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
                            <input type="radio" name="bunden" id="nutmeg">
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
                            <input type="radio" name="bunden" id="pistachio">
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
                            <input type="radio" name="bunden" id="almond">
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
            <label for="amount">Hvor mange af denne cupcake vil du have?</label>
            <input type="number" class="form-control" id="amount" name="amount">
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

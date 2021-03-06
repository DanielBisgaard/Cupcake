<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<html lang="en">
<head>

    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->


    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="includes/style.css">

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Forside Olskers Cupcakes</title>
    <link href="https://fonts.googleapis.com/css?family=Varela+Round" rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style type="text/css">
        body{
            font-family: 'Varela Round', sans-serif;
        }
        ul.dropdown-cart{
            min-width:250px;
        }
        ul.dropdown-cart li .item{
            display:block;
            padding:3px 10px;
            margin: 3px 0;
        }
        ul.dropdown-cart li .item:hover{
            background-color:#f3f3f3;
        }
        ul.dropdown-cart li .item:after{
            visibility: hidden;
            display: block;
            font-size: 0;
            content: " ";
            clear: both;
            height: 0;
        }

        ul.dropdown-cart li .item-left{
            float:left;
        }
        ul.dropdown-cart li .item-left img,
        ul.dropdown-cart li .item-left span.item-info{
            float:left;
        }
        ul.dropdown-cart li .item-left span.item-info{
            margin-left:10px;
        }
        ul.dropdown-cart li .item-left span.item-info span{
            display:block;
        }
        ul.dropdown-cart li .item-right{
            float:right;
        }
        ul.dropdown-cart li .item-right button{
            margin-top:14px;
        }



        .form-control {
            box-shadow: none;
            font-weight: normal;
            font-size: 13px;
        }
        .form-control:focus {
            border-color: #33cabb;
            box-shadow: 0 0 8px rgba(0,0,0,0.1);
        }
        .navbar-header.col {
            padding: 0 !important;
        }
        .navbar {
            background: #fff;
            padding-left: 16px;
            padding-right: 16px;
            border-bottom: 1px solid #dfe3e8;
            border-radius: 0;
        }
        .nav-link img {
            border-radius: 50%;
            width: 36px;
            height: 36px;
            margin: -8px 0;
            float: left;
            margin-right: 10px;
        }
        .navbar .navbar-brand, .navbar .navbar-brand:hover, .navbar .navbar-brand:focus {
            padding-left: 0;
            font-size: 20px;
            padding-right: 50px;
        }
        .navbar .navbar-brand b {
            font-weight: bold;
            color: #33cabb;
        }
        .navbar .form-inline {
            display: inline-block;
        }
        .navbar .nav li {
            position: relative;
        }
        .navbar .nav li a {
            color: #888;
        }
        .search-box {
            position: relative;
        }
        .search-box input {
            padding-right: 35px;
            border-color: #dfe3e8;
            border-radius: 4px !important;
            box-shadow: none
        }
        .search-box .input-group-addon {
            min-width: 35px;
            border: none;
            background: transparent;
            position: absolute;
            right: 0;
            z-index: 9;
            padding: 7px;
            height: 100%;
        }
        .search-box i {
            color: #a0a5b1;
            font-size: 19px;
        }
        .navbar .nav .btn-primary, .navbar .nav .btn-primary:active {
            color: #fff;
            background: #33cabb;
            padding-top: 8px;
            padding-bottom: 6px;
            vertical-align: middle;
            border: none;
        }
        .navbar .nav .btn-primary:hover, .navbar .nav .btn-primary:focus {
            color: #fff;
            outline: none;
            background: #31bfb1;
        }
        .navbar .navbar-right li:first-child a {
            padding-right: 30px;
        }
        .navbar .nav-item i {
            font-size: 18px;
        }
        .navbar ul.nav li.active a, .navbar ul.nav li.open > a {
            background: transparent !important;
        }
        .navbar .nav .get-started-btn {
            min-width: 120px;
            margin-top: 8px;
            margin-bottom: 8px;
        }
        .navbar ul.nav li.open > a.get-started-btn {
            color: #fff;
            background: #31bfb1 !important;
        }

        .navbar .navbar-form {
            border: none;
        }


        .navbar .form-wrapper .hint-text {
            text-align: center;
            margin-bottom: 15px;
            font-size: 13px;
        }
        .navbar .form-wrapper .social-btn .btn, .navbar .form-wrapper .social-btn .btn:hover {
            color: #fff;
            margin: 0;
            padding: 0 !important;
            font-size: 13px;
            border: none;
            transition: all 0.4s;
            text-align: center;
            line-height: 34px;
            width: 47%;
            text-decoration: none;
        }
        .navbar .social-btn .btn-primary {
            background: #507cc0;
        }
        .navbar .social-btn .btn-primary:hover {
            background: #4676bd;
        }
        .navbar .social-btn .btn-info {
            background: #64ccf1;
        }
        .navbar .social-btn .btn-info:hover {
            background: #4ec7ef;
        }
        .navbar .social-btn .btn i {
            margin-right: 5px;
            font-size: 16px;
            position: relative;
            top: 2px;
        }
        .navbar .form-wrapper .form-footer {
            text-align: center;
            padding-top: 10px;
            font-size: 13px;
        }
        .navbar .form-wrapper .form-footer a:hover{
            text-decoration: underline;
        }
        .navbar .form-wrapper .checkbox-inline input {
            margin-top: 3px;
        }
        .or-seperator {
            margin-top: 32px;
            text-align: center;
            border-top: 1px solid #e0e0e0;
        }
        .or-seperator b {
            color: #666;
            padding: 0 8px;
            width: 30px;
            height: 30px;
            font-size: 13px;
            text-align: center;
            line-height: 26px;
            background: #fff;
            display: inline-block;
            border: 1px solid #e0e0e0;
            border-radius: 50%;
            position: relative;
            top: -15px;
            z-index: 1;
        }
        .navbar .checkbox-inline {
            font-size: 13px;
        }
        .navbar .navbar-right .dropdown-toggle::after {
            display: none;
        }
        @media (min-width: 1200px){
            .form-inline .input-group {
                width: 300px;
                margin-left: 30px;
            }
        }
        @media (max-width: 768px){
            .navbar .dropdown-menu.form-wrapper {
                width: 100%;
                padding: 10px 15px;
                background: transparent;
                border: none;
            }
            .navbar .form-inline {
                display: block;
            }
            .navbar .input-group {
                width: 100%;
            }
            .navbar .nav .btn-primary, .navbar .nav .btn-primary:active {
                display: block;
            }
        }



.square {
    float:left;
    position: relative;
    width: 30%;
    padding-bottom : 30%; /* = width for a 1:1 aspect ratio */
    margin:1.66%;
    background-color: #fff;
    overflow:hidden;
}


.content {
    position:absolute;
    height:90%; /* = 100% - 2*5% padding */
    width:90%; /* = 100% - 2*5% padding */
    padding: 5%;

}
.table{
    display:table;
    width:100%;
    height:100%;
}
.table-cell{
    display:table-cell;
    vertical-align:top;
}

/*  For responsive images */

.content .rs{
    width:auto;
    height:auto;
    max-height:90%;
    max-width:100%;
}
/*  For responsive images as background */

.bg{
    background-position:center center;
    background-repeat:no-repeat;
    background-size:cover; /* you change this to "contain" if you don't want the images to be cropped */
    color:#fff;
}




.img1{
    background-image: url("images/chocolate.jfif");
}
.img2{
    background-image: url("images/vanilla.png");
}
.img3{
    background-image: url("images/nutmeg.jfif");
}
.img4{
    background-image: url("images/pistachio.jfif");
}
.img5{
    background-image: url("images/almond.jfif");
}
.img6{
    background-image: url("images/chocolate2.jfif");
}
.img7{
    background-image: url("images/blueberry.jfif");
}
.img8{
    background-image: url("images/rasberry.jfif");
}
.img9{
    background-image: url("images/crispy.jfif");
}
.img10{
    background-image: url("images/strawberry.jfif");
}
.img11{
    background-image: url("images/rum_raisin.jfif");
}
.img12{
    background-image: url("images/orange.png");
}
.img13{
    background-image: url("images/lemon.jfif");
}
.img14{
    background-image: url("images/bluecheese.jfif");
}

input[type="radio"] {
  border: 0;
  clip: rect(0 0 0 0);
  height: 5px;
  margin: -1px;
  overflow: hidden;
  padding: 0;
  position: absolute;
  width: 5px;
}
.radio label:before {
  content: "";
  display: inline-block;
  width: 0.5em;
  height: 0.5em;
  margin-right: 0.5em;
  border-radius: 100%;
  vertical-align: -3px;
  border: 2px solid #000;
  padding: 0.13em;
  background-color: transparent;
  background-clip: content-box;
}
.radio label {
  margin-right: 1em;
}
.radio input:hover + label:before {
  border-color: blue;
}
.radio input:checked + label:before {
  background-color: #3dbfef;
  border-color: #3dbfef;
}
.radio label:before {
  -webkit-transition: all 0.2s ease;
  transition: all 0.2s ease;
}
div.test
{
width: 115px;
padding: 10px;
border: 2px solid #000;
border-radius: 15px;
-moz-border-radius: 15px;
background-color: #3dbfef;
border-color: #3dbfef;
}


    </style>
    <script type="text/javascript">
        // Prevent dropdown menu from closing when click inside the form
        $(document).on("click", ".navbar-right .dropdown-menu", function(e){
            e.stopPropagation();
        });


    </script>
</head>
<body>
<nav class="navbar navbar-default navbar-expand-lg navbar-light">
    <div class="navbar-header d-flex col">
        <a class="navbar-brand" href="FrontController?taget=home">Olskers<b>Cupcakes</b></a>
        <button type="button" data-target="#navbarCollapse" data-toggle="collapse" class="navbar-toggle navbar-toggler ml-auto">
            <span class="navbar-toggler-icon"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
    </div>
    <!-- Collection of nav links, forms, and other content for toggling -->
    <div id="navbarCollapse" class="collapse navbar-collapse justify-content-start">
        <ul class="nav navbar-nav">

                <li class="nav-item"><a href="FrontController?taget=home" class="nav-link">Home</a></li>

                <li class="nav-item"><a href="FrontController?taget=about" class="nav-link">About</a></li>

                <li class="nav-item active"><a href="FrontController?taget=shop" class="nav-link">Shop</a></li>

                <li class="nav-item active"><a href="FrontController?taget=${sessionScope.role}page" class="nav-link">Din side</a></li>
        </ul>


            <ul class="nav navbar-nav navbar-right ml-auto">
                    <li class="nav-item">
                    <li class="nav-item active"><a href="FrontController?taget=home" class="nav-link">${sessionScope.email}</a></li>
                    </li>
            </ul>

        <ul class="nav navbar-nav navbar-right">
            <li class="nav-item">
                <li class="nav-item active"><a href="FrontController?taget=kurv" role="button" aria-expanded="false"> <div class="glyphicon glyphicon-shopping-cart"></div></a></li>

            </li>
        </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li class="nav-item">
                        <li class="nav-item active"><a href="FrontController?taget=logud" class="nav-link">Log ud</a></li>

                    </li>
                </ul>
     </div><!-- /.navbar-collapse -->
     </div><!-- /.container-fluid -->
   </nav>


    </div>
</nav>

<div class="container">
<p style="text-align:center;"><img src="images/olskercupcakes.jpg" style="max-width:100%;height:auto; alt="Olskers Cupcakes" class></p>


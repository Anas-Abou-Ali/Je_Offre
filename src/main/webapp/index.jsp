<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>J'Offre</title>
    <link href="css/index.css" rel="stylesheet" >
    <%@ include file="WEB-INF/bootstrapIncludes.jsp" %>


</head>
<body style="background-color: #FFFFFF;">
<%@ include file="WEB-INF/header.jsp" %>
<div class="jumbotron jumbotron-fluid" style="background-image: url('css/bg.jpg');background-size: cover;background-repeat: no-repeat;">
    <div class="container">
        <h1 class="display-4">J'offre :</h1>
        <p class="lead" style="color: white"> De même que le fleuve retourne à la mer, le don de l'homme revient vers lui. </p>
    </div>
</div>
<div class="container h-100">
        <div class="row h-100 justify-content-center align-items-center">
            <form action="offers" method="GET" >
                <div class="row">
                            <div class="col-lg-6 col-md-6 col-sm-12 p-0">
                                <input type="text" name="search" class="form-control search-slt" placeholder="Rechercher . . ." style="border-radius: .25rem 0 0 .25rem;">
                            </div>
                            <div class="col-lg-3 col-md-3 col-sm-12 p-0">
                                <select class="form-control search-slt" name="city" id="exampleFormControlSelect1" style="border-radius: 0 0 0 0;">
                                    <option value="0">Tout le Maroc</option>
                                    <option value="1">Rabat</option>
                                    <option value="2">Casablanca</option>
                                    <option value="3">Marrakech</option>
                                    <option value="4">Tanger</option>
                                    <option value="5">Fès</option>
                                    <option value="6">Meknès</option>
                                    <option value="7">Agadir</option>
                                    <option value="8">Essaouira</option>
                                    <option value="9">Tetouan</option>
                                    <option value="10">El Jadida</option>
                                    <option value="11">Oujda</option>
                                    <option value="12">Safi</option>
                                    <option value="13">Kenitra</option>
                                    <option value="14">Salé</option>
                                    <option value="15">Beni Mellal</option>
                                    <option value="16">Nador</option>
                                </select>
                            </div>
                            <div class="col-lg-3 col-md-3 col-sm-12 p-0">
                                <button  type="submit button" class="btn wrn-btn" style="border-radius: 0 .25rem .25rem 0;"><i class="fa fa-search fa-lg" aria-hidden="true"></i></button>
                            </div>
                </div>
                <div class="row categories">
                                <div class="col-md-4 card">
                                    <a href="offers?category=0">
                                        <div class="card-inner p-3 d-flex flex-column align-items-center"> <img src="css/all.png" width="40">
                                            <div class="text-center mg-text"> <span class="mg-text">Toutes Les Catégories</span> </div>
                                        </div>
                                    </a>
                                </div>
                                <div class="col-md-4 card">
                                    <a href="offers?category=1">
                                        <div class="card-inner p-3 d-flex flex-column align-items-center"> <img src="css/furniture.png" width="40">
                                            <div class="text-center mg-text"> <span class="mg-text">électroménagers et meubles</span> </div>
                                        </div>
                                    </a>
                                </div>
                                <div class="col-md-4 card">
                                    <a href="offers?category=2">
                                        <div class="card-inner p-3 d-flex flex-column align-items-center"> <img src="css/tshirt.png" width="40">
                                            <div class="text-center mg-text"> <span class="mg-text">vêtements</span> </div>
                                        </div>
                                    </a>
                                </div>
                                <div class="col-md-4  card">
                                    <a href="offers?category=3">
                                        <div class="card-inner p-3 d-flex flex-column align-items-center"> <img src="css/electronics.png" width="40">
                                            <div class="text-center mg-text"> <span class="mg-text">electroniques</span> </div>
                                        </div>
                                    </a>
                                </div>
                                <div class="col-md-4 card">
                                    <a href="offers?category=4">
                                        <div class="card-inner p-3 d-flex flex-column align-items-center"> <img src="css/tools.png" width="40">
                                            <div class="text-center mg-text"> <span class="mg-text">outils</span> </div>
                                        </div>
                                    </a>
                                </div>
                                <div class="col-md-4 card">
                                    <a href="offers?category=5">
                                        <div class="card-inner p-3 d-flex flex-column align-items-center"> <img src="css/sport.png" width="40">
                                            <div class="text-center mg-text"> <span class="mg-text">sport</span> </div>
                                        </div>
                                    </a>
                                </div>
                                <div class="col-md-4 card">
                                    <a href="offers?category=6">
                                        <div class="card-inner p-3 d-flex flex-column align-items-center"> <img src="css/file.png" width="40">
                                            <div class="text-center mg-text"> <span class="mg-text">autre...</span> </div>
                                        </div>
                                    </a>
                                </div>
                </div>
            </form>
        </div>
</div>



        <%@ include file="WEB-INF/bootstrapIncludeLast.jsp" %>
    <div>
        <%@ include file="WEB-INF/footer.jsp" %>
    </div>
</body>
</html>

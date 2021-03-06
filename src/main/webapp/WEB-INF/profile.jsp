<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>J'Offre</title>
    <link href="css/chat.css" rel="stylesheet">
    <%@ include file="bootstrapIncludes.jsp" %>

</head>
<body style=" min-height: 100vh;">
<%@ include file="header.jsp" %>



<div class="container">

    <h2 class="font-weight-bold mb-2" style="margin-top: 50px;">Mes Offres</h2>
    <p class="font-italic text-muted mb-4">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt.</p>
    <div class="row pb-5 mb-4">

        <c:forEach items="${user.offers}" var="offer">
            <div class="col-lg-3 col-md-6 mb-4 mb-lg-0">
                <!-- Card-->
                    <div class="card rounded shadow-sm border-0" style="background: #fafafa;">
                        <div class="card-body p-4"><img src="uploads/${offer.photos[0].getPathToImage()}" alt="" class="img-fluid d-block mx-auto mb-3">
                            <h5> <a href="#" class="text-dark">${offer.titre}</a></h5>
                            <p class="small text-muted font-italic">${offer.description}</p>
                            <ul class="list-inline small">
                                <i class="fa fa-clock-o" aria-hidden="true">  <fmt:formatDate value="${offer.date}" pattern="dd/MM/yyyy HH:mm"/></i>
                                <span style="margin-left: 40%;"></span>
                                <a href="rem?my=${offer.offerId}"><i class="fa fa-trash-o fa-lg" aria-hidden="true"></i></a>
                            </ul>
                        </div>
                    </div>
            </div>
        </c:forEach>
    </div>

    <h2 class="font-weight-bold mb-2">Ma liste de suivi</h2>
    <p class="font-italic text-muted mb-4">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt.</p>
    <div class="row pb-5 mb-4">

        <c:forEach items="${user.favorites}" var="offer">
            <div class="col-lg-3 col-md-6 mb-4 mb-lg-0">
                <!-- Card-->
                <div class="card rounded shadow-sm border-0" style="background: #fafafa;">
                    <div class="card-body p-4"><img src="uploads/${offer.photos[0].getPathToImage()}" alt="" class="img-fluid d-block mx-auto mb-3">
                        <h5> <a href="#" class="text-dark">${offer.titre}</a></h5>
                        <p class="small text-muted font-italic">${offer.description}</p>
                        <ul class="list-inline small">
                            <i class="fa fa-clock-o" aria-hidden="true">  <fmt:formatDate value="${offer.date}" pattern="dd/MM/yyyy HH:mm"/></i>
                            <span style="margin-left: 40%;"></span>
                            <a href="rem?fav=${offer.offerId}"> <i class="fa fa-trash-o fa-lg" aria-hidden="true"></i></a>
                        </ul>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>


    <h2 class="font-weight-bold mb-2">Dernier demandeurs</h2>
    <p class="font-italic text-muted mb-4">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt.</p>
    <c:forEach items="${demanders}" var="demander">
        <div class="row">
                 ${demander.idUser}  ${demander.firstName}
        </div>
    </c:forEach>













<h3>DEMANDERS</h3>


<form action="profile" method="POST">
    <label for="idDemander">répondre à une demande</label>
    <select id="idDemander" name="idDemander">
        <c:forEach items="${demanders}" var="demander">
            <option value="${demander.idUser}">${demander.firstName} </option>
        </c:forEach>
    </select>
    <button type="submit button" class="btn btn-primary"> répondre </button>
</form>

<h3>DEMANDER selected messages</h3>
<c:forEach items="${chat}" var="mess">
    <p>${mess.message}</p>
</c:forEach>

</div>
<%@ include file="bootstrapIncludeLast.jsp" %>
<div>
    <%@ include file="footer.jsp" %>
</div>

</body>
</html>

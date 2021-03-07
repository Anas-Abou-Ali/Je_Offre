<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>J'Offre</title>
    <link href="css/chat.css" rel="stylesheet">
    <link href="css/profile.css" rel="stylesheet">
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






    <h2 class="font-weight-bold mb-2">Demandeurs récents</h2>
    <p class="font-italic text-muted mb-4">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt.</p>

    <div class="row rounded-lg overflow-hidden shadow">
        <!-- Users box-->
        <div class="col-5 px-0">
            <div class="bg-white">

                <div class="bg-gray px-4 py-2 bg-light">
                    <p class="h5 mb-0 py-1">Récent</p>
                </div>

                <div class="messages-box">
                    <div class="list-group rounded-0">

                        <c:forEach items="${demanders}" var="demander">
                            <a href="profile?id=${demander.idUser}" class="list-group-item list-group-item-action list-group-item-light rounded-0">
                                <div class="media">
                                    <div class="media-body ml-4">
                                        <div class="d-flex align-items-center justify-content-between mb-1">
                                            <h6 class="mb-0"><c:out value="${demander.firstName}" /></h6><small class="small font-weight-bold">14 Dec</small>
                                        </div>
                                        <p class="font-italic text-muted mb-0 text-small">Lorem ipsum dolor sit amet, consectetur. incididunt ut labore.</p>
                                    </div>
                                </div>
                            </a>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
        <!-- Chat Box-->
        <div class="col-7 px-0">
            <div class="px-4 py-5 chat-box bg-white">
                <c:forEach items="${chat}" var="mess">
                    <c:choose>
                        <c:when test="${mess.senderId == user.idUser}">
                            <!-- Reciever Message-->
                            <div class="media w-50 ml-auto mb-3">
                                <div class="media-body">
                                    <div class="bg-primary rounded py-2 px-3 mb-2">
                                        <p class="text-small mb-0 text-white">${mess.message}</p>
                                    </div>
                                    <p class="small text-muted"><fmt:formatDate value="${mess.dateMessage}" pattern="HH:mm | dd/MM"/></p>
                                </div>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <!-- Sender Message-->
                            <div class="media w-50 mb-3"><img src="https://res.cloudinary.com/mhmd/image/upload/v1564960395/avatar_usae7z.svg" alt="user" width="50" class="rounded-circle">
                                <div class="media-body ml-3">
                                    <div class="bg-light rounded py-2 px-3 mb-2">
                                        <p class="text-small mb-0 text-muted">${mess.message}</p>
                                    </div>
                                    <p class="small text-muted"><fmt:formatDate value="${mess.dateMessage}" pattern="HH:mm | dd/MM"/></p>
                                </div>
                            </div>
                        </c:otherwise>
                    </c:choose>

                </c:forEach>
            </div>

            <!-- Typing area -->
            <form action="profile?id=${offerDemanderId}" method="POST" class="bg-light">
                <div class="input-group">
                    <input name="demander" id="demander" type="hidden" value="${offerDemanderId}"/>
                    <input name="message" id="message" type="text" placeholder="Type a message" aria-describedby="button-addon2" class="form-control rounded-0 border-0 py-4 bg-light">
                    <div class="input-group-append">
                        <button id="button-addon2" type="submit" class="btn btn-link"> <i class="fa fa-paper-plane"></i></button>
                    </div>
                </div>
            </form>

        </div>
    </div>


</div>
<%@ include file="bootstrapIncludeLast.jsp" %>
<div>
    <%@ include file="footer.jsp" %>
</div>

</body>
</html>

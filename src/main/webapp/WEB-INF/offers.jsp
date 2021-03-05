<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>J'Offre.ma</title>
    <%@ include file="bootstrapIncludes.jsp" %>
</head>
<body>
        <%@ include file="header.jsp" %>
                <main>
                    <div class="container my-5">
                        <div class="row">
                            <div class="col-md-1"></div>
                            <div class="col-md-7">
                                <c:forEach var="offer" items="${offers}" varStatus="status">
                                <section class="newsfeed my-5">
                                    <div class="post">
                                        <div class="card">
                                            <div class="card-body">
                                                <div class="container">
                                                    <!--auteur -->
                                                    <div class="row">
                                                        <div class="col-md-8">
                                                            <div class="d-flex story">
<%--                                                                <img href="/Anas_Abou_Ali" src="logo_don.jpg" class="rounded-circle" width="40" height="40" alt="Avatar"/>--%>
                                                                <div class="md-2">
                                                                    <a href="offer?off=${offer.offerId}">
                                                                        <strong class="mt-5 ml-2">${offer.titre}</strong>
                                                                    </a>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>

                                            <!--l'offre-->
                                            <div class="bg-image hover-overlay ripple shadow-1-strong rounded"
                                                 data-mdb-ripple-color="light">
                                                <c:if test="${!empty offer.photos}"> <img src="uploads/${offer.photos[0].getPathToImage()}" class="w-100" />
                                                    <a href="#!">
                                                        <div class="mask" style="background-color: rgba(251, 251, 251, 0.2)"></div>
                                                    </a>
                                                </c:if>
                                            </div>
                                            <!-- Interactions -->
                                            <div  class="card-body">
                                                <div class="container">
                                                    <div class="row">
                                                        <div class="col-md-8">
                                                            <i class="fa fa-heart fa-lg ml-0"></i>
                                                            <i class="fa fa-heart fa-lg ml-0"></i>
                                                        </div>
                                                        <div class="col-md-4 text-right">
                                                            <i class="fa fa-paper-plane fa-lg"></i>
                                                        </div>
                                                    </div>
                                                    <!-- Liked by -->
<%--                                                    <div class="row">--%>
<%--                                                        <div class="col-md-8 mt-1">--%>
<%--                                                            <img href="/Anas_Abou_Ali" src="logo_don.jpg" class="rounded-circle" width="20" height="20" alt="Avatar"/>--%>
<%--                                                            <small>Aimee par <strong>4232 </strong>people</small>--%>
<%--                                                        </div>--%>
<%--                                                    </div>--%>
                                                    <!-- Description -->
                                                    <div class="row">
                                                        <div class="col-md-12 mt-1">
                                                            <p>
                                                                <strong class="text-dark">
                                                                    Description :
                                                                </strong> <c:out value="${offer.description}"/>
                                                            </p>
                                                        </div>

                                                    </div>
<%--                                                    <!-- Comments -->--%>
<%--                                                    <div class="row">--%>
<%--                                                        <!-- Visualisee tout les comentaire -->--%>
<%--                                                    </div>--%>
<%--                                                    <!-- Ajouter un commentair -->--%>
<%--                                                    <hr />--%>
<%--                                                    <div class="row mt-2">--%>
<%--                                                        <div class="col-md-11">--%>
<%--                                                            <div class="form-outline">--%>
<%--                                                                <input type="text" id="form1" class="form-control" placeholder="Ajouter un commentaire" />--%>
<%--                                                            </div>--%>
<%--                                                        </div>--%>
<%--                                                        <div class="col-md-1">--%>
<%--                                                            <p class="text-info mt-1">Publier</p>--%>
<%--                                                        </div>--%>
<%--                                                    </div>--%>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </section>
                                </c:forEach>
                            </div>
                            <div class="col-md-2 mt-40">
                                <table width="275"  border="3" cellpadding="3" bordercolor="darkorange">
                                    <td><div align="center"></div></td>
                                </table>
                            </div>
                        </div>
                    </div>
                </main>
        <%@ include file="bootstrapIncludeLast.jsp" %>
        <div>
            <%@ include file="footer.jsp" %>
        </div>

</body>
</html>

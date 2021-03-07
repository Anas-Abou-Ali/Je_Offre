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
                            <div class="offset-1">${noticeMessage}</div>
                            <span class="border-top"></span>
                        </div>

                        <div class="row">
                            <div class="col-md-1"></div>
                            <div class="col-md-7">
                                <c:forEach var="offer" items="${offers}" varStatus="status">
                                <section class="newsfeed my-5">
                                    <div class="post">
                                        <div class="card">
                                            <div class="card-body">
                                                <div class="container">
                                                    <!--Title -->
                                                    <div class="row">
                                                        <div class="col-md-8">
                                                            <div class="d-flex story">
                                                                <div class="md-2">
                                                                    <a href="offer?off=${offer.offerId}" >
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
                                                    <!-- Description -->
                                                    <div class="row">
                                                        <div class="col-md-12">
                                                            <p><c:out value="${offer.description}"/></p>
                                                            <div class="d-flex justify-content-between mt-5">
                                                                <i class="fa fa-clock-o" aria-hidden="true">  <fmt:formatDate value="${offer.date}" pattern="dd/MM/yyyy HH:mm"/></i>
                                                                <span style="margin-left: 20%;"></span>
                                                                <i class="fa fa-street-view" aria-hidden="true"> ${City[offer.city]} </i>
                                                                <i class="fa fa-tag" aria-hidden="true"> ${Category[offer.category]} </i>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </section>
                                </c:forEach>
                            </div>
                            <div class="col-md-2 mt-40">
<%--                                <table width="275"  border="3" cellpadding="3" bordercolor="darkorange">--%>
<%--                                    <td><div align="center"></div></td>--%>
<%--                                </table>--%>
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

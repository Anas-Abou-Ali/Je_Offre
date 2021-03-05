<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>J'Offre</title>
    <link href="css/chat.css" rel="stylesheet">
    <link href="css/offerDetail.css" rel="stylesheet">
    <%@ include file="bootstrapIncludes.jsp" %>

</head>
<body>
<%@ include file="header.jsp" %>



<div class="container" style="padding: 50px;">
    <div class="card">
        <div class="wrapper row">
            <div class="preview col-md-6">
                <div class="preview-pic tab-content">
                    <div class="tab-pane active" id="pic-1"><img src="uploads/${offer.photos[0].getPathToImage()}" /></div>
                </div>
            </div>
            <div class="details col-md-6">
                <h3 class="product-title">${offer.titre}</h3>
                <div class="rating">
                    <span class="review-no">par : ${offer.userFirstName}</span>
                </div>
                <p class="product-description">${offer.description}</p>
                <p class="vote"><strong>91%</strong> of buyers enjoyed this product! <strong>(87 votes)</strong></p>

                <div class="action">
                    <button class="add-to-cart btn btn-default" type="button">ajouter à ma list de suivi</button>
                    <button class="like btn btn-default" type="button"><span class="fa fa-heart"></span></button>
                </div>
            </div>
        </div>
    </div>
</div>



<%--<div class="row">--%>
<%--    <div class="col-sm-3"></div>--%>
<%--    <div class="col-sm-6">--%>

<%--        <p>--%>
<%--         <H1> ${offer.titre}</H1>--%>
<%--            <br/>--%>
<%--            <h2>Giver : ${offer.userFirstName}</h2>--%>
<%--        <c:if test="${!empty offer.photos}"> <img src="uploads/${offer.photos[0].getPathToImage()}" class="w-100" />--%>
<%--            <a href="#!">--%>
<%--                <div class="mask" style="background-color: rgba(251, 251, 251, 0.2)"></div>--%>
<%--            </a>--%>
<%--        </c:if>--%>
<%--    <h2>Description : </h2>   ${offer.description}--%>
<%--        </p>--%>



<%--        <!-- chat pop up button-->--%>
<%--        <button id="addClass" class="btn btn-primary">--%>
<%--            <i class="fa fa-commenting fa-lg" aria-hidden="true"></i>--%>
<%--        </button>--%>

<%--        <c:forEach items="${chat}" var="message" >--%>
<%--                    ${message.message}--%>
<%--        </c:forEach>--%>

<%--    </div>--%>
<%--    <div class="col-sm-3"></div>--%>
<%--</div>--%>




<%@ include file="chat.jsp" %>



<%@ include file="bootstrapIncludeLast.jsp" %>
<div>
    <%@ include file="footer.jsp" %>
</div>

</body>
</html>

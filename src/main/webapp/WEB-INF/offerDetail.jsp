<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>J'Offre</title>
    <link href="css/chat.css" rel="stylesheet">
    <%@ include file="bootstrapIncludes.jsp" %>

</head>

<%@ include file="header.jsp" %>
<div class="row">
    <div class="col-sm-3"></div>
    <div class="col-sm-6">

        <p>
         <H1> ${offer.titre}</H1>
            <br/>
            <h2>Giver : ${offer.userFirstName}</h2>
        <c:if test="${!empty offer.photos}"> <img src="uploads/${offer.photos[0].getPathToImage()}" class="w-100" />
            <a href="#!">
                <div class="mask" style="background-color: rgba(251, 251, 251, 0.2)"></div>
            </a>
        </c:if>
    <h2>Description : </h2>   ${offer.description}
        </p>



        <!-- chat pop up button-->
        <button id="addClass" class="btn btn-primary">
            <i class="fa fa-commenting fa-lg" aria-hidden="true"></i>
        </button>

        <c:forEach items="${chat}" var="message" >
                    ${message.message}
        </c:forEach>

    </div>
    <div class="col-sm-3"></div>
</div>
<%@ include file="chat.jsp" %>



<%@ include file="bootstrapIncludeLast.jsp" %>
<div>
    <%@ include file="footer.jsp" %>
</div>

</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>J'Offre</title>
    <link href="css/chat.css" rel="stylesheet">
    <%@ include file="bootstrapIncludes.jsp" %>

</head>

<%@ include file="header.jsp" %>

<p>
    ${offer.titre}
    <c:if test="${!empty offer.photos}">
        img: ${offer.photos[0].pathToImage}
    </c:if>
</p>




<!-- chat pop up button-->
<button id="addClass" class="btn btn-primary">
    <i class="fa fa-commenting fa-lg" aria-hidden="true"></i>
</button>

<c:forEach items="${chat}" var="message" >
            ${message.message}
</c:forEach>

<%@ include file="chat.jsp" %>



<%@ include file="bootstrapIncludeLast.jsp" %>
<div>
    <%@ include file="footer.jsp" %>
</div>

</body>
</html>

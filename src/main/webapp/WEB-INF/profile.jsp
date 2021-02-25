<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>J'Offre</title>
    <link href="css/chat.css" rel="stylesheet">
    <%@ include file="bootstrapIncludes.jsp" %>

</head>
<%@ include file="header.jsp" %>

${user.firstName}
<h3>Mes offres</h3>
<c:forEach items="${user.offers}" var="offer">
    ${offer.titre}
</c:forEach>


<h3>Mes favorites</h3>
<c:forEach items="${user.favorites}" var="offer">
    ${offer.titre}
</c:forEach>



<h3>DEMANDERS</h3>


<c:forEach items="${demanders}" var="demander">
    ${demander.firstName}
</c:forEach>




<%@ include file="bootstrapIncludeLast.jsp" %>
<div>
    <%@ include file="footer.jsp" %>
</div>

</body>
</html>

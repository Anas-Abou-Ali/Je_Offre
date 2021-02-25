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


<%@ include file="bootstrapIncludeLast.jsp" %>
<div>
    <%@ include file="footer.jsp" %>
</div>

</body>
</html>

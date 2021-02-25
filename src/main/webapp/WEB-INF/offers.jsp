<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>J'Offre.ma</title>
    <%@ include file="bootstrapIncludes.jsp" %>

</head>
    <body>
        <%@ include file="header.jsp" %>


        <c:forEach var="offer" items="${offers}" varStatus="status">
            <a href="offer?off=${offer.offerId}">
                <c:out value="${offer.titre} ${  status.count }"/>
            </a>
        </c:forEach>

        <p>${test}
        </p>




        <%@ include file="bootstrapIncludeLast.jsp" %>
        <div>
            <%@ include file="footer.jsp" %>
        </div>

    </body>
</html>

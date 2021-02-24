<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<>
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
</p>


<!-- chat pop up button-->
<button id="addClass" class="btn btn-primary">
    <i class="fa fa-commenting fa-lg" aria-hidden="true"></i>
</button>
<%@ include file="chat.jsp" %>



<%@ include file="bootstrapIncludeLast.jsp" %>
<div>
    <%@ include file="footer.jsp" %>
</div>

</body>
</html>

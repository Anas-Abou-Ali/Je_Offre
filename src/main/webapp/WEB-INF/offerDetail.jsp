<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>J'Offre</title>
    <link href="css/chat.css" rel="stylesheet">
    <%@ include file="bootstrapIncludes.jsp" %>

</head>
<body>
<%@ include file="header.jsp" %>

<p>
    ${offer.titre}
</p>


<button id="addClass" class="btn btn-primary">
    <i class="fa fa-commenting fa-lg" aria-hidden="true"></i>
</button>




<div class="popup-box chat-popup" id="chat">
    <div class="popup-head">
        <div class="popup-head-left pull-left"><c:out value="${offer.userFirstName}" /> </div>
        <div class="popup-head-right pull-right">
            <button data-widget="remove" id="removeClass" class="chat-header-button pull-right" type="button"><i class="fa fa-times" aria-hidden="true"></i></button>
        </div>
    </div>
    <div class="popup-messages">

        <div class="direct-chat-messages">


            <div class="chat-box-single-line">
                <abbr class="timestamp">October 8th, 2015</abbr>
            </div>


            <!-- Message. Default to the left -->
            <div class="direct-chat-msg doted-border">
                <div class="direct-chat-info clearfix">
                    <span class="direct-chat-name pull-left">Osahan</span>
                </div>
                <!-- /.direct-chat-info -->
                <img alt="message user image" src="http://bootsnipp.com/img/avatars/bcf1c0d13e5500875fdd5a7e8ad9752ee16e7462.jpg" class="direct-chat-img"><!-- /.direct-chat-img -->
                <div class="direct-chat-text">
                    Hey bro, how’s everything going ?
                </div>
                <div class="direct-chat-info clearfix">
                    <span class="direct-chat-timestamp pull-right">3.36 PM</span>
                </div>
                <div class="direct-chat-info clearfix">
						<span class="direct-chat-img-reply-small pull-left">

						</span>
                    <span class="direct-chat-reply-name">Singh</span>
                </div>
                <!-- /.direct-chat-text -->
            </div>
            <!-- /.direct-chat-msg -->


            <div class="chat-box-single-line">
                <abbr class="timestamp">October 9th, 2015</abbr>
            </div>



            <!-- Message. Default to the left -->
            <div class="direct-chat-msg doted-border">
                <div class="direct-chat-info clearfix">
                    <span class="direct-chat-name pull-left">Osahan</span>
                </div>
                <!-- /.direct-chat-info -->
                <img alt="iamgurdeeposahan" src="http://bootsnipp.com/img/avatars/bcf1c0d13e5500875fdd5a7e8ad9752ee16e7462.jpg" class="direct-chat-img"><!-- /.direct-chat-img -->
                <div class="direct-chat-text">
                    Hey bro, how’s everything going ?
                </div>
                <div class="direct-chat-info clearfix">
                    <span class="direct-chat-timestamp pull-right">3.36 PM</span>
                </div>
                <div class="direct-chat-info clearfix">
                    <img alt="iamgurdeeposahan" src="http://bootsnipp.com/img/avatars/bcf1c0d13e5500875fdd5a7e8ad9752ee16e7462.jpg" class="direct-chat-img big-round">
                    <span class="direct-chat-reply-name">Singh</span>
                </div>
            </div>
        </div>
    </div>
    <div class="popup-messages-footer">
        <form action="offer?off=${offer.offerId}" method="POST">
            <input name="idUser" id="idUser" type="hidden" value="${offer.idUser}"/>
            <textarea id="status_message" placeholder="message..." rows="10" cols="40" name="message"></textarea>
            <button class="btn btn-primary" type="submit"><i class="fa fa-paper-plane fa-sm"></i> </button>
        </form>
    </div>
</div>





<%@ include file="bootstrapIncludeLast.jsp" %>
<div>
    <%@ include file="footer.jsp" %>
</div>

</body>
</html>

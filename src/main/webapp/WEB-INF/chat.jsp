
<div class="popup-box chat-popup" id="chat">
    <div class="popup-head">
        <div class="popup-head-left pull-left"><c:out value="${offer.userFirstName}" /> </div>
        <div class="popup-head-right pull-right">
            <button data-widget="remove" id="removeClass" class="chat-header-button pull-right" type="button"><i class="fa fa-times" aria-hidden="true"></i></button>
        </div>
    </div>
    <div class="popup-messages">
        <div class="direct-chat-messages">
                <c:forEach items="${chat}" var="message" >
                    <c:choose>
                        <c:when test="${message.senderId == sessionScope.user.idUser}">
                            <div class="direct-chat-text send-receive-margin-left">
                                    ${message.message}
                            </div>
                            <div class="direct-chat-info clearfix">
                                <span class="direct-chat-timestamp pull-right">3.36 PM</span>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div class="direct-chat-text send-receive-margin-right">
                                    ${message.message}
                            </div>
                            <div class="direct-chat-info clearfix">
                                <span class="direct-chat-timestamp pull-right">3.36 PM</span>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
        </div>
    </div>
    <div class="popup-messages-footer">
        <form action="offer?off=${offer.offerId}" method="POST">
            <input name="offerOwner" id="offerOwner" type="hidden" value="${offer.idUser}"/>
            <textarea class="message-text" id="status_message" placeholder="message..." name="message"></textarea>
            <button class="btn btn-primary btn-sendmessage" type="submit"><i class="fa fa-paper-plane fa-sm"></i> </button>
        </form>
    </div>
</div>

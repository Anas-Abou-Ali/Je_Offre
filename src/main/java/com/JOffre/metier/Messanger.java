package com.JOffre.metier;

import com.JOffre.Model.Message;
import com.JOffre.Model.User;
import com.JOffre.dao.IMessageDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Messanger {
    private static final String ATT_SESSION_USER  = "user";
    private static final String FIELD_ID_USER     = "idUser";
    private static final String FIELD_MESSAGE       = "message";


    public Message sendMessage(HttpServletRequest request, IMessageDao messages){
        Message message = new Message();

        User user = (User) request.getSession().getAttribute( ATT_SESSION_USER );
        message.setReceiverId( request.getParameter( FIELD_ID_USER ) );
        message.setSenderId( user.getIdUser() );
        message.setMessage( request.getParameter( FIELD_MESSAGE ) );

        message = messages.create(message);
        return message;
    }
}

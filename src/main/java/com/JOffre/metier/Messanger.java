package com.JOffre.metier;

import com.JOffre.Model.Message;
import com.JOffre.Model.User;
import com.JOffre.dao.DaoException;
import com.JOffre.dao.IMessageDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Messanger {
    private static final String ATT_SESSION_USER  = "user";
    private static final String FIELD_OFFER_OWNER = "offerOwner";
    private static final String FIELD_MESSAGE     = "message";

    private Map<String, String> errors            = new HashMap<String, String>();

    public Map<String, String> getErrors() {
        return errors;
    }
    //adding errors
    private void setError( String field, String message ) {
        errors.put( field, message );
    }



    public Message sendMessage(HttpServletRequest request, IMessageDao messages){
        Message message = new Message();

        try{
            User user = (User) request.getSession().getAttribute( ATT_SESSION_USER );
            message.setReceiverId( request.getParameter( FIELD_OFFER_OWNER ) );
            message.setSenderId( user.getIdUser() );
            message.setMessage( request.getParameter( FIELD_MESSAGE ) );
        }catch (Exception e){
            setError(FIELD_MESSAGE, "authentication error error ");
        }
        try{
            message = messages.create(message);
        }catch (DaoException e){
            setError( FIELD_MESSAGE, "message creation error");
        }
        return message;
    }

    public List<Message> receive(HttpServletRequest request, IMessageDao messageDao, String offerOwnerId ){

        List<Message> messages = null;
        try{
            User user = (User) request.getSession().getAttribute( ATT_SESSION_USER );
            messages = messageDao.getMessagesOwnerDemander( user.getIdUser(), offerOwnerId );
        }catch (DaoException e){
            setError(FIELD_MESSAGE, "error fetching messages ");
        }catch (Exception e){
            setError( FIELD_MESSAGE, "authentication error");
        }

        return messages;
    }

    public List<User> getDemanders(HttpServletRequest request, IMessageDao messageDao ){
        List<User> demanders = null;

        try{
            User user = (User) request.getSession().getAttribute( ATT_SESSION_USER );
            demanders = messageDao.getDemandersList( user.getIdUser() );
        }catch (DaoException e){
            setError(FIELD_MESSAGE, "error fetching demanders ");
        }catch (Exception e){
            setError( FIELD_MESSAGE, "authentication error");
        }

        return demanders;
    }
}

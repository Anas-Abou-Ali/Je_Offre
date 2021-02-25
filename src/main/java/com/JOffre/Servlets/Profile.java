package com.JOffre.Servlets;

import com.JOffre.Model.Message;
import com.JOffre.Model.User;
import com.JOffre.dao.DaoFactory;
import com.JOffre.dao.IFavoriteDao;
import com.JOffre.dao.IMessageDao;
import com.JOffre.dao.IUserDao;
import com.JOffre.metier.Messanger;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/profile")
public class Profile extends HttpServlet {
    private static final String ATT_DAO_FACTORY = "daofactory";
    private static final String ATT_USER         = "user";
    private static final String ATT_CHAT         = "chat";
    private static final String ATT_DEMANDERS    = "demanders";
    private static final String VIEW             = "/WEB-INF/profile.jsp";
    private static final String ATT_SESSION_USER = "user";
    private static final String GET_DEMANDER     = "idDemander";
    private IUserDao users                       = null;
    private IFavoriteDao favorites               = null;
    private IMessageDao  messages                = null;

    @Override
    public void init() throws ServletException{
        this.users = ( (DaoFactory) getServletContext().getAttribute( ATT_DAO_FACTORY ) ).getUserDao();
        this.favorites = ( (DaoFactory) getServletContext().getAttribute( ATT_DAO_FACTORY ) ).getFavoriteDao();
        this.messages = ( (DaoFactory) getServletContext().getAttribute( ATT_DAO_FACTORY ) ).getMessageDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //getting user from the session
        User user = (User) request.getSession().getAttribute( ATT_SESSION_USER );

        //populating user with its offers and its favorites
        user.setOffers( this.favorites.getMyOffers( user.getIdUser() ) );
        user.setFavorites( this.favorites.get( user.getIdUser() ) );

        //getting list of demnaders
        Messanger messanger = new Messanger();
        List<User>  demanders = messanger.getDemanders( request, this.messages );


        request.setAttribute(ATT_DEMANDERS, demanders);
        request.setAttribute(ATT_USER, user);

        this.getServletContext().getRequestDispatcher( VIEW ).forward( request, response );
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String demanderId = request.getParameter( GET_DEMANDER );

        //getting user from the session
        User user = (User) request.getSession().getAttribute( ATT_SESSION_USER );

        //populating user with its offers and its favorites
        user.setOffers( this.favorites.getMyOffers( user.getIdUser() ) );
        user.setFavorites( this.favorites.get( user.getIdUser() ) );

        //getting list of demnaders
        Messanger messanger = new Messanger();
        List<User>  demanders = messanger.getDemanders( request, this.messages );

        //getting messages with the selected demander
        List<Message> chat  = messanger.receive(request, messages, demanderId );

        request.setAttribute(ATT_CHAT, chat);
        request.setAttribute(ATT_DEMANDERS, demanders);
        request.setAttribute(ATT_USER, user);

        this.getServletContext().getRequestDispatcher( VIEW ).forward( request, response );
    }
}

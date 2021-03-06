package com.JOffre.Servlets;

import com.JOffre.Model.Image;
import com.JOffre.Model.Message;
import com.JOffre.Model.Offre;
import com.JOffre.Model.User;
import com.JOffre.dao.*;
import com.JOffre.metier.Messanger;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
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
    private IImagesDao   images                  = null;

    @Override
    public void init() throws ServletException{
        this.users = ( (DaoFactory) getServletContext().getAttribute( ATT_DAO_FACTORY ) ).getUserDao();
        this.favorites = ( (DaoFactory) getServletContext().getAttribute( ATT_DAO_FACTORY ) ).getFavoriteDao();
        this.messages = ( (DaoFactory) getServletContext().getAttribute( ATT_DAO_FACTORY ) ).getMessageDao();
        this.images = ( (DaoFactory) getServletContext().getAttribute( ATT_DAO_FACTORY ) ).getImagesDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String demanderId = request.getParameter( "id" );

        //getting user from the session
        User user = (User) request.getSession().getAttribute( ATT_SESSION_USER );

        //populating user with its offers and its favorites
        user.setOffers( this.favorites.getMyOffers( user.getIdUser() ) );
        user.setFavorites( this.favorites.get( user.getIdUser() ) );

        for(Offre offer :user.getOffers()){
            Image offerImage = this.images.getOneImgForOffer( offer.getOfferId() );
            List<Image> photos = new ArrayList<>();
            photos.add(offerImage);
            offer.setPhotos(photos);
        }
        for(Offre offer :user.getFavorites() ){
            Image offerImage = this.images.getOneImgForOffer( offer.getOfferId() );
            List<Image> photos = new ArrayList<>();
            photos.add(offerImage);
            offer.setPhotos(photos);
        }


        //getting list of demnaders
        Messanger messanger = new Messanger();
        List<User>  demanders = messanger.getDemanders( request, this.messages );

        if(demanderId != null && demanderId.trim().length() != 0){
            //getting messages with the selected demander
            List<Message> chat  = messanger.receive(request, messages, demanderId );
            request.setAttribute(ATT_CHAT, chat);

        }


        request.setAttribute(ATT_DEMANDERS, demanders);
        request.setAttribute(ATT_USER, user);

        this.getServletContext().getRequestDispatcher( VIEW ).forward( request, response );
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String demanderId = request.getParameter( GET_DEMANDER );

        response.sendRedirect( request.getContextPath() + "/profile?id="+demanderId );



//        String demanderId = request.getParameter( GET_DEMANDER );
//
//        //getting user from the session
//        User user = (User) request.getSession().getAttribute( ATT_SESSION_USER );
//
//        //populating user with its offers and its favorites
//        user.setOffers( this.favorites.getMyOffers( user.getIdUser() ) );
//        user.setFavorites( this.favorites.get( user.getIdUser() ) );
//
//        for(Offre offer :user.getOffers()){
//            Image offerImage = this.images.getOneImgForOffer( offer.getOfferId() );
//            List<Image> photos = new ArrayList<>();
//            photos.add(offerImage);
//            offer.setPhotos(photos);
//        }
//        for(Offre offer :user.getFavorites() ){
//            Image offerImage = this.images.getOneImgForOffer( offer.getOfferId() );
//            List<Image> photos = new ArrayList<>();
//            photos.add(offerImage);
//            offer.setPhotos(photos);
//        }
//
//        //getting list of demnaders
//        Messanger messanger = new Messanger();
//        List<User>  demanders = messanger.getDemanders( request, this.messages );
//
//        //getting messages with the selected demander
//        List<Message> chat  = messanger.receive(request, messages, demanderId );
//
//        request.setAttribute(ATT_CHAT, chat);
//        request.setAttribute(ATT_DEMANDERS, demanders);
//        request.setAttribute(ATT_USER, user);
//
//        this.getServletContext().getRequestDispatcher( VIEW ).forward( request, response );
    }
}

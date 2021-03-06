package com.JOffre.Servlets;

import com.JOffre.Model.Image;
import com.JOffre.Model.Offre;
import com.JOffre.Model.User;
import com.JOffre.dao.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(value = "/rem")
public class DeletingServlet extends HttpServlet {
    private static final String VIEW_RETURN      = "/index.jsp";
    private static final String VIEW_PROFILE     = "/profile";
    private static final String ATT_DAO_FACTORY  = "daofactory";
    private static final String ATT_SESSION_USER = "user";


    private static final String GET_REMOVE_FAV       = "fav";
    private static final String GET_REMOVE_MY_OFFER  = "my";

    private IOffreDao offers = null;
    private IImagesDao images = null;
    private IFavoriteDao favorites = null;


    @Override
    public void init() throws ServletException{
        this.offers    = ( (DaoFactory) getServletContext().getAttribute( ATT_DAO_FACTORY ) ).getOfferDao();
        this.images    = ( (DaoFactory) getServletContext().getAttribute( ATT_DAO_FACTORY ) ).getImagesDao();
        this.favorites = ( (DaoFactory) getServletContext().getAttribute( ATT_DAO_FACTORY ) ).getFavoriteDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //getting user from the session
        User user = (User) request.getSession().getAttribute( ATT_SESSION_USER );

        String favoriteId = request.getParameter( GET_REMOVE_FAV );
        String myOfferId = request.getParameter( GET_REMOVE_MY_OFFER );

        //deleting offer
        if(favoriteId != null && favoriteId.trim().length() != 0 && user != null){
            //case of a favorite we delete just link between this user and the offer
            favorites.delete(user.getIdUser(), Long.parseLong( favoriteId ));

            response.sendRedirect( request.getContextPath() + VIEW_PROFILE );
        }else if(myOfferId != null && myOfferId.trim().length() != 0 && user != null){
            //case my offer: We delete images of the offer, favorites entries (links to people who liked the offer ) and then delete the offer
            Offre offer = this.offers.get( Long.parseLong( myOfferId ));

            List<Image> photos = this.images.getAll( offer.getOfferId() );
            offer.setPhotos(photos);


            if( offer != null && offer.getIdUser().equals( user.getIdUser() ) ){

                this.favorites.deleteOfferEntries( Long.parseLong( myOfferId ) );

                for( Image im : offer.getPhotos() )
                    this.images.delete( Long.parseLong( myOfferId ) );

                this.offers.delete( Long.parseLong(myOfferId) );
            }
            response.sendRedirect( request.getContextPath() + VIEW_PROFILE );
        }else{
            response.sendRedirect( request.getContextPath() + VIEW_RETURN );
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

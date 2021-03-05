package com.JOffre.Servlets;

import com.JOffre.Model.Image;
import com.JOffre.Model.Message;
import com.JOffre.Model.Offre;
import com.JOffre.dao.DaoFactory;
import com.JOffre.dao.IImagesDao;
import com.JOffre.dao.IMessageDao;
import com.JOffre.dao.IOffreDao;
import com.JOffre.metier.Messanger;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(value = "/offer")
public class OfferDetail extends HttpServlet {
    private static final String ATT_DAO_FACTORY = "daofactory";
    private static final String ATT_OFFER       = "offer";
    private static final String ATT_CHAT        = "chat";
    private static final String GET_OFFER       = "off";
    private static final String VIEW            = "/WEB-INF/offerDetail.jsp";
    private static final String VIEW_RETURN     = "/index.jsp";

    private IOffreDao offers                    = null;
    private IMessageDao messages                = null;
    private IImagesDao images                   = null;

    @Override
    public void init() throws ServletException{
        this.offers   = ( (DaoFactory) getServletContext().getAttribute( ATT_DAO_FACTORY ) ).getOfferDao();
        this.messages = ( (DaoFactory) getServletContext().getAttribute( ATT_DAO_FACTORY ) ).getMessageDao();
        this.images = ( (DaoFactory) getServletContext().getAttribute( ATT_DAO_FACTORY ) ).getImagesDao();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String offerId = request.getParameter( GET_OFFER );

        if(offerId == null || offerId.trim().length() == 0){
            response.sendRedirect( request.getContextPath() + VIEW_RETURN );

        }else{
            Messanger messanger = new Messanger();
            Offre offer = this.offers.get( Long.parseLong( offerId ) );
            
            Image offerImage = this.images.getOneImgForOffer( offer.getOfferId() );
            List<Image> photos = new ArrayList<>();
            photos.add(offerImage);
            offer.setPhotos(photos);

            List<Message> chat  = messanger.receive(request, this.messages, offer.getIdUser() );

            request.setAttribute(ATT_CHAT, chat);
            request.setAttribute(ATT_OFFER, offer);

            this.getServletContext().getRequestDispatcher( VIEW ).forward( request, response );
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String offerId = request.getParameter( GET_OFFER );

        Messanger messanger = new Messanger();
        messanger.sendMessage(request, messages);


        if( offerId == null || offerId.trim().length() == 0){

            response.sendRedirect( request.getContextPath() + VIEW_RETURN );

        }else{
            Offre offer = this.offers.get( Long.parseLong( offerId ) );
            if(offer == null ) response.sendRedirect( request.getContextPath() + VIEW_RETURN );
            else{
                Image offerImage = this.images.getOneImgForOffer( offer.getOfferId() );
                List<Image> photos = new ArrayList<>();
                photos.add(offerImage);
                offer.setPhotos(photos);

                List<Message> chat  = messanger.receive(request, messages, offer.getIdUser() );


                request.setAttribute(ATT_CHAT, chat);
                request.setAttribute(ATT_OFFER, offer);

                this.getServletContext().getRequestDispatcher( VIEW ).forward( request, response );

            }
          }
    }
}

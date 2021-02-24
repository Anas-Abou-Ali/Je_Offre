package com.JOffre.Servlets;

import com.JOffre.Model.Offre;
import com.JOffre.dao.DaoFactory;
import com.JOffre.dao.IMessageDao;
import com.JOffre.dao.IOffreDao;
import com.JOffre.metier.Messanger;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/offer")
public class OfferDetail extends HttpServlet {
    private static final String ATT_DAO_FACTORY = "daofactory";
    private static final String ATT_OFFER       = "offer";
    private static final String GET_OFFER       = "off";
    private static final String VIEW            = "/WEB-INF/offerDetail.jsp";
    private static final String VIEW_RETURN     = "/index.jsp";
    private IOffreDao offers                    = null;
    private IMessageDao messages                = null;

    @Override
    public void init() throws ServletException{
        this.offers   = ( (DaoFactory) getServletContext().getAttribute( ATT_DAO_FACTORY ) ).getOfferDao();
        this.messages = ( (DaoFactory) getServletContext().getAttribute( ATT_DAO_FACTORY ) ).getMessageDao();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String offerId = request.getParameter( GET_OFFER );

        if(offerId == null || offerId.trim().length() == 0){
            response.sendRedirect( request.getContextPath() + VIEW_RETURN );
        }else{
            Offre offer = this.offers.get( Long.parseLong( offerId ) );
            request.setAttribute(ATT_OFFER, offer);
            this.getServletContext().getRequestDispatcher( VIEW ).forward( request, response );
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String offerId = request.getParameter( GET_OFFER );

        Messanger messanger = new Messanger();
        messanger.sendMessage(request, messages);

        if(offerId == null || offerId.trim().length() == 0){
            response.sendRedirect( request.getContextPath() + VIEW_RETURN );
        }else{
            Offre offer = this.offers.get( Long.parseLong( offerId ) );
            request.setAttribute(ATT_OFFER, offer);
            this.getServletContext().getRequestDispatcher( VIEW ).forward( request, response );
        }
    }
}

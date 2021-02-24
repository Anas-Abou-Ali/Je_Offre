package com.JOffre.Servlets;

import com.JOffre.Model.Category;
import com.JOffre.Model.City;
import com.JOffre.Model.Offre;
import com.JOffre.dao.DaoFactory;
import com.JOffre.dao.IOffreDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/offers")
public class Offers extends HttpServlet {
    private static final String ATT_DAO_FACTORY = "daofactory";
    private static final String ATT_OFFERS      = "offers";
    private static final String VIEW            = "/WEB-INF/offers.jsp";
    private IOffreDao offers                    = null;

    @Override
    public void init() throws ServletException{
        this.offers = ( (DaoFactory) getServletContext().getAttribute( ATT_DAO_FACTORY ) ).getOfferDao();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Offre> offers = null;
        String byCategory = request.getParameter("category");
        String byCity = request.getParameter("city");
        String bySearch = request.getParameter("search");

        if( byCategory != null && byCategory.trim().length() != 0 )
            offers = this.offers.getOffres( Category.values()[ Integer.parseInt( byCategory ) ] );

        if( byCity != null && byCity.trim().length() != 0 )
            offers = this.offers.getOffres( City.values()[ Integer.parseInt( byCity ) ] );

        if( bySearch != null && bySearch.trim().length() != 0)
            offers = this.offers.searchOffers( bySearch );

        if(offers == null || offers.isEmpty())
            offers = this.offers.getOffres( City.ALL );


        request.setAttribute(ATT_OFFERS, offers);
        this.getServletContext().getRequestDispatcher( VIEW ).forward( request, response );

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

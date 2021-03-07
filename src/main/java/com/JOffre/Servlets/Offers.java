package com.JOffre.Servlets;


import com.JOffre.Model.Image;
import com.JOffre.Model.Offre;
import com.JOffre.dao.DaoFactory;
import com.JOffre.dao.IImagesDao;
import com.JOffre.dao.IOffreDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.JOffre.Model.SharedEnums.Category;
import static com.JOffre.Model.SharedEnums.City;

@WebServlet(value = "/offers")
public class Offers extends HttpServlet {
    private static final String ATT_DAO_FACTORY = "daofactory";
    private static final String ATT_OFFERS      = "offers";
    private static final String ATT_CITIES      = "City";
    private static final String ATT_CATEGORIES  = "Category";

    private static final String NOTICE_MESSAGE      = "noticeMessage";

    private static final String GET_PARAM_CITY      = "city";
    private static final String GET_PARAM_CATEGORY  = "category";
    private static final String GET_PARAM_SEARCH    = "search";



    private static final String VIEW            = "/WEB-INF/offers.jsp";
    private IOffreDao offers                    = null;
    private IImagesDao images                   = null;

    @Override
    public void init() throws ServletException{
        this.offers = ( (DaoFactory) getServletContext().getAttribute( ATT_DAO_FACTORY ) ).getOfferDao();
        this.images = ( (DaoFactory) getServletContext().getAttribute( ATT_DAO_FACTORY ) ).getImagesDao();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Offre> offers = null;
        String byCategory = request.getParameter( GET_PARAM_CATEGORY );
        String byCity = request.getParameter( GET_PARAM_CITY );
        String bySearch = request.getParameter( GET_PARAM_SEARCH );

        if( byCategory != null && byCategory.trim().length() != 0 )
            offers = this.offers.getOffresCategory( Integer.parseInt( byCategory ) );

        else if( bySearch != null && bySearch.trim().length() != 0)
            offers = this.offers.searchOffers( bySearch );

        else if( byCity != null && byCity.trim().length() != 0 )
            offers = this.offers.getOffresCity( Integer.parseInt( byCity ) );

        if(offers == null || offers.isEmpty()){
            offers = this.offers.getOffresCity( 0 );
            request.setAttribute(NOTICE_MESSAGE, "Aucune offre trouvée, consulter le reste des offres . . .");
        }

        for(Offre off : offers){
            Image offerImage = this.images.getOneImgForOffer(  off.getOfferId()  );
            List<Image> photos = new ArrayList<>();
            photos.add(offerImage);
            off.setPhotos(photos);
        }

        request.setAttribute(ATT_OFFERS, offers);

        request.setAttribute(ATT_CITIES, City);
        request.setAttribute(ATT_CATEGORIES ,Category);
        this.getServletContext().getRequestDispatcher( VIEW ).forward( request, response );

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

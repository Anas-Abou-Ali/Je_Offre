package com.JOffre.Servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;



@WebServlet(value = "/rem")
public class DeletingServlet extends HttpServlet {
    private static final String VIEW_RETURN      = "/index.jsp";
    private static final String VIEW_PROFILE     = "/profile";

    private static final String GET_REMOVE_FAV       = "fav";
    private static final String GET_REMOVE_MY_OFFER  = "my";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String favoriteId = request.getParameter( GET_REMOVE_FAV );
        String myOfferId = request.getParameter( GET_REMOVE_MY_OFFER );
        if(favoriteId != null && favoriteId.trim().length() != 0){
            response.sendRedirect( request.getContextPath() + VIEW_PROFILE );
        }else if(myOfferId != null && myOfferId.trim().length() != 0){
            response.sendRedirect( request.getContextPath() + VIEW_PROFILE );
        }else{
            response.sendRedirect( request.getContextPath() + VIEW_RETURN );
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

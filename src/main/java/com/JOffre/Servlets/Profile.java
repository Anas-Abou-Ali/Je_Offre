package com.JOffre.Servlets;

import com.JOffre.Model.Category;
import com.JOffre.Model.User;
import com.JOffre.dao.DaoFactory;
import com.JOffre.dao.IOffreDao;
import com.JOffre.dao.IUserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/profile")
public class Profile extends HttpServlet {
    private static final String ATT_DAO_FACTORY = "daofactory";
    private static final String ATT_USER        = "user";
    private static final String VIEW            = "/WEB-INF/profile.jsp";
    private static final String ATT_SESSION_USER = "user";
    private IUserDao users                      = null;

    @Override
    public void init() throws ServletException{
        this.users = ( (DaoFactory) getServletContext().getAttribute( ATT_DAO_FACTORY ) ).getUserDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute( ATT_SESSION_USER ) ;
        request.setAttribute(ATT_USER, user);
        this.getServletContext().getRequestDispatcher( VIEW ).forward( request, response );
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

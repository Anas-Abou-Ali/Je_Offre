package com.JOffre.Servlets;

import com.JOffre.Model.User;
import com.JOffre.dao.DaoFactory;
import com.JOffre.dao.IOffreDao;
import com.JOffre.dao.IUserDao;
import com.JOffre.metier.ConnectUser;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/login")
public class Login extends HttpServlet {
    private static final int MAX_COOKIE_AGE      = 60*60*24*365; //one year
    private static final String COOKIE_USER_ID   = "fid"; //name the userId cookie in the browser
    private static final String COOKIE_USERNAME  = "username"; //name the username cookie in the browser
    private static final String VIEW             = "/index.jsp";
    private static final String VIEW_RETURN      = "/index.jsp";
    private static final String ATT_DAO_FACTORY  = "daofactory";
    private static final String ATT_SESSION_USER = "user";
    private static final String GET_LOGOUT       = "logout";
    private IUserDao users                       = null;


    @Override
    public void init() throws ServletException{
        this.users = ( (DaoFactory) getServletContext().getAttribute( ATT_DAO_FACTORY ) ).getUserDao();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String out = request.getParameter( GET_LOGOUT );

        if( out == null || out.trim().length() ==0 || !out.trim().equals("out") ){
            response.sendRedirect( request.getContextPath() +  VIEW_RETURN );

        }else{
            HttpSession session = request.getSession();
            session.invalidate();

            //redirection to home page
            response.sendRedirect( request.getContextPath() + VIEW_RETURN );
        }



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            //calling metier object
            ConnectUser connectUser = new ConnectUser();

            //processing the form and getting the user bean
            User user = connectUser.connect(request, this.users);

            //setting the session for the user
            if(user != null){
                HttpSession session = request.getSession();
                session.setAttribute(ATT_SESSION_USER, user);
            }

            response.sendRedirect( request.getContextPath() + VIEW );



    }

}

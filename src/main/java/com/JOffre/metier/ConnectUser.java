package com.JOffre.metier;

import com.JOffre.Model.User;
import com.JOffre.dao.IUserDao;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConnectUser {
    private static final String FIELD_USER_ID  = "idUser";
    private static final String FIELD_USERNAME = "username";



    //getting the id and setting the user bean
    public User connect(HttpServletRequest request, IUserDao users){
        String idUser = request.getParameter(FIELD_USER_ID);
        String username = request.getParameter(FIELD_USERNAME);

        if( idUser != null && idUser.trim().length() != 0 && username != null && username.trim().length() != 0 ){
            //check if user already exist
            User user = users.get( idUser );

            //registring the non existing user automatically
            if(user == null){
                user = new User();
                user.setIdUser( idUser );
                user.setFirstName( username );
                user = users.create( user );
            }

            return user;
        }

        return null;
    }

    //setting cookie function
    public static void setCookie(HttpServletResponse response, String name, String value, int maxAge ) {
        Cookie cookie = new Cookie( name, value );
        cookie.setMaxAge( maxAge );
        response.addCookie( cookie );
    }
    //get cookie using value
    private static String getCookieValue( HttpServletRequest request, String name ) {
        Cookie[] cookies = request.getCookies();
        if ( cookies != null ) {
            for ( Cookie cookie : cookies ) {
                if ( cookie != null && name.equals( cookie.getName() ) ) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
}

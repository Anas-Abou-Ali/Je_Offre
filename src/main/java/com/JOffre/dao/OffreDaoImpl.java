package com.JOffre.dao;

import com.JOffre.Model.Offre;
import static com.JOffre.daoUtil.Util.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OffreDaoImpl implements IOffreDao{

    private static final String SQL_INSERT = "INSERT INTO offer(idUser, title, description, city, category) VALUES(?,?,?,?,?)";
    private static final String SQL_SELECT = "SELECT offerId, offer.idUser, title, description, date, city, category, firstName, lastName from offer JOIN user on user.idUser = offer.idUser where offerId = ?";
    private static final String SQL_UPDATE = "UPDATE offer set title  = ?, description = ?, city = ?, category = ?  where offerId = ? ";
    private static final String SQL_DELETE = "DELETE from offer where offerId = ? ";

    private static final String SQL_SELECT_BY_CITY          = "SELECT offerId, idUser, title, description, date, city, category from offer where city = ? ";
    private static final String SQL_SELECT_ALLCITIES        = "SELECT offerId, idUser, title, description, date, city, category from offer";
    private static final String SQL_SELECT_BY_CATEGORY      = "SELECT offerId, idUser, title, description, date, city, category from offer where category = ? ";
    private static final String SQL_SELECT_ALLCATEGORIES    = "SELECT offerId, idUser, title, description, date, city, category from offer ";
    private static final String SQL_SELECT_BY_CITY_CATEGORY = "SELECT offerId, idUser, title, description, date, city, category from offer where city = ? and category = ?";
    private static final String SQL_SELECT_BY_SEARCH        = "SELECT offerId, idUser, title, description, date, city, category from offer where title LIKE ? ESCAPE '!'";


    private DaoFactory       daoFactory;
    Connection connection               = null;
    PreparedStatement preparedStatement = null;


    OffreDaoImpl( DaoFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }

    @Override
    public Offre create(Offre offer) throws DaoException {
        ResultSet generatedValues = null;
        try {
            connection = daoFactory.getConnection();
            preparedStatement = initPreparedStatement( connection, SQL_INSERT, true, offer.getIdUser(), offer.getTitre(), offer.getDescription(), offer.getCity(), offer.getCategory() );

            int status = preparedStatement.executeUpdate();
            if ( status == 0 ) {
                throw new DaoException( "cannot add an offer to table" );
            }

            //recuperation de l'id
            generatedValues = preparedStatement.getGeneratedKeys();
            if ( generatedValues.next() ) {
                offer.setOfferId( generatedValues.getLong( 1 ) );
            } else {
                throw new DaoException("failed to create an offer, no id was generated");
            }
        } catch(SQLException e){
            throw new DaoException(e);
        }
        finally {
            closeResources( generatedValues, preparedStatement, connection );
        }
        return offer;
    }

    @Override
    public Offre get(Long id) throws DaoException {
        Offre offer = null;
        ResultSet resultSet = null;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initPreparedStatement( connection, SQL_SELECT, false, id);

            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            if ( resultSet.next() ) {
                offer = mapToOffer_withUserName(resultSet);
            }

        } catch(SQLException e){
            throw new DaoException(e);
        }
        finally {
            closeResources( resultSet, preparedStatement, connection );
        }
        return offer;
    }



    @Override
    public Offre update(Offre offer) throws DaoException {
        try {
            connection = daoFactory.getConnection();
            preparedStatement = initPreparedStatement( connection, SQL_UPDATE, true, offer.getTitre(), offer.getDescription(), offer.getCity(), offer.getCategory(), offer.getOfferId());

            int status = preparedStatement.executeUpdate();
            if ( status == 0 ) {
                throw new DaoException( "cannot update an offer" );
            }
        } catch(SQLException e){
            throw new DaoException(e);
        }
        finally {
            closeResources( preparedStatement, connection );
        }
        return offer;
    }

    @Override
    public void delete(Long id) throws DaoException {
        try {
            connection = daoFactory.getConnection();
            preparedStatement = initPreparedStatement( connection, SQL_DELETE, false, id);

            int status = preparedStatement.executeUpdate();
            if ( status == 0 ) {
                throw new DaoException( "cannot delete an offer" );
            }

        } catch(SQLException e){
            throw new DaoException(e);
        }
        finally {
            closeResources(preparedStatement, connection );
        }
    }

    @Override
    public List<Offre> getOffresCity(Integer city) throws DaoException {
        List<Offre> offers = new ArrayList<>();
        ResultSet resultSet = null;

        try {
            connection = daoFactory.getConnection();
            if(city != 0)
                preparedStatement = initPreparedStatement( connection, SQL_SELECT_BY_CITY, false, city );
            else
                preparedStatement = initPreparedStatement( connection, SQL_SELECT_ALLCITIES, false );

            resultSet = preparedStatement.executeQuery();

            while ( resultSet.next() ) {
                offers.add( mapToOffer_withNoUserName(resultSet) );
            }

        } catch(SQLException e){
            throw new DaoException(e);
        }
        finally {
            closeResources( resultSet, preparedStatement, connection );
        }
        return offers;
    }

    @Override
    public List<Offre> getOffresCategory(Integer category) throws DaoException {
        List<Offre> offers = new ArrayList<>();
        ResultSet resultSet = null;

        try {
            connection = daoFactory.getConnection();
            if(category != 0)
                preparedStatement = initPreparedStatement( connection, SQL_SELECT_BY_CATEGORY, false, category);
            else
                preparedStatement = initPreparedStatement( connection, SQL_SELECT_ALLCATEGORIES, false);
            resultSet = preparedStatement.executeQuery();

            while ( resultSet.next() ) {
                offers.add( mapToOffer_withNoUserName(resultSet) );
            }

        } catch(SQLException e){
            throw new DaoException(e);
        }
        finally {
            closeResources( resultSet, preparedStatement, connection );
        }
        return offers;
    }

    @Override
    public List<Offre> getOffres(Integer city, Integer category) throws DaoException {
        List<Offre> offers = new ArrayList<>();
        ResultSet resultSet = null;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initPreparedStatement( connection, SQL_SELECT_BY_CITY_CATEGORY, false, city, category );
            resultSet = preparedStatement.executeQuery();

            while ( resultSet.next() ) {
                offers.add( mapToOffer_withNoUserName(resultSet) );
            }

        } catch(SQLException e){
            throw new DaoException(e);
        }
        finally {
            closeResources( resultSet, preparedStatement, connection );
        }
        return offers;
    }

    @Override
    public List<Offre> searchOffers(String str) throws DaoException {
        str = str.replace("!", "!!")
                .replace("%", "!%")
                .replace("_", "!_")
                .replace("[", "![");


        List<Offre> offers = new ArrayList<>();
        ResultSet resultSet = null;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initPreparedStatement( connection, SQL_SELECT_BY_SEARCH, false, "%"+str +"%");
            resultSet = preparedStatement.executeQuery();

            while ( resultSet.next() ) {
                offers.add( mapToOffer_withNoUserName(resultSet) );
            }

        } catch(SQLException e){
            throw new DaoException(e);
        }
        finally {
            closeResources( resultSet, preparedStatement, connection );
        }
        return offers;
    }




}

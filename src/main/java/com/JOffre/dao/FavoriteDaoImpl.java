package com.JOffre.dao;

import com.JOffre.Model.Offre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.JOffre.daoUtil.Util.*;
import static com.JOffre.daoUtil.Util.closeResources;

public class FavoriteDaoImpl implements IFavoriteDao {

    private static final String SQL_INSERT          = "INSERT INTO favoritize(offerId, idUser) VALUES(?, ?)";
    private static final String SQL_SELECT          = "SELECT off.offerId, off.idUser, off.title, off.description, off.date, off.city, off.category from favoritize fav join offer off on off.offerId = fav.offerId where fav.idUser = ? ";
    private static final String SQL_SELECT_MYOFFERS = "SELECT offerId, idUser, title, description, date, city, category from offer where idUser = ? ";

    private static final String SQL_DELETE          = "DELETE from favoritize where offerId = ? and idUser = ? ";
    private static final String SQL_DELETE_ENTRIES  = "DELETE from favoritize where offerId = ? ";



    private DaoFactory       daoFactory;
    Connection connection               = null;
    PreparedStatement preparedStatement = null;

    FavoriteDaoImpl( DaoFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }

    @Override
    public Offre create(String idUser, Offre offer) throws DaoException {
        ResultSet generatedValues = null;
        try {
            connection = daoFactory.getConnection();
            preparedStatement = initPreparedStatement( connection, SQL_INSERT, true, offer.getOfferId(), idUser );

            int status = preparedStatement.executeUpdate();
            if ( status == 0 ) {
                throw new DaoException( "cannot add a favorite" );
            }

            //recuperation de l'id
            generatedValues = preparedStatement.getGeneratedKeys();
            if ( generatedValues.next() ) {
                 generatedValues.getLong( 1 );
            } else {
                throw new DaoException("failed to create a favorite");
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
    public List<Offre> get(String idUser) throws DaoException {
        List<Offre> offers = new ArrayList<>();
        ResultSet resultSet = null;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initPreparedStatement( connection, SQL_SELECT, false, idUser);
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
    public List<Offre> getMyOffers(String idUser) throws DaoException {
        List<Offre> offers = new ArrayList<>();
        ResultSet resultSet = null;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initPreparedStatement( connection, SQL_SELECT_MYOFFERS, false, idUser);
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
    public void delete(String idUser, Long offerId) throws DaoException {
        try {
            connection = daoFactory.getConnection();
            preparedStatement = initPreparedStatement( connection, SQL_DELETE, false, offerId, idUser);

            int status = preparedStatement.executeUpdate();
            if ( status == 0 ) {
                throw new DaoException( "cannot delete a favorite" );
            }

        } catch(SQLException e){
            throw new DaoException(e);
        }
        finally {
            closeResources(preparedStatement, connection );
        }
    }

    @Override
    public void deleteOfferEntries(Long offerId) throws DaoException {
        try {
            connection = daoFactory.getConnection();
            preparedStatement = initPreparedStatement( connection, SQL_DELETE_ENTRIES, false, offerId);

            int status = preparedStatement.executeUpdate();
      //      if ( status == 0 ) {
      //          throw new DaoException( "cannot delete favorite entries" );
      //       }

        } catch(SQLException e){
            throw new DaoException(e);
        }
        finally {
            closeResources(preparedStatement, connection );
        }
    }
}

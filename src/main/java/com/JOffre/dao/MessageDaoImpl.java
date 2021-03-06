package com.JOffre.dao;

import com.JOffre.Model.Message;
import com.JOffre.Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import static com.JOffre.daoUtil.Util.*;
import static com.JOffre.daoUtil.Util.closeResources;

public class MessageDaoImpl implements IMessageDao {

    private static final String SQL_INSERT                = "INSERT INTO Messages(sender_id_user, idUser, message) VALUES(?, ?, ?)";
    private static final String SQL_SELECT_DEMANDER_OWNER = "SELECT sender_id_user, idUser, id_message, dateMessage, message from Messages where (sender_id_user = ? and idUser = ? ) or (sender_id_user = ? and idUser = ? ) order by dateMessage desc Limit 100";
    private static final String SQL_SELECT_DEMANDERS      = "SELECT ms.sender_id_user, us.firstName from Messages ms JOIN user us ON us.idUser = ms.sender_id_user where ms.idUser = ? order by dateMessage desc Limit 30";
    private static final String SQL_DELETE                = "DELETE from Messages where id_message = ? ";


    private DaoFactory       daoFactory;
    Connection connection               = null;
    PreparedStatement preparedStatement = null;

    MessageDaoImpl( DaoFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }

    @Override
    public Message create(Message message) throws DaoException {
        ResultSet generatedValues = null;
        try {
            connection = daoFactory.getConnection();
            preparedStatement = initPreparedStatement( connection, SQL_INSERT, true, message.getSenderId(), message.getReceiverId(), message.getMessage() );

            int status = preparedStatement.executeUpdate();
            if ( status == 0 ) {
                throw new DaoException( "cannot add an message to table" );
            }

            //recuperation de l'id
            generatedValues = preparedStatement.getGeneratedKeys();
//            if ( generatedValues.next() ) {
//                message.setMessageId( generatedValues.getLong( "sender_id_user" ) );
//            } else {
//                throw new DaoException("failed to create a message, no id was generated");
//            }
        } catch(SQLException e){
            throw new DaoException(e);
        }
        finally {
            closeResources( generatedValues, preparedStatement, connection );
        }
        return message;
    }

    @Override
    public List<Message> getMessagesOwnerDemander(String idUser, String idOwner) throws DaoException {
        List<Message> messages = new LinkedList<>();
        ResultSet resultSet = null;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initPreparedStatement( connection, SQL_SELECT_DEMANDER_OWNER, false, idUser, idOwner, idOwner, idUser);
            resultSet = preparedStatement.executeQuery();

            while ( resultSet.next() ) {
                messages.add( mapToMessage(resultSet) );
            }

        } catch(SQLException e){
            throw new DaoException(e);
        }
        finally {
            closeResources( resultSet, preparedStatement, connection );
        }
        return messages;
    }

    @Override
    public List<User> getDemandersList(String idUser) throws DaoException {
        List<User> demanders = new LinkedList<>();
        ResultSet resultSet = null;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initPreparedStatement( connection, SQL_SELECT_DEMANDERS, false, idUser);
            resultSet = preparedStatement.executeQuery();

            while ( resultSet.next() ) {
                User tempUser = new User();
                tempUser.setIdUser( resultSet.getString("sender_id_user" ) );
                tempUser.setFirstName( resultSet.getString("firstName" ) );
                demanders.add( tempUser );
            }

        } catch(SQLException e){
            throw new DaoException(e);
        }
        finally {
            closeResources( resultSet, preparedStatement, connection );
        }
        return demanders;
    }

    @Override
    public void delete(Long messageId) throws DaoException {
        try {
            connection = daoFactory.getConnection();
            preparedStatement = initPreparedStatement( connection, SQL_DELETE, false, messageId);

            int status = preparedStatement.executeUpdate();
            if ( status == 0 ) {
                throw new DaoException( "cannot delete a message" );
            }

        } catch(SQLException e){
            throw new DaoException(e);
        }
        finally {
            closeResources(preparedStatement, connection );
        }
    }
}

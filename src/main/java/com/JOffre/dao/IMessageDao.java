package com.JOffre.dao;

import com.JOffre.Model.Message;
import com.JOffre.Model.User;

import java.util.List;

public interface IMessageDao {
    Message create(Message message) throws DaoException;


    //one descussion between two persons demander owner
    List<Message> getMessagesOwnerDemander(String idUser, String idOwner) throws DaoException;

    //list of all  ids of demanders of an owner
    List<User> getDemandersList(String idUser) throws DaoException;


    void delete(Long messageId) throws DaoException;

}

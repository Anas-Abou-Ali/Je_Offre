package com.JOffre.dao;

import com.JOffre.Model.Offre;

import java.util.List;

public interface IFavoriteDao {
    Offre create(String idUser, Offre offer) throws DaoException;
    List<Offre> get(String idUser) throws DaoException;
    void delete(String idUser, Long offerId) throws DaoException;
}

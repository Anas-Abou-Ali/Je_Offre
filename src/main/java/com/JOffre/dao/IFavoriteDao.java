package com.JOffre.dao;

import com.JOffre.Model.Offre;

import java.util.List;

public interface IFavoriteDao {
    Boolean create(String idUser, Long offerId) throws DaoException;
    List<Offre> get(String idUser) throws DaoException;
    void delete(String idUser, Long offerId) throws DaoException;
    void deleteOfferEntries(Long offerId) throws DaoException;

    List<Offre> getMyOffers(String idUser) throws DaoException;

}

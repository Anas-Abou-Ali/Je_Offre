package com.JOffre.dao;
import com.JOffre.Model.Offre;

import java.util.List;

public interface IOffreDao {
    Offre create(Offre offer) throws DaoException;
    Offre get(Long id) throws DaoException;
    Offre update(Offre offer) throws DaoException;
    void delete(Long id) throws DaoException;

    List<Offre> getOffresCity(Integer city) throws DaoException;
    List<Offre> getOffresCategory(Integer category) throws DaoException;
    List<Offre> getOffres(Integer city, Integer category) throws DaoException;

    //search an offre
    List<Offre> searchOffers(String str) throws DaoException;



}

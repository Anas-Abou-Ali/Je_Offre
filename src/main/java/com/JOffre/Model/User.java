package com.JOffre.Model;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {

    private String idUser;
    private String firstName;
    private String lastName;
    private List<Offre> offers ;
    private List<Offre> favorites ;
    private List<Message> messages;

    public List<Offre> getFavorites() { return favorites; }

    public void setFavorites(List<Offre> favorites) { this.favorites = favorites; }

    public List<Offre> getOffers() {
        return offers;
    }

    public void setOffers(List<Offre> offers) {
        this.offers = offers;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}

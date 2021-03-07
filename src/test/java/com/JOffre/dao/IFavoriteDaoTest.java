package com.JOffre.dao;

import com.JOffre.Model.Message;
import com.JOffre.Model.Offre;
import org.junit.jupiter.api.*;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IFavoriteDaoTest {

    private static Instant startedAt;
    private DaoFactory factory;
    private IFavoriteDao favorites;
    private Message message                 = null;

    @BeforeAll
    static public void initStartingTime() {
        System.out.println("Test de Favorites DAO BEGIN....");
        startedAt = Instant.now();
        System.out.println("Timer initialized");
    }

    @AfterAll
    static public void showTestDuration() {
        Instant endedAt = Instant.now();
        long duration = Duration.between(startedAt, endedAt).toMillis();
        System.out.println(MessageFormat.format("Test Favorites DAO ENDS....AFTER : {0} ms", duration));
    }

    @BeforeEach
    void setUp(){
        this.factory = DaoFactory.getFactory();
        this.favorites = this.factory.getFavoriteDao();
    }

    @AfterEach
    void tearDown() {
        this.factory = null;
        this.favorites = null;
    }


    @Test
    void manipulateFavorite() {
        System.out.println("creating test favorite");
        String userID = "testFavoriteUserId";
        Long offerID  = new Long("99999");

        Boolean test = this.favorites.create( userID, offerID );
        assertTrue( test );

        System.out.println("getting test favorite");
        Integer n = this.favorites.get( userID ).size();


        System.out.println("deleting test favorite");
        this.favorites.delete( userID,offerID);
        assertEquals(0, this.favorites.get( userID ).size());
    }




}
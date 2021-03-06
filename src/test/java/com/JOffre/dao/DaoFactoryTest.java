package com.JOffre.dao;

import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;

import static com.JOffre.daoUtil.Util.closeResources;
import static org.junit.jupiter.api.Assertions.*;

class DaoFactoryTest {
    private static Instant startedAt;
    private DaoFactory factory;
    private Connection connection               = null;


    @BeforeAll
    static public void initStartingTime() {
        System.out.println("Test de DAOFACTORY BEGIN....");
        startedAt = Instant.now();
        System.out.println("timer initialized");
        System.out.println("initializing all DAOs");

    }

    @AfterAll
    static public void showTestDuration() {
        Instant endedAt = Instant.now();
        long duration = Duration.between(startedAt, endedAt).toMillis();
        System.out.println(MessageFormat.format("Test DAOFACTORY and ALL DAO initialization ENDS....AFTER : {0} ms", duration));
    }

    @BeforeEach
    public void initFactory() {
        this.factory = DaoFactory.getFactory();
    }

    @AfterEach
    public void undefFactory() {
        this.factory = null;
    }

    @Test
    void getOfferDao() {
        assertNotNull( factory.getOfferDao() );
    }

    @Test
    void getUserDao() {
        assertNotNull( factory.getUserDao() );
    }

    @Test
    void getImagesDao() {
        assertNotNull( factory.getImagesDao() );
    }

    @Test
    void getMessageDao() {
        assertNotNull( factory.getMessageDao() );
    }

    @Test
    void getFavoriteDao() {
        assertNotNull( factory.getFavoriteDao() );
    }

    @Test
    void connextionTest(){
        try {
            this.connection = this.factory.getConnection();
        }catch (Exception e){
            fail();
        }finally {
            closeResources( this.connection );
        }
    }

}
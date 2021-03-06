package com.JOffre.dao;

import com.JOffre.Model.Offre;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;

import com.JOffre.daoUtil.*;

import static com.JOffre.daoUtil.Util.closeResources;
import static org.junit.jupiter.api.Assertions.*;

class IOffreDaoTest {
    private static Instant startedAt;
    private DaoFactory factory;
    private IOffreDao offers;
    private Offre offer                 = null;
    Connection connection               = null;
    PreparedStatement preparedStatement = null;


    @BeforeAll
    static public void initStartingTime() {
        System.out.println("Test de OFFERDAO BEGIN....");
        startedAt = Instant.now();
        System.out.println("timer initialized");
    }

    @AfterAll
    static public void showTestDuration() {
        Instant endedAt = Instant.now();
        long duration = Duration.between(startedAt, endedAt).toMillis();
        System.out.println(MessageFormat.format("Test OFFERDAO ENDS....AFTER : {0} ms", duration));
    }

    @BeforeEach
    void setUp(){
        this.factory = DaoFactory.getFactory();
        this.offers = this.factory.getOfferDao();
        try {
            this.connection = this.factory.getConnection();
        }catch (Exception e){
            fail();
            closeResources( this.connection );
        }
    }

    @AfterEach
    void tearDown() {
        this.factory = null;
        this.offers = null;
        closeResources( this.connection );

    }

    @Test
    void manipulateOffer() {
        System.out.println("creating test offer");
        this.offer = new Offre();
        this.offer.setCity(10);
        this.offer.setCategory(2);
        this.offer.setDescription("testDescription");
        this.offer.setTitre("testTitle");
        this.offer.setIdUser("testId0000");
        this.offer = this.offers.create( this.offer );
        assertNotNull( this.offer.getOfferId() );

        System.out.println("getting test offer");
        this.offers.get( this.offer.getOfferId() );


        System.out.println("deleting test offer");
        this.offers.delete( this.offer.getOfferId() );
    }


    @Test
    void getOffresCity() {
        assertNotNull( this.offers.getOffresCity( 0 ) );

    }

    @Test
    void getOffresCategory() {
        assertNotNull( this.offers.getOffresCategory( 0 ) );

    }
    @Test
    void getOffersBySearch() {
        assertNotNull( this.offers.searchOffers( "pc" ) );

    }


}
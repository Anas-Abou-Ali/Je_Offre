package com.JOffre.dao;

import com.JOffre.Model.Offre;
import com.JOffre.Model.User;
import org.junit.jupiter.api.*;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class IUserDaoTest {

    private static Instant startedAt;
    private DaoFactory factory;
    private IUserDao users;
    private User user                 = null;


    @BeforeAll
    static public void initStartingTime() {
        System.out.println("Test de USERDAO BEGIN....");
        startedAt = Instant.now();
        System.out.println("Timer initialized");
    }

    @AfterAll
    static public void showTestDuration() {
        Instant endedAt = Instant.now();
        long duration = Duration.between(startedAt, endedAt).toMillis();
        System.out.println(MessageFormat.format("Test USERDAO ENDS....AFTER : {0} ms", duration));
    }

    @BeforeEach
    void setUp(){
        this.factory = DaoFactory.getFactory();
        this.users = this.factory.getUserDao();
    }

    @AfterEach
    void tearDown() {
        this.factory = null;
        this.users = null;
    }

    @Test
    void manipulateUser() {
        System.out.println("creating test user");
        this.user = new User();
        this.user.setIdUser("testId0000");
        this.user.setFirstName("testFirstName");
        this.user.setLastName("testLastName");

        this.user = this.users.create( this.user );
        assertNotNull( this.user.getIdUser() );

        System.out.println("getting test user");
        assertNotNull( this.users.get( this.user.getIdUser() ) );


        System.out.println("deleting test user");
        this.users.delete( this.user.getIdUser() );
        assertNull( this.users.get( this.user.getIdUser()) );
    }
}
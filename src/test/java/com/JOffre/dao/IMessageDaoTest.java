package com.JOffre.dao;

import com.JOffre.Model.Message;
import com.JOffre.Model.User;
import org.junit.jupiter.api.*;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class IMessageDaoTest {

    private static Instant startedAt;
    private DaoFactory factory;
    private IMessageDao messages;
    private Message message                 = null;


    @BeforeAll
    static public void initStartingTime() {
        System.out.println("Test de MESSAGES DAO BEGIN....");
        startedAt = Instant.now();
        System.out.println("Timer initialized");
    }

    @AfterAll
    static public void showTestDuration() {
        Instant endedAt = Instant.now();
        long duration = Duration.between(startedAt, endedAt).toMillis();
        System.out.println(MessageFormat.format("Test MESSAGES DAO ENDS....AFTER : {0} ms", duration));
    }

    @BeforeEach
    void setUp(){
        this.factory = DaoFactory.getFactory();
        this.messages = this.factory.getMessageDao();
    }

    @AfterEach
    void tearDown() {
        this.factory = null;
        this.messages = null;
    }

    @Test
    void manipulateMessage() {
        System.out.println("creating test messages");
        this.message = new Message();
        this.message.setSenderId("testSenderId");
        this.message.setReceiverId("testReceiverId");
        this.message.setMessage("testMessage");

        this.message = this.messages.create( this.message );

        assertNotNull( this.message );

        System.out.println("getting test messages");
        this.message = this.messages.getMessagesOwnerDemander( message.getSenderId(), message.getReceiverId() ).get(0);
        assertNotNull( this.message );


        System.out.println("deleting test messages");
        this.messages.delete( this.message.getMessageId() );
        assertEquals(0, this.messages.getMessagesOwnerDemander( message.getSenderId(), message.getReceiverId() ).size());
    }

}
package com.musicreview.model;

import com.musicreview.dao.ArtistDao;
import com.musicreview.dao.RecordLabelDao;
import com.musicreview.dao.ReviewDao;
import com.musicreview.dao.UserDao;
import com.musicreview.dao.impl.ArtistDaoImpl;
import com.musicreview.dao.impl.RecordLabelDaoImpl;
import com.musicreview.dao.impl.ReviewDaoImpl;
import com.musicreview.dao.impl.UserDaoImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Test {

    private SessionFactory sessionFactory;
    private Session session = null;
    @Before
    public void before() {
        // setup the session factory
        AnnotationConfiguration configuration = new AnnotationConfiguration();
        configuration.addAnnotatedClass(Artist.class)
        .addAnnotatedClass(CustomUser.class)
        .addAnnotatedClass(Review.class)
        .addAnnotatedClass(RecordLabel.class);
        configuration.setProperty("hibernate.dialect",
                "org.hibernate.dialect.H2Dialect");
        configuration.setProperty("hibernate.connection.driver_class",
                "org.h2.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:h2:mem");
        configuration.setProperty("hibernate.hbm2ddl.auto", "create");
        sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.openSession();
    }
    @org.junit.Test
    public void returnsHerosWithMatchingType() {
        // create the objects needed for testing
        Artist artist = new Artist();

        artist.setArtist_firstname("Vivi");
        artist.setArtist_nickname("Serhio");
        artist.setArtist_secondname("Pop");
        artist.setId(2);

        //------------

        CustomUser user = new CustomUser();
        user.setId(1);
        user.setEmail("ser@ukr.net");
        user.setFirstName("Vivi");
        user.setLogin("Ser");
        user.setPassword("12345");
        user.setSecondName("Sergio");

        //-----

       RecordLabel recordLabel = new RecordLabel("Kyiv","Ukraine");

       //-------

        Review review=new Review();
        review.setId(1);
        review.setReview_name("test");
        review.setReview_rate(1);
        review.setReview_text("test");

        // storing the objects for the test in the database
        session.save(artist);
        session.save(user);
        session.save(recordLabel);
        session.save(review);
        //-------
        ArtistDao artistDao = new ArtistDaoImpl();
        List<Artist> artists = artistDao.findAll();
        assertNotNull(artists);
        assertEquals(1, artists.size());
        //-----

        ReviewDao reviewDao = new ReviewDaoImpl();
        List<Review> reviews=reviewDao.findAll();
        assertNotNull(reviews);
        assertEquals(1, reviews.size());

        //---

        UserDao userDao = new UserDaoImpl();
        CustomUser custiomUser = userDao.findByLogin("Ser");
        assertNotNull(custiomUser);
        assertEquals(1, custiomUser.getId());

        //--

        RecordLabelDao recordLabelDao=new RecordLabelDaoImpl();
        List<RecordLabel> recordLabels=recordLabelDao.findAll();
        assertNotNull(recordLabels);
        assertEquals(1, recordLabels.size());
    }
    @After
    public void after() {
        session.close();
        sessionFactory.close();
    }

}
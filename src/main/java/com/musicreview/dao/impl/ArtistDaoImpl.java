package com.musicreview.dao.impl;

import com.musicreview.dao.ArtistDao;
import com.musicreview.model.Artist;
import com.musicreview.model.RecordLabel;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArtistDaoImpl implements ArtistDao {

    @Autowired
    private SessionFactory sessionFactory;

//TO-DO <------------------
    @Override
    public boolean existsByNickname(String nickname) {
        return false;
    }

    @Override
    public void save(Artist artist) {
        sessionFactory.getCurrentSession().save(artist);
    }

    @Override
    public void delete(Long id) {
Artist artist = (Artist) sessionFactory.getCurrentSession().load(
        Artist.class, id);
        if (null != artist) {
            sessionFactory.getCurrentSession().delete(artist);
        }
    }

    @Override
    public List<Artist> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from artist")
                .list();
    }

    @Override
    public List<RecordLabel> recordLabelsListForArtist(RecordLabel recordLabel) {
        return sessionFactory.getCurrentSession().createQuery("from record_label")
                .list();
    }

    @Override
    public RecordLabel findRecordLabel(long id) {


        RecordLabel recordLabel = (RecordLabel) sessionFactory.getCurrentSession().get(RecordLabel.class, id);

        return recordLabel;

    }

    @Override
    public Artist findByNickname(String artist_nickname) {
        Artist artist = (Artist) sessionFactory.getCurrentSession().get(Artist.class, artist_nickname);
        return artist;
    }
}

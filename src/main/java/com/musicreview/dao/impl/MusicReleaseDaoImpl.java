package com.musicreview.dao.impl;

import com.musicreview.dao.MusicReleaseDao;
import com.musicreview.model.MusicRelease;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class MusicReleaseDaoImpl implements MusicReleaseDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public MusicRelease findMusicReleaseByTitle(String release_title) {
        MusicRelease musicRelease = (MusicRelease) sessionFactory.getCurrentSession().get(MusicRelease.class, release_title);
        return musicRelease;
    }
//TO-DO<------
    @Override
    public boolean existsMusicReleaseByTitle(String release_title) {
        return false;
    }

    @Override
    public void save(MusicRelease musicRelease) {
  sessionFactory.getCurrentSession().save(musicRelease);
    }

    @Override
    public void delete(Long id) {
        MusicRelease musicRelease = (MusicRelease) sessionFactory.getCurrentSession().load(
                MusicRelease.class, id);
        if (null != musicRelease) {
            sessionFactory.getCurrentSession().delete(musicRelease);
        }

    }

    @Override
    public List<MusicRelease> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from music_release")
                .list();
    }
}

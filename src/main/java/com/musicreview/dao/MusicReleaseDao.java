package com.musicreview.dao;

import com.musicreview.model.MusicRelease;

import java.util.List;

public interface MusicReleaseDao {
    MusicRelease findMusicReleaseByTitle(String release_title);
    MusicRelease findById(long id);
    boolean existsMusicReleaseByTitle(String release_title);
    void save(MusicRelease musicRelease);
    void delete (Long id);
    List<MusicRelease> findAll();
}

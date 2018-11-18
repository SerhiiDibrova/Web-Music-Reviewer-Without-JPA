package com.musicreview.dao;

import com.musicreview.model.Artist;
import com.musicreview.model.RecordLabel;

import java.util.List;

public interface  ArtistDao {

    boolean existsByNickname(String nickname);

    void save(Artist artist);

     Artist findById(long id);
    void delete(Long id);

    List<Artist> findAll();

    List<RecordLabel> recordLabelsListForArtist(RecordLabel recordLabel);

    RecordLabel findRecordLabel(long id);

    Artist findByNickname( String artist_nickname);

}

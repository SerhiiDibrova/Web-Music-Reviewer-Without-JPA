package com.musicreview.service;

import com.musicreview.model.Artist;
import com.musicreview.model.RecordLabel;

import java.util.List;


public interface ArtistService {
    Artist getArtistByNickname(String nickname);

    boolean existsByNickname(String nickname);

    void addArtist(Artist artist);

    void updateArtist(Artist artist);

    void deleteArtist(Long id);

    List<Artist> artistList();

    List<RecordLabel> recordLabelsListForArtist(RecordLabel recordLabel);

    RecordLabel findRecordLabel(long id);
}

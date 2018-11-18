package com.musicreview.service.impl;

import com.musicreview.dao.ArtistDao;
import com.musicreview.dao.RecordLabelDao;
import com.musicreview.model.Artist;
import com.musicreview.model.RecordLabel;
import com.musicreview.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public abstract class ArtistServiceImpl implements ArtistService {

    private final ArtistDao artistRepository;

    private final RecordLabelDao recordLabelRepository;

    @Autowired
    public ArtistServiceImpl(ArtistDao artistRepository, RecordLabelDao recordLabelRepository) {
        this.artistRepository = artistRepository;
        this.recordLabelRepository = recordLabelRepository;
    }

    @Override
    @Transactional
    public Artist getArtistByNickname(String nickname) {
        return artistRepository.findByNickname(nickname);
    }

    @Override
    @Transactional
    public boolean existsByNickname(String nickname) {
        return artistRepository.existsByNickname(nickname);
    }

    @Override
    @Transactional
    public void addArtist(Artist artist) {
        Set <RecordLabel> recordLabels = new HashSet<>();
        recordLabels.add(recordLabelRepository.findById(1));
        artist.setRecordLabels(recordLabels);
        artistRepository.save(artist);
    }


    @Override
    @Transactional
    public void deleteArtist(Long id) {
 //       artistRepository.delete(getArtistByNickname(nickname));
        artistRepository.delete(id);
    }

    @Override
    @Transactional
    public List <Artist> artistList() {
        return artistRepository.findAll();
    }

    @Override
    @Transactional
    public List <RecordLabel> recordLabelsListForArtist(RecordLabel recordLabel) {return recordLabelRepository.findAll();}

    @Override
    public RecordLabel findRecordLabel(long id) {
        return recordLabelRepository.findById(id);
    }
}

package com.musicreview.service.impl;

import com.musicreview.model.Artist;
import com.musicreview.model.RecordLabel;
import com.musicreview.service.RecordLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class RecordLabelServiceImpl implements RecordLabelService {

    private final RecordLabelRepository recordLabelRepository;

    private final ArtistRepository artistRepository;

    @Autowired
    public RecordLabelServiceImpl(RecordLabelRepository recordLabelRepository, ArtistRepository artistRepository) {
        this.recordLabelRepository = recordLabelRepository;
        this.artistRepository = artistRepository;
    }

    @Override
    public RecordLabel getRecordLabelByName(String label_name) {
        return recordLabelRepository.findByRecordLabelName(label_name);
    }

    @Override
    public boolean existsRecordLabelByName(String label_name) {
        return recordLabelRepository.existsByRecordLabelName(label_name);
    }

    @Override
    @Transactional
    public void addRecordLabel(RecordLabel recordLabel) {
        Set<Artist> artistSet = new HashSet<>();
        artistSet.add(artistRepository.getOne(1L));
        recordLabel.setArtistsList(artistSet);
        recordLabelRepository.save(recordLabel);
    }

    @Override
    public void updateRecordLabel(RecordLabel recordLabel) {
        recordLabelRepository.save(recordLabel);
    }

    @Override
    public void deleteRecordLabel(Long id) {
        recordLabelRepository.delete(id);
    }

    @Override
    public List<RecordLabel> recordLabelList() {
        return recordLabelRepository.findAll();
    }
    
}

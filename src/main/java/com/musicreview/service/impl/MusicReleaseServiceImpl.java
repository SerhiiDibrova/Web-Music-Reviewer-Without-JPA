package com.musicreview.service.impl;

import com.musicreview.dao.MusicReleaseDao;
import com.musicreview.dao.RecordLabelDao;
import com.musicreview.model.MusicRelease;
import com.musicreview.model.RecordLabel;
import com.musicreview.service.MusicReleaseService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MusicReleaseServiceImpl implements MusicReleaseService {
	
	private Logger log = Logger.getLogger(MusicReleaseServiceImpl.class);

    private final MusicReleaseDao musicReleaseRepository;

    private final RecordLabelDao recordLabelRepository;

    @Autowired
    public MusicReleaseServiceImpl(MusicReleaseDao musicReleaseRepository, RecordLabelDao recordLabelRepository) {
        this.musicReleaseRepository = musicReleaseRepository;
        this.recordLabelRepository = recordLabelRepository;
    }

    @Override
    @Transactional
    public MusicRelease getMusicReleaseByTitle(String release_title) {
        return musicReleaseRepository.findMusicReleaseByTitle(release_title);
    }

    @Override
    @Transactional
    public boolean existsMusicReleaseByTitle(String release_title) {
        return musicReleaseRepository.existsMusicReleaseByTitle(release_title);
    }

    @Override
    @Transactional
    public void addMusicRelease(MusicRelease musicRelease) {
        Set<RecordLabel> recordLabels = new HashSet<>();
        recordLabels.add(recordLabelRepository.findById(1));
        log.info(recordLabels.toString());
//        musicRelease.setRecord_label(recordLabels.);
        musicReleaseRepository.save(musicRelease);
    }

    @Override
    public void updateMusicRelease(MusicRelease musicRelease) {
        musicReleaseRepository.save(musicRelease);
    }

    @Override
    public void deleteMusicRelease(Long id) {
        musicReleaseRepository.delete(id);
    }

    @Override
    public List<MusicRelease> musicReleaseList() {
        return musicReleaseRepository.findAll();
    }
}

package com.musicreview.service;

import com.musicreview.model.MusicRelease;

import java.util.List;

public interface MusicReleaseService {

    MusicRelease getMusicReleaseByTitle(String release_title);
    boolean existsMusicReleaseByTitle(String release_title);
    void addMusicRelease(MusicRelease musicRelease);
    void updateMusicRelease(MusicRelease musicRelease);
    void deleteMusicRelease (Long id);
    List<MusicRelease> musicReleaseList();
}

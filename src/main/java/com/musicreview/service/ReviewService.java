package com.musicreview.service;

import com.musicreview.model.MusicRelease;
import com.musicreview.model.Review;

import java.util.List;

public interface ReviewService {
    Review getReviewByName(String review_name);

    boolean existsByReviewName(String review_name);

    void addReview(Review review);

    void updateReview(Review review);

    void deleteReview(Long id);

    List<Review> reviewList();

    List<MusicRelease> musicReleaseLinkedToReview(MusicRelease musicRelease);

    MusicRelease findMusicRelease(long id);
}


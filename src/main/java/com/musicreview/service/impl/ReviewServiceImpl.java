package com.musicreview.service.impl;

import com.musicreview.dao.MusicReleaseDao;
import com.musicreview.dao.ReviewDao;
import com.musicreview.model.MusicRelease;
import com.musicreview.model.Review;
import com.musicreview.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewDao reviewRepository;

    private final MusicReleaseDao musicReleaseRepository;

    @Autowired
    public ReviewServiceImpl(ReviewDao reviewRepository, MusicReleaseDao musicReleaseRepository) {
        this.reviewRepository = reviewRepository;
        this.musicReleaseRepository = musicReleaseRepository;
    }

    @Override
    public Review getReviewByName(String review_name) {
        return reviewRepository.findReviewByName(review_name);
    }

    @Override
    public boolean existsByReviewName(String review_name) {
        return reviewRepository.existsByReviewName(review_name);
    }

    @Override
    public void addReview(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public void updateReview(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public void deleteReview(Long id) {
        reviewRepository.delete(id);
    }

    @Override
    public List<Review> reviewList() {
        return reviewRepository.findAll();
    }

    @Override
    public List<MusicRelease> musicReleaseLinkedToReview(MusicRelease musicRelease) {
        return musicReleaseRepository.findAll();
    }

    @Override
    public MusicRelease findMusicRelease(long id) {
        return musicReleaseRepository.findOne(1L);
    }
}

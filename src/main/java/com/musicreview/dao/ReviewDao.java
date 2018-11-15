package com.musicreview.dao;

import com.musicreview.model.Review;

import java.util.List;

public interface ReviewDao  {

    Review findReviewByName(String review_name);

    boolean existsByReviewName(String review_name);

    void save(Review review);

    void delete(Long id);

    List<Review> findAll();


}

package com.musicreview.dao.impl;

import com.musicreview.dao.ReviewDao;
import com.musicreview.model.Review;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ReviewDaoImpl implements ReviewDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Review findReviewByName(String review_name) {
        Review review = (Review) sessionFactory.getCurrentSession().get(Review.class,review_name);

        return review;
    }

    @Override
    public boolean existsByReviewName(String review_name) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "select count(*) from Review r where m.review_name = :review_name");
        query.setString("review_name", review_name);
        Long count = (Long)query.uniqueResult();

        if(count>0) return true;
        return false;
    }

    @Override
    public void save(Review review) {
sessionFactory.getCurrentSession().save(review);
    }


    @Override
    public void delete(Long id) {
        Review review = (Review) sessionFactory.getCurrentSession().load(
                Review.class, id);
        if (null != review) {
            sessionFactory.getCurrentSession().delete(review);
        }
    }

    @Override
    public List<Review> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from review")
                .list();
    }


}

package com.musicreview.dao.impl;

import com.musicreview.dao.UserDao;
import com.musicreview.model.CustomUser;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public CustomUser findByLogin(String login) {
        CustomUser user = (CustomUser) sessionFactory.getCurrentSession().get(CustomUser.class,login);
        return user;
    }

    @Override
    public boolean existsByLogin(String login) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "select count(*) from CustomUser c where c.login = :login");
        query.setString("login", login);
        Long count = (Long)query.uniqueResult();

        if(count>0) return true;
        return false;
    }

    @Override
    public void save(CustomUser customUser) {
 sessionFactory.getCurrentSession().save(customUser);
    }
}

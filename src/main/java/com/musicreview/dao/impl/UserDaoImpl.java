package com.musicreview.dao.impl;

import com.musicreview.dao.UserDao;
import com.musicreview.model.CustomUser;
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
//TO-DO <-------
    @Override
    public boolean existsByLogin(String login) {
        return false;
    }

    @Override
    public void save(CustomUser customUser) {
 sessionFactory.getCurrentSession().save(customUser);
    }
}

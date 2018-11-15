package com.musicreview.dao;

import com.musicreview.model.CustomUser;

public interface UserDao {
    CustomUser findByLogin(String login);
    boolean existsByLogin(String login);
    void save(CustomUser customUser);

}

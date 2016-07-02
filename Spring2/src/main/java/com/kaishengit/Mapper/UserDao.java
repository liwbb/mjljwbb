package com.kaishengit.Mapper;

import com.kaishengit.pojo.User;

public interface UserDao {
    void save(User user);
    User findById(Integer id);
    User findByName(String name);
}

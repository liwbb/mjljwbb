package com.kaishengit.Mapper;

import com.kaishengit.pojo.Admin;

public interface AdminDao {
    void save(Admin admin);
    Admin findOne(Integer id);
    Admin findByName(String name);
}

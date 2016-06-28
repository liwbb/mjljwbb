package com.kaishengit.Maspper;

import com.kaishengit.pojo.Admin;

import java.util.List;
import java.util.Map;

public interface AdminMapper {
    void save(Admin admin);
    void saveAll(List<Admin> admins);
    List<Admin> queryMap(Map<String,Object> map);
    List<Admin> queryMapId(List<Integer> Idlist);
    List<Admin> queryMapparam(Map<String,Object> param);

}

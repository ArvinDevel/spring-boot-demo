package com.example.restservice.service;

import com.example.restservice.dao.Authority;
import com.example.restservice.dao.User;

import java.util.List;

public interface UserAndAuthorityService {
    public void saveAll();

    public List<User> findByAuthorityList_id(int id);

    public List<User> findByAuthorityList_name(String name);

    public List<Authority> findByUserList_id(int id);

    public List<Authority> findByUserList_Username(String username);

    public List<Authority> findByUserListUsername(String username);
}

package com.bailiban.springboot.service;

import com.bailiban.springboot.model.User;

public interface UserService {

    User login(User user);
    User get(int id);
    int update(User user);
    int insert(User user);
}

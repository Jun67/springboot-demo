package com.bailiban.springboot.service.impl;

import com.bailiban.springboot.mapper.UserMapper;
import com.bailiban.springboot.model.User;
import com.bailiban.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        User u = userMapper.findUser(user);
        return u;
    }
}

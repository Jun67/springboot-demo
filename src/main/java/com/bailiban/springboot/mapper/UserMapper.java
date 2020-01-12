package com.bailiban.springboot.mapper;

import com.bailiban.springboot.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User findUser(User user);
}

package com.example.cmsspringboot.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.example.cmsspringboot.model.User;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM users WHERE username = #{username}")
    User findByUsername(String username);

    @Insert("INSERT INTO users(username, password, role) VALUES(#{username}, #{password}, 'USER')")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(User user);
}       

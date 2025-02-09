package com.learningspringboot.__SpringBootCrudOperation_Project1.service;


import com.learningspringboot.__SpringBootCrudOperation_Project1.dto.UserDto;
import com.learningspringboot.__SpringBootCrudOperation_Project1.entity.User;

import java.util.List;


public interface UserService {
    UserDto createUser(UserDto user);
    UserDto getUserById(Integer id);
    List<UserDto> getAllUser();
    UserDto updateUser(UserDto user);
    void deleteUser(Integer id);
}


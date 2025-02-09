package com.learningspringboot.__SpringBootCrudOperation_Project1.mapper;

import com.learningspringboot.__SpringBootCrudOperation_Project1.dto.UserDto;
import com.learningspringboot.__SpringBootCrudOperation_Project1.entity.User;

public class UserMapper {
    public static UserDto mapToUserDto(User user){
        return new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
    }
    public static User mapToUser(UserDto userDto){
        return new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail()
        );
    }
}

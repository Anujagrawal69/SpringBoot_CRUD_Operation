package com.learningspringboot.__SpringBootCrudOperation_Project1.mapper;

import com.learningspringboot.__SpringBootCrudOperation_Project1.dto.UserDto;
import com.learningspringboot.__SpringBootCrudOperation_Project1.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoUserMapper {
    AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);

    UserDto mapToUserDto(User user);
    User mapToUser(UserDto userDto);
}

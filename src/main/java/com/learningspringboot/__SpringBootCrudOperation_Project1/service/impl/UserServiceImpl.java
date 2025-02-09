package com.learningspringboot.__SpringBootCrudOperation_Project1.service.impl;

import com.learningspringboot.__SpringBootCrudOperation_Project1.dto.UserDto;
import com.learningspringboot.__SpringBootCrudOperation_Project1.entity.User;
import com.learningspringboot.__SpringBootCrudOperation_Project1.exception.EmailAlreadyExistsException;
import com.learningspringboot.__SpringBootCrudOperation_Project1.exception.ResourceNotFoundException;
import com.learningspringboot.__SpringBootCrudOperation_Project1.mapper.AutoUserMapper;
import com.learningspringboot.__SpringBootCrudOperation_Project1.mapper.UserMapper;
import com.learningspringboot.__SpringBootCrudOperation_Project1.repository.UserRepository;
import com.learningspringboot.__SpringBootCrudOperation_Project1.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    public UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
//        Convert userDto to user entity
//        User user = UserMapper.mapToUser(userDto);

//        User user = modelMapper.map(userDto, User.class);

        Optional<User> userWithEmail = userRepository.findUserByEmail(userDto.getEmail());
        if(userWithEmail.isPresent()){
            throw new EmailAlreadyExistsException("Email Already Exists for User");
        }

        User user = AutoUserMapper.MAPPER.mapToUser(userDto);

        User savedUser = userRepository.save(user);

//        Convert user entity to userDto
//        return UserMapper.mapToUserDto(user);

//        return modelMapper.map(savedUser, UserDto.class);
        return AutoUserMapper.MAPPER.mapToUserDto(savedUser);
    }

    @Override
    public UserDto getUserById(Integer id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User", "Id", id)
        );

//        Mapping is done here
//        return UserMapper.mapToUserDto(user);

//        return modelMapper.map(user, UserDto.class);
        return AutoUserMapper.MAPPER.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> users = userRepository.findAll();
//        return users.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());

//        return users.stream().map((user) -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
        return users.stream().map((user) -> AutoUserMapper.MAPPER.mapToUserDto(user)).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        User existingUser = userRepository.findById(userDto.getId()).orElseThrow(
                ()-> new ResourceNotFoundException("User", "Id", userDto.getId())
        );
        existingUser.setFirstName(userDto.getFirstName());
        existingUser.setLastName(userDto.getLastName());
        existingUser.setEmail(userDto.getEmail());
        User updatedUser = userRepository.save(existingUser);

//        Mapping is done here
//        return UserMapper.mapToUserDto(updatedUser);
//        return modelMapper.map(updatedUser, UserDto.class);
        return AutoUserMapper.MAPPER.mapToUserDto(updatedUser);
    }

    @Override
    public void deleteUser(Integer id) {
        User existingUser = userRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("User", "Id", id)
        );
        userRepository.deleteById(id);
    }


}


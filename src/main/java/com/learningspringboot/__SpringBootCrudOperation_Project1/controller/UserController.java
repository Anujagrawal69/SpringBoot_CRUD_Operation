package com.learningspringboot.__SpringBootCrudOperation_Project1.controller;

import com.learningspringboot.__SpringBootCrudOperation_Project1.dto.UserDto;
import com.learningspringboot.__SpringBootCrudOperation_Project1.entity.User;
import com.learningspringboot.__SpringBootCrudOperation_Project1.exception.ErrorDetails;
import com.learningspringboot.__SpringBootCrudOperation_Project1.exception.ResourceNotFoundException;
import com.learningspringboot.__SpringBootCrudOperation_Project1.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;

@Tag(
        name = "CRUD REST APIs Created",
        description = "REST APIs - Create User, Update User, Get User, Get All User, Delete User"
)
@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {
    @Autowired
    private UserService userService;

    @Operation(summary = "Create User API", description = "Create User REST API is used to create new user in database.")
    @ApiResponse(responseCode = "201", description = "HTTP Status 201 Created")
    @PostMapping()
    public ResponseEntity<UserDto> createUser(@RequestBody @Valid UserDto user){
        UserDto savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @Operation(summary = "Get User By ID API", description = "Get User By ID REST API is used to get single user by id from database.")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 Success")
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Integer id){
        UserDto userDto = userService.getUserById(id);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @Operation(summary = "Get All User API", description = "Get All User REST API is used to get all user from database.")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 Success")
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> users = userService.getAllUser();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @Operation(summary = "Update User API", description = "Update User REST API is used to update user in database.")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 Success")
    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Integer id, @RequestBody @Valid UserDto user){
        user.setId(id);
        UserDto u = userService.updateUser(user);
        return new ResponseEntity<>(u, HttpStatus.OK);
    }

    @Operation(summary = "Delete User API", description = "Delete User REST API is used to Delete user from database.")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 Success")
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return new ResponseEntity<>("Deleted Successful", HttpStatus.OK);
    }

//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception,
//                                                                        WebRequest webRequest){
//        ErrorDetails errorDetails = new ErrorDetails(
//                LocalDateTime.now(),
//                webRequest.getDescription(false),
//                exception.getMessage(),
//                "USER_NOT_FOUND"
//        );
//        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
//    }
}


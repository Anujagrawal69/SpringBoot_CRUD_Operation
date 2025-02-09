package com.learningspringboot.__SpringBootCrudOperation_Project1.dto;

import com.learningspringboot.__SpringBootCrudOperation_Project1.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

import java.util.function.Function;

public class UserDto {

    private Integer id;
    @NotEmpty(message = "First name should not be empty!")
    private String firstName;
    @NotEmpty(message = "Last name should not be empty!")
    private String lastName;
    @NotEmpty(message = "Valid email address not provided")
    @Email
    private String email;

    public UserDto() {
    }

    public UserDto(Integer id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

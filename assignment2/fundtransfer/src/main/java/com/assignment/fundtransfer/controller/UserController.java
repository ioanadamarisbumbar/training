package com.assignment.fundtransfer.controller;

import com.assignment.fundtransfer.dto.UserDto;
import com.assignment.fundtransfer.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
@Tag(name = "User")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public UserDto registerUser(@Valid @RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }
}

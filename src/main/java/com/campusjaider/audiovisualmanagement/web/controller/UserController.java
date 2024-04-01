package com.campusjaider.audiovisualmanagement.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campusjaider.audiovisualmanagement.domain.service.UserService;
import com.campusjaider.audiovisualmanagement.persistence.dto.UserDTO;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDTO userDTO) throws ReflectiveOperationException {
        UserDTO userRegister = userService.registerUser(userDTO);
        if (userRegister == null) {
            throw new Error("Cannot created user");
        }
        return ResponseEntity.ok(userDTO);
    }

}

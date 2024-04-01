package com.campusjaider.audiovisualmanagement.web.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.campusjaider.audiovisualmanagement.domain.exception.InvalidInputException;
import com.campusjaider.audiovisualmanagement.domain.service.UserService;
import com.campusjaider.audiovisualmanagement.persistence.dto.UserDTO;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestParam("nameUser") String nameUser,
            @RequestParam("password") String password) {

        UserDTO userDTO = userService.loginUser(nameUser, password);
        if (userDTO == null) {
            throw new UsernameNotFoundException("User or Password Invalid");
        }
        return ResponseEntity.ok().body(userDTO);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDTO userDTO) throws ReflectiveOperationException {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(userDTO.getEmailUser());
        if (matcher.matches()) {
            UserDTO userRegister = userService.registerUser(userDTO);
            if (userRegister == null) {
                throw new Error("Cannot created user");
            }
            return ResponseEntity.ok(userRegister);
        } else {
            throw new InvalidInputException("invalid email");
        }
    }

}

package com.campusjaider.audiovisualmanagement.web.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.campusjaider.audiovisualmanagement.domain.exception.InvalidInputException;
import com.campusjaider.audiovisualmanagement.domain.exception.InvalidOperationException;
import com.campusjaider.audiovisualmanagement.domain.service.UserService;
import com.campusjaider.audiovisualmanagement.persistence.dto.UserDTO;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(
            @RequestParam("nameUser") String nameUser,
            @RequestParam("password") String password) {

        UserDTO userDTO = userService.loginUser(nameUser, password);
        if (userDTO == null) {
            throw new UsernameNotFoundException("User or Password Invalid");
        }
        return ResponseEntity.ok().body(userDTO);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestParam("nameUser") String nameUser,
            @RequestParam("password") String password, @RequestParam("emailUser") String emailUser)
            throws ReflectiveOperationException {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(emailUser);
        if (matcher.matches()) {
            UserDTO userDTO = new UserDTO();
            userDTO.setNameUser(nameUser);
            userDTO.setEmailUser(emailUser);
            userDTO.setPassword(password);

            UserDTO userRegister = userService.registerUser(userDTO);
            if (userRegister == null) {
                throw new Error("Cannot create user");
            }
            return ResponseEntity.ok(userRegister);
        } else {
            throw new InvalidInputException("invalid email");
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteUser(
            @RequestParam("nameUser") String nameUser,
            @RequestParam("password") String password) {

        Boolean succeed = userService.deleteUser(nameUser, password);
        if (!succeed) {
            throw new InvalidOperationException("Cannot delete user");
        }
        Map<String, Object> response = new HashMap<>();
        response.put("message", "User deleted succesfully");
        return ResponseEntity.ok().body(response);
    }

}

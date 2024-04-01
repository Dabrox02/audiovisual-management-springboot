package com.campusjaider.audiovisualmanagement.domain.service.impl;

import java.lang.reflect.InvocationTargetException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.campusjaider.audiovisualmanagement.domain.repository.UserRepository;
import com.campusjaider.audiovisualmanagement.domain.security.JWTAuthorizationFilter;
import com.campusjaider.audiovisualmanagement.domain.security.JWTAuthtenticationConfig;
import com.campusjaider.audiovisualmanagement.domain.service.UserService;
import com.campusjaider.audiovisualmanagement.persistence.converter.Converter;
import com.campusjaider.audiovisualmanagement.persistence.dto.UserDTO;
import com.campusjaider.audiovisualmanagement.persistence.entity.UserEntity;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    JWTAuthtenticationConfig jwtAuthtenticationConfig;

    @Autowired
    JWTAuthorizationFilter jwtAuthorizationFilter;

    @Override
    @Transactional
    public UserDTO loginUser(String nameUser, String password) {
        UserEntity user = userRepository.findByNameUser(nameUser).orElse(null);

        if (user != null) {
            if (passwordEncoder.matches(password, user.getPassword())) {
                String token = jwtAuthtenticationConfig.getJWTToken(user.getNameUser());
                UserDTO userDTO = new UserDTO();
                userDTO.setNameUser(user.getNameUser());
                userDTO.setEmailUser(user.getEmailUser());
                userDTO.setToken(token);
                return userDTO;
            }
        }
        return null;
    }

    @Override
    @Transactional
    public UserDTO registerUser(UserDTO userDTO) throws ReflectiveOperationException {
        try {
            userDTO.setUserId(null);
            userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            UserEntity user = Converter.convertTo(userDTO, UserEntity.class);

            UserEntity userEntityResponse = userRepository.save(user);
            if (userEntityResponse != null) {
                UserDTO userDtoResponse = Converter.convertTo(userEntityResponse, UserDTO.class);
                userDtoResponse.setPassword(null);
                return userDtoResponse;
            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException
                | InstantiationException e) {
            throw new ReflectiveOperationException("Error in the data entered");
        }
        return null;
    }

    @Override
    @Transactional
    public Boolean deleteUser(String nameUser, String password) {
        UserDTO user = loginUser(nameUser, password);
        if (user != null) {
            userRepository.deleteByNameUser(nameUser);
            return true;
        } else {
            return false;
        }
    }

}

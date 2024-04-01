package com.campusjaider.audiovisualmanagement.domain.service.impl;

import java.lang.reflect.InvocationTargetException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusjaider.audiovisualmanagement.domain.repository.UserRepository;
import com.campusjaider.audiovisualmanagement.domain.service.UserService;
import com.campusjaider.audiovisualmanagement.persistence.converter.Converter;
import com.campusjaider.audiovisualmanagement.persistence.dto.UserDTO;
import com.campusjaider.audiovisualmanagement.persistence.entity.UserEntity;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO loginUser(String nameUser, String password) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'loginUser'");
    }

    @Override
    public UserDTO registerUser(UserDTO userDTO) throws ReflectiveOperationException {
        try {
            userDTO.setUserId(null);
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
    public Boolean deleteUser(String nameUser, String password) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteUser'");
    }

}

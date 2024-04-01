package com.campusjaider.audiovisualmanagement.domain.service;

import com.campusjaider.audiovisualmanagement.persistence.dto.UserDTO;

public interface UserService {

    UserDTO loginUser(String nameUser, String password);

    UserDTO registerUser(UserDTO userDTO) throws ReflectiveOperationException;

    Boolean deleteUser(String nameUser, String password);
}

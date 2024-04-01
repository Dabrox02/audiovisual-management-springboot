package com.campusjaider.audiovisualmanagement.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campusjaider.audiovisualmanagement.persistence.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

}

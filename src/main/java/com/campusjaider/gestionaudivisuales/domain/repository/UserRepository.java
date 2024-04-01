package com.campusjaider.gestionaudivisuales.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campusjaider.gestionaudivisuales.persistence.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

}

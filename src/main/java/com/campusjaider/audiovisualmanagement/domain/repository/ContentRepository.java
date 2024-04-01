package com.campusjaider.audiovisualmanagement.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campusjaider.audiovisualmanagement.persistence.entity.ContentEntity;
import com.campusjaider.audiovisualmanagement.persistence.entity.UserEntity;

import java.util.List;


public interface ContentRepository extends JpaRepository<ContentEntity, Integer> {
    List<ContentEntity> findByUserEntity(UserEntity userEntity);
}

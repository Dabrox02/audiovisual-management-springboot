package com.campusjaider.audiovisualmanagement.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campusjaider.audiovisualmanagement.persistence.entity.ContentEntity;

public interface ContentRepository extends JpaRepository<ContentEntity, Integer> {

}

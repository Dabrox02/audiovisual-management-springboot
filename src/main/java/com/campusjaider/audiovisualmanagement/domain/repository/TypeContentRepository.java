package com.campusjaider.audiovisualmanagement.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campusjaider.audiovisualmanagement.persistence.entity.TypeContentEntity;

public interface TypeContentRepository extends JpaRepository<TypeContentEntity, Integer> {

}

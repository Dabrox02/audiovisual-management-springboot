package com.campusjaider.audiovisualmanagement.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campusjaider.audiovisualmanagement.persistence.entity.PlatformEntity;

public interface PlatformRepository extends JpaRepository<PlatformEntity, Integer> {

}

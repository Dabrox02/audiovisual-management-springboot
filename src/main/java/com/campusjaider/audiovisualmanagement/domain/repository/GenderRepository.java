package com.campusjaider.audiovisualmanagement.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campusjaider.audiovisualmanagement.persistence.entity.GenderEntity;

public interface GenderRepository extends JpaRepository<GenderEntity, Integer>{
    
}

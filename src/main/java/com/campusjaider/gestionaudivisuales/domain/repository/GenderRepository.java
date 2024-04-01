package com.campusjaider.gestionaudivisuales.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campusjaider.gestionaudivisuales.persistence.entity.GenderEntity;

public interface GenderRepository extends JpaRepository<GenderEntity, Integer>{
    
}

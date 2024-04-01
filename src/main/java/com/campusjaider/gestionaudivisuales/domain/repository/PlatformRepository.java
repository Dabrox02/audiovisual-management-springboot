package com.campusjaider.gestionaudivisuales.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campusjaider.gestionaudivisuales.persistence.entity.PlatformEntity;

public interface PlatformRepository extends JpaRepository<PlatformEntity, Integer> {

}

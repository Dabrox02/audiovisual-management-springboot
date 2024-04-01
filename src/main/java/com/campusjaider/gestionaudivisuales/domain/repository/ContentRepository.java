package com.campusjaider.gestionaudivisuales.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campusjaider.gestionaudivisuales.persistence.entity.ContentEntity;

public interface ContentRepository extends JpaRepository<ContentEntity, Integer> {

}

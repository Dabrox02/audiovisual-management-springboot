package com.campusjaider.gestionaudivisuales.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_platform")
public class PlatformEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer platformId;

    @Column(nullable = false, length = 100)
    private String namePlatform;

    @ManyToOne
    @JoinColumn(name = "type_content_id", nullable = false)
    private TypeContentEntity typeContentEntity;

}

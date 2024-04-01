package com.campusjaider.audiovisualmanagement.persistence.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_content")
public class ContentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contentId;

    @Column(nullable = false, length = 100)
    private String nameContent;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusDisplayEnum statusDisplay;

    @Column(nullable = false, precision = 3, scale = 1)
    private BigDecimal qualification;

    @Column(nullable = false, length = 500)
    private String comment;

    @ManyToOne
    @JoinColumn(name = "type_content_id", nullable = false)
    private TypeContentEntity typeContentEntity;

    @ManyToOne
    @JoinColumn(name = "platform_id", nullable = false)
    private PlatformEntity platformEntity;

    @ManyToOne
    @JoinColumn(name = "gender1", nullable = false)
    private GenderEntity genderEntity1;

    @ManyToOne
    @JoinColumn(name = "gender2", nullable = false)
    private GenderEntity genderEntity2;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity userEntity;

}

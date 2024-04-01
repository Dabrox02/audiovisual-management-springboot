package com.campusjaider.audiovisualmanagement.persistence.entity;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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

    @Column(nullable = true, precision = 3, scale = 1)
    private BigDecimal qualification;

    @Column(nullable = true, length = 500)
    private String comment;

    @ManyToOne
    @JoinColumn(name = "type_content_id", nullable = false)
    @JsonManagedReference
    private TypeContentEntity typeContentEntity;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "platform_id", nullable = false)
    private PlatformEntity platformEntity;

    @ManyToOne
    @JoinColumn(name = "gender1", nullable = false)
    private GenderEntity genderEntity1;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "gender2", nullable = true)
    private GenderEntity genderEntity2;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity userEntity;

    public Integer getContentId() {
        return this.contentId;
    }

    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    public String getNameContent() {
        return this.nameContent;
    }

    public void setNameContent(String nameContent) {
        this.nameContent = nameContent;
    }

    public StatusDisplayEnum getStatusDisplay() {
        return this.statusDisplay;
    }

    public void setStatusDisplay(StatusDisplayEnum statusDisplay) {
        this.statusDisplay = statusDisplay;
    }

    public BigDecimal getQualification() {
        return this.qualification;
    }

    public void setQualification(BigDecimal qualification) {
        this.qualification = qualification;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public TypeContentEntity getTypeContentEntity() {
        return this.typeContentEntity;
    }

    public void setTypeContentEntity(TypeContentEntity typeContentEntity) {
        this.typeContentEntity = typeContentEntity;
    }

    public PlatformEntity getPlatformEntity() {
        return this.platformEntity;
    }

    public void setPlatformEntity(PlatformEntity platformEntity) {
        this.platformEntity = platformEntity;
    }

    public GenderEntity getGenderEntity1() {
        return this.genderEntity1;
    }

    public void setGenderEntity1(GenderEntity genderEntity1) {
        this.genderEntity1 = genderEntity1;
    }

    public GenderEntity getGenderEntity2() {
        return this.genderEntity2;
    }

    public void setGenderEntity2(GenderEntity genderEntity2) {
        this.genderEntity2 = genderEntity2;
    }

    public UserEntity getUserEntity() {
        return this.userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

}

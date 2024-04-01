package com.campusjaider.gestionaudivisuales.persistence.dto;

import java.math.BigDecimal;

import com.campusjaider.gestionaudivisuales.persistence.entity.StatusDisplayEnum;

public class ContentDTO {
    private Integer contentId;
    private String nameContent;
    private StatusDisplayEnum statusDisplay;
    private BigDecimal qualification;
    private String comment;
    private Integer typeContentId;
    private Integer platformId;
    private Integer genderId1;
    private Integer genderId2;
    private Integer userId;

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

    public Integer getTypeContentId() {
        return this.typeContentId;
    }

    public void setTypeContentId(Integer typeContentId) {
        this.typeContentId = typeContentId;
    }

    public Integer getPlatformId() {
        return this.platformId;
    }

    public void setPlatformId(Integer platformId) {
        this.platformId = platformId;
    }

    public Integer getGenderId1() {
        return this.genderId1;
    }

    public void setGenderId1(Integer genderId1) {
        this.genderId1 = genderId1;
    }

    public Integer getGenderId2() {
        return this.genderId2;
    }

    public void setGenderId2(Integer genderId2) {
        this.genderId2 = genderId2;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

}

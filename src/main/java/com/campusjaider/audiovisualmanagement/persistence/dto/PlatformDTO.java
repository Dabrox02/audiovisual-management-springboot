package com.campusjaider.audiovisualmanagement.persistence.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlatformDTO {
    private Integer platformId;
    private String namePlatform;
    private Integer typeContentId;

    public Integer getPlatformId() {
        return this.platformId;
    }

    public void setPlatformId(Integer platformId) {
        this.platformId = platformId;
    }

    public String getNamePlatform() {
        return this.namePlatform;
    }

    public void setNamePlatform(String namePlatform) {
        this.namePlatform = namePlatform;
    }

    public Integer getTypeContentId() {
        return this.typeContentId;
    }

    public void setTypeContentId(Integer typeContentId) {
        this.typeContentId = typeContentId;
    }

}

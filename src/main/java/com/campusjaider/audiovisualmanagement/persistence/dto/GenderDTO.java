package com.campusjaider.audiovisualmanagement.persistence.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GenderDTO {
    private Integer genderId;
    private String nameGender;

    public Integer getGenderId() {
        return this.genderId;
    }

    public void setGenderId(Integer genderId) {
        this.genderId = genderId;
    }

    public String getNameGender() {
        return this.nameGender;
    }

    public void setNameGender(String nameGender) {
        this.nameGender = nameGender;
    }

}

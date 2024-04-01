package com.campusjaider.audiovisualmanagement.persistence.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TypeContentDTO {
    private Integer typeContentId;
    private String nameTypeContent;

    public Integer getTypeContentId() {
        return this.typeContentId;
    }

    public void setTypeContentId(Integer typeContentId) {
        this.typeContentId = typeContentId;
    }

    public String getNameTypeContent() {
        return this.nameTypeContent;
    }

    public void setNameTypeContent(String nameTypeContent) {
        this.nameTypeContent = nameTypeContent;
    }

}

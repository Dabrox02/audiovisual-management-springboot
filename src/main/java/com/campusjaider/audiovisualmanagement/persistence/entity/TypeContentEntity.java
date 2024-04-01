package com.campusjaider.audiovisualmanagement.persistence.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_type_content")
public class TypeContentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer typeContentId;

    @Column(unique = true, nullable = false, length = 60)
    private String nameTypeContent;

    @ManyToMany(mappedBy = "typeContents", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    List<PlatformEntity> platforms;


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

    public List<PlatformEntity> getPlatforms() {
        return this.platforms;
    }

    public void setPlatforms(List<PlatformEntity> platforms) {
        this.platforms = platforms;
    }

}

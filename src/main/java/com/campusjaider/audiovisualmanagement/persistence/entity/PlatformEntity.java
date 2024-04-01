package com.campusjaider.audiovisualmanagement.persistence.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_platform")
public class PlatformEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer platformId;

    @Column(nullable = false, length = 100)
    private String namePlatform;

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinTable(name = "tbl_platform_type_content")
    private List<TypeContentEntity> typeContents;

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

    public List<TypeContentEntity> getTypeContents() {
        return this.typeContents;
    }

    public void setTypeContents(List<TypeContentEntity> typeContents) {
        this.typeContents = typeContents;
    }

}

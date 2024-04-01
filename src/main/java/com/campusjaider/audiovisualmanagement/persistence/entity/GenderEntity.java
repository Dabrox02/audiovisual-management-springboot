package com.campusjaider.audiovisualmanagement.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_gender")
public class GenderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer genderId;

    @Column(unique = true, nullable = false, length = 50)
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

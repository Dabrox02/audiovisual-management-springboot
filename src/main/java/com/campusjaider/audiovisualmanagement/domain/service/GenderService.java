package com.campusjaider.audiovisualmanagement.domain.service;

import java.util.List;

import com.campusjaider.audiovisualmanagement.persistence.entity.GenderEntity;

public interface GenderService {
    GenderEntity saveGender(String nameGender);
    List<GenderEntity> getAllGender();
}

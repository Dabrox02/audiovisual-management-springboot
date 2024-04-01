package com.campusjaider.audiovisualmanagement.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusjaider.audiovisualmanagement.domain.repository.GenderRepository;
import com.campusjaider.audiovisualmanagement.domain.service.GenderService;
import com.campusjaider.audiovisualmanagement.persistence.entity.GenderEntity;

@Service
public class GenderServiceImpl implements GenderService {

    @Autowired
    private GenderRepository genderRepository;

    @Override
    public GenderEntity saveGender(String nameGender) {
        GenderEntity genderEntity = new GenderEntity();
        genderEntity.setNameGender(nameGender);
        return genderRepository.save(genderEntity);
    }

}

package com.campusjaider.audiovisualmanagement.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusjaider.audiovisualmanagement.domain.repository.PlatformRepository;
import com.campusjaider.audiovisualmanagement.domain.service.PlatformService;
import com.campusjaider.audiovisualmanagement.persistence.dto.PlatformDTO;
import com.campusjaider.audiovisualmanagement.persistence.entity.PlatformEntity;

@Service
public class PlatformServiceImpl implements PlatformService {

    @Autowired
    private PlatformRepository platformRepository;

    @Override
    public PlatformDTO saveGender(String namePlatform) {
        PlatformEntity platformEntity = new PlatformEntity();
        platformEntity.setNamePlatform(namePlatform);
        PlatformEntity platformEntityResponse = platformRepository.save(platformEntity);
        PlatformDTO platformResponse = new PlatformDTO();
        platformResponse.setPlatformId(platformEntityResponse.getPlatformId());
        platformResponse.setNamePlatform(platformEntityResponse.getNamePlatform());
        return platformResponse;
    }

}

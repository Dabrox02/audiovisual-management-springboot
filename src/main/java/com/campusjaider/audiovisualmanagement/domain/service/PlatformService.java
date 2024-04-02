package com.campusjaider.audiovisualmanagement.domain.service;

import java.util.List;

import com.campusjaider.audiovisualmanagement.persistence.dto.PlatformDTO;
import com.campusjaider.audiovisualmanagement.persistence.entity.PlatformEntity;

public interface PlatformService {
    PlatformDTO savePlatform(String namePlatform);
    List<PlatformEntity> getAllPlatform();
}

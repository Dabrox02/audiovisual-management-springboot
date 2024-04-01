package com.campusjaider.audiovisualmanagement.domain.service;

import com.campusjaider.audiovisualmanagement.persistence.dto.PlatformDTO;

public interface PlatformService {
    PlatformDTO savePlatform(String namePlatform);
}

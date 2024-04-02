package com.campusjaider.audiovisualmanagement.domain.service;

import java.util.List;

import com.campusjaider.audiovisualmanagement.persistence.dto.TypeContentDTO;
import com.campusjaider.audiovisualmanagement.persistence.entity.TypeContentEntity;

public interface TypeContentService {
    TypeContentDTO saveTypeContent(String nameTypeContent);

    List<TypeContentEntity> getAllTypeContent();
}

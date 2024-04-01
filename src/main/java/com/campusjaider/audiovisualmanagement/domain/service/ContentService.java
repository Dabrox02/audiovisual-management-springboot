package com.campusjaider.audiovisualmanagement.domain.service;

import java.util.List;

import com.campusjaider.audiovisualmanagement.persistence.dto.ContentDTO;
import com.campusjaider.audiovisualmanagement.persistence.entity.ContentEntity;

public interface ContentService {
    List<ContentEntity> getAllById(Integer contentId);
    ContentEntity saveContent(ContentDTO contentDTO);
    ContentEntity updateContent(ContentDTO contentDTO);
}

package com.campusjaider.audiovisualmanagement.domain.service;

import com.campusjaider.audiovisualmanagement.persistence.dto.ContentDTO;
import com.campusjaider.audiovisualmanagement.persistence.entity.ContentEntity;

public interface ContentService {
    ContentEntity saveContent(ContentDTO contentDTO);
    ContentEntity updateContent(ContentDTO contentDTO);
}

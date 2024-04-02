package com.campusjaider.audiovisualmanagement.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusjaider.audiovisualmanagement.domain.repository.TypeContentRepository;
import com.campusjaider.audiovisualmanagement.domain.service.TypeContentService;
import com.campusjaider.audiovisualmanagement.persistence.dto.TypeContentDTO;
import com.campusjaider.audiovisualmanagement.persistence.entity.TypeContentEntity;

@Service
public class TypeContentServiceImpl implements TypeContentService {

    @Autowired
    private TypeContentRepository typeContentRepository;

    @Override
    public TypeContentDTO saveTypeContent(String nameTypeContent) {
        TypeContentEntity typeContentEntity = new TypeContentEntity();
        typeContentEntity.setNameTypeContent(nameTypeContent);
        TypeContentEntity typeContentEntityResponse = typeContentRepository.save(typeContentEntity);
        TypeContentDTO typeContentResponse = new TypeContentDTO();
        typeContentResponse.setTypeContentId(typeContentEntityResponse.getTypeContentId());
        typeContentResponse.setNameTypeContent(typeContentEntityResponse.getNameTypeContent());
        return typeContentResponse;
    }

    @Override
    public List<TypeContentEntity> getAllTypeContent() {
        List<TypeContentEntity> typeContentEntities = typeContentRepository.findAll();
        return typeContentEntities;
    }

}

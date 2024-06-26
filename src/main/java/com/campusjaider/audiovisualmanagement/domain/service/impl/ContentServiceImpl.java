package com.campusjaider.audiovisualmanagement.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusjaider.audiovisualmanagement.domain.repository.ContentRepository;
import com.campusjaider.audiovisualmanagement.domain.repository.GenderRepository;
import com.campusjaider.audiovisualmanagement.domain.repository.PlatformRepository;
import com.campusjaider.audiovisualmanagement.domain.repository.TypeContentRepository;
import com.campusjaider.audiovisualmanagement.domain.repository.UserRepository;
import com.campusjaider.audiovisualmanagement.domain.service.ContentService;
import com.campusjaider.audiovisualmanagement.persistence.dto.ContentDTO;
import com.campusjaider.audiovisualmanagement.persistence.entity.ContentEntity;
import com.campusjaider.audiovisualmanagement.persistence.entity.GenderEntity;
import com.campusjaider.audiovisualmanagement.persistence.entity.PlatformEntity;
import com.campusjaider.audiovisualmanagement.persistence.entity.StatusDisplayEnum;
import com.campusjaider.audiovisualmanagement.persistence.entity.TypeContentEntity;
import com.campusjaider.audiovisualmanagement.persistence.entity.UserEntity;

@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private ContentRepository contentRepository;

    @Autowired
    private GenderRepository genderRepository;

    @Autowired
    private TypeContentRepository typeContentRepository;

    @Autowired
    private PlatformRepository platformRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public ContentEntity saveContent(ContentDTO contentDTO) {
        ContentEntity contentEntity = new ContentEntity();
        GenderEntity genderEntity1 = genderRepository.findById(contentDTO.getGenderId1()).orElse(null);
        GenderEntity genderEntity2 = null;
        if (contentDTO.getGenderId2() != null) {
            genderEntity2 = genderRepository.findById(contentDTO.getGenderId2()).orElse(null);
        }
        TypeContentEntity typeContentEntity = typeContentRepository.findById(contentDTO.getTypeContentId())
                .orElse(null);
        PlatformEntity platformEntity = platformRepository.findById(contentDTO.getPlatformId()).orElse(null);
        UserEntity userEntity = userRepository.findById(contentDTO.getUserId()).orElse(null);

        if (genderEntity1 != null && typeContentEntity != null && platformEntity != null && userEntity != null) {
            if (contentDTO.getStatusDisplay().equals(StatusDisplayEnum.ABANDONED)
                    || contentDTO.getStatusDisplay().equals(StatusDisplayEnum.FINISHED)) {
                contentEntity.setComment(contentDTO.getComment());
                contentEntity.setQualification(contentDTO.getQualification());
            } else {
                contentEntity.setComment(null);
                contentEntity.setQualification(null);
            }
            contentEntity.setNameContent(contentDTO.getNameContent());
            contentEntity.setStatusDisplay(contentDTO.getStatusDisplay());
            contentEntity.setUserEntity(userEntity);
            contentEntity.setGenderEntity1(genderEntity1);
            contentEntity.setGenderEntity2(genderEntity2);
            contentEntity.setPlatformEntity(platformEntity);
            contentEntity.setTypeContentEntity(typeContentEntity);
            return contentRepository.save(contentEntity);
        }
        return null;
    }

    @Override
    public ContentEntity updateContent(ContentDTO contentDTO) {
        ContentEntity contentEntity = contentRepository.findById(contentDTO.getContentId()).orElse(null);
        if (contentEntity != null) {
            GenderEntity genderEntity1 = genderRepository.findById(contentDTO.getGenderId1()).orElse(null);
            GenderEntity genderEntity2 = null;
            if (contentDTO.getGenderId2() != null) {
                genderEntity2 = genderRepository.findById(contentDTO.getGenderId2()).orElse(null);
            }
            TypeContentEntity typeContentEntity = typeContentRepository.findById(contentDTO.getTypeContentId())
                    .orElse(null);
            PlatformEntity platformEntity = platformRepository.findById(contentDTO.getPlatformId()).orElse(null);
            UserEntity userEntity = userRepository.findById(contentDTO.getUserId()).orElse(null);

            if (genderEntity1 != null && typeContentEntity != null && platformEntity != null && userEntity != null) {
                if (contentDTO.getStatusDisplay().equals(StatusDisplayEnum.ABANDONED)
                        || contentDTO.getStatusDisplay().equals(StatusDisplayEnum.FINISHED)) {
                    contentEntity.setComment(contentDTO.getComment());
                    contentEntity.setNameContent(contentDTO.getNameContent());
                } else {
                    contentEntity.setComment(null);
                    contentEntity.setNameContent(null);
                }
                contentEntity.setQualification(contentDTO.getQualification());
                contentEntity.setStatusDisplay(contentDTO.getStatusDisplay());
                contentEntity.setUserEntity(userEntity);
                contentEntity.setGenderEntity1(genderEntity1);
                contentEntity.setGenderEntity2(genderEntity2);
                contentEntity.setPlatformEntity(platformEntity);
                contentEntity.setTypeContentEntity(typeContentEntity);
                return contentRepository.save(contentEntity);
            }
        }
        return null;
    }

    @Override
    public List<ContentEntity> getAllById(Integer userId) {
        UserEntity userEntity = userRepository.findById(userId).orElse(null);
        if (userEntity != null) {
            List<ContentEntity> listContentEntities = contentRepository.findByUserEntity(userEntity);
            return listContentEntities;
        }
        return null;
    }

}

package com.campusjaider.audiovisualmanagement.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campusjaider.audiovisualmanagement.domain.service.ContentService;
import com.campusjaider.audiovisualmanagement.persistence.dto.ContentDTO;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/content")
@SecurityRequirement(name = "bearerAuth")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @PostMapping("/add")
    public ResponseEntity<?> saveGender(@RequestBody ContentDTO contentDTO) {
        if (contentDTO.getNameContent() != null && !(contentDTO.getNameContent().isBlank())
                && contentDTO.getStatusDisplay() != null
                && contentDTO.getTypeContentId() != null
                && contentDTO.getPlatformId() != null
                && contentDTO.getGenderId1() != null
                && contentDTO.getUserId() != null) {
            ContentDTO contentResponse = contentService.saveContent(contentDTO);
            return ResponseEntity.ok().body(contentResponse);
        }
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Cannot add new content verify the inputs");
        return ResponseEntity.badRequest().body(response);
    }

}

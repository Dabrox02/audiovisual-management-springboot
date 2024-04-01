package com.campusjaider.audiovisualmanagement.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campusjaider.audiovisualmanagement.domain.service.ContentService;
import com.campusjaider.audiovisualmanagement.domain.service.UserService;
import com.campusjaider.audiovisualmanagement.persistence.dto.ContentDTO;
import com.campusjaider.audiovisualmanagement.persistence.dto.UserDTO;
import com.campusjaider.audiovisualmanagement.persistence.entity.ContentEntity;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/content")
@SecurityRequirement(name = "bearerAuth")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<?> getAllById(@RequestParam String nameUser, @RequestParam String password) {
        UserDTO userDTO = userService.loginUser(nameUser, password);
        if (userDTO == null) {
            throw new UsernameNotFoundException("User or Password Invalid");
        } else {
            List<ContentEntity> listContentEntities = contentService.getAllById(userDTO.getUserId());
            return ResponseEntity.ok().body(listContentEntities);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> saveGender(@RequestBody ContentDTO contentDTO) {
        if (contentDTO.getNameContent() != null && !(contentDTO.getNameContent().isBlank())
                && contentDTO.getStatusDisplay() != null
                && contentDTO.getTypeContentId() != null
                && contentDTO.getPlatformId() != null
                && contentDTO.getGenderId1() != null
                && contentDTO.getUserId() != null) {
            ContentEntity contentResponse = contentService.saveContent(contentDTO);
            if (contentResponse != null) {
                return ResponseEntity.ok().body(contentResponse);
            }
        }
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Cannot add new content verify the inputs");
        return ResponseEntity.badRequest().body(response);
    }

    @PutMapping("/edit")
    public ResponseEntity<?> updaEntity(@RequestBody ContentDTO contentDTO) {
        if (contentDTO.getNameContent() != null && !(contentDTO.getNameContent().isBlank())
                && contentDTO.getStatusDisplay() != null
                && contentDTO.getTypeContentId() != null
                && contentDTO.getPlatformId() != null
                && contentDTO.getGenderId1() != null
                && contentDTO.getUserId() != null) {
            ContentEntity contentResponse = contentService.updateContent(contentDTO);
            if (contentResponse != null) {
                return ResponseEntity.ok().body(contentResponse);
            }
        }
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Cannot edit content verify the inputs");
        return ResponseEntity.badRequest().body(response);
    }

}

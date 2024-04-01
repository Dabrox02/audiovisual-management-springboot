package com.campusjaider.audiovisualmanagement.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campusjaider.audiovisualmanagement.domain.service.TypeContentService;
import com.campusjaider.audiovisualmanagement.persistence.dto.TypeContentDTO;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/typeContent")
@SecurityRequirement(name = "bearerAuth")
public class TypeContentController {

    @Autowired
    private TypeContentService typeContentService;

    @PostMapping("/add")
    public ResponseEntity<?> saveTypeContent(@RequestBody TypeContentDTO typeContentDTO) {
        if (!(typeContentDTO.getNameTypeContent() == null) && !(typeContentDTO.getNameTypeContent().isBlank())) {
            TypeContentDTO typeContentResponse = typeContentService
                    .saveTypeContent(typeContentDTO.getNameTypeContent());
            return ResponseEntity.ok().body(typeContentResponse);
        }
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Cannot create Type of Content");
        return ResponseEntity.badRequest().body(response);
    }

}

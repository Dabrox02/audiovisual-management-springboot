package com.campusjaider.audiovisualmanagement.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campusjaider.audiovisualmanagement.domain.service.PlatformService;
import com.campusjaider.audiovisualmanagement.persistence.dto.PlatformDTO;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/platform")
@SecurityRequirement(name = "bearerAuth")
public class PlatformController {

    @Autowired
    private PlatformService platformService;

    @PostMapping("/add")
    public ResponseEntity<?> saveGender(@RequestBody PlatformDTO platformDTO) {
        if (!(platformDTO.getNamePlatform() == null) && !(platformDTO.getNamePlatform().isBlank())) {
            PlatformDTO platformResponse = platformService.saveGender(platformDTO.getNamePlatform());
            return ResponseEntity.ok().body(platformResponse);
        }
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Cannot create platform");
        return ResponseEntity.badRequest().body(response);
    }

}

package com.campusjaider.audiovisualmanagement.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campusjaider.audiovisualmanagement.domain.service.GenderService;
import com.campusjaider.audiovisualmanagement.persistence.dto.GenderDTO;
import com.campusjaider.audiovisualmanagement.persistence.entity.GenderEntity;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/gender")
@SecurityRequirement(name = "bearerAuth")
public class GenderController {

    @Autowired
    private GenderService genderService;

    @PostMapping("/add")
    public ResponseEntity<?> saveGender(@RequestBody GenderDTO genderDTO) {
        if (!(genderDTO.getNameGender() == null) && !(genderDTO.getNameGender().isBlank())) {
            GenderEntity genderEntity = genderService.saveGender(genderDTO.getNameGender());
            return ResponseEntity.ok().body(genderEntity);
        }
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Cannot create gender");
        return ResponseEntity.badRequest().body(response);
    }

}

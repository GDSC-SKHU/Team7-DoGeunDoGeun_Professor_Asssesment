package com.dugeun.dugeunbackend.api.professor.controller;

import com.dugeun.dugeunbackend.api.common.dto.RspsTemplate;
import com.dugeun.dugeunbackend.api.professor.dto.MainPageProfessorDto;
import com.dugeun.dugeunbackend.api.professor.service.ApiProfessorService;
import com.dugeun.dugeunbackend.domain.professor.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProfessorController {
    private final ApiProfessorService apiProfessorService;
    private final ProfessorService professorService;
    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }

    @GetMapping("/")
    @Transactional
    public ResponseEntity<RspsTemplate<MainPageProfessorDto>> mainPage(){

        RspsTemplate<MainPageProfessorDto> response = apiProfessorService.findAll();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/professor/{id}")
    public ResponseEntity<RspsTemplate> getDetail(@PathVariable Long id){

        // id로 조회, 교수의 능력치를 담은 detailDto 반환

        return null;
    }

















}

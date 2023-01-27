package com.dugeun.dugeunbackend.api.professor.controller;

import com.dugeun.dugeunbackend.api.common.dto.RspsTemplate;
import com.dugeun.dugeunbackend.api.professor.dto.MainPageProfessorDto;
import com.dugeun.dugeunbackend.api.professor.service.ApiProfessorService;
import com.dugeun.dugeunbackend.domain.professor.Professor;
import com.dugeun.dugeunbackend.domain.professor.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

        List<Professor> professors = professorService.findAll();

        List<MainPageProfessorDto> mainPageProfessorDtos = MainPageProfessorDto.ofList(professors);

        RspsTemplate<MainPageProfessorDto> mainPageProfessorDtoRspsTemplate = new RspsTemplate<>(HttpStatus.OK.value(), mainPageProfessorDtos);
//ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(dtos).build();
        return ResponseEntity.ok(mainPageProfessorDtoRspsTemplate);
    }















}

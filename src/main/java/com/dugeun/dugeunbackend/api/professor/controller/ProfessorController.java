package com.dugeun.dugeunbackend.api.professor.controller;

import com.dugeun.dugeunbackend.api.common.dto.RspsTemplate;
import com.dugeun.dugeunbackend.api.common.dto.SingleRspsTemplate;
import com.dugeun.dugeunbackend.api.professor.dto.AddAssessmentDto;
import com.dugeun.dugeunbackend.api.professor.dto.MainPageProfessorDto;
import com.dugeun.dugeunbackend.api.professor.dto.ProfessorDetailDto;
import com.dugeun.dugeunbackend.api.professor.service.ApiProfessorService;
import com.dugeun.dugeunbackend.domain.professor.Major;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class ProfessorController {
    private final ApiProfessorService apiProfessorService;
    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }

    @GetMapping("/")
    @Transactional
    public ResponseEntity<RspsTemplate<MainPageProfessorDto>> mainPage(@RequestParam(required = false) Major major){

        RspsTemplate<MainPageProfessorDto> response = apiProfessorService.findAllByMajor(major);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/professors/{id}")
    public ResponseEntity<SingleRspsTemplate<ProfessorDetailDto>> getDetail(@PathVariable Long id){

        // id로 조회, 교수의 능력치를 담은 detailDto 반환
        SingleRspsTemplate<ProfessorDetailDto> response = apiProfessorService.findDetailById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/professors/{id}/assessment")
    public ResponseEntity addComment(@PathVariable Long id, @Valid @RequestBody AddAssessmentDto addAssessmentDto){
        // 뭘 받아야 하지
        // 댓글내용, 능력치 5가지 , @PathVar professorId
        apiProfessorService.addAssessment(id, addAssessmentDto);
        return ResponseEntity.noContent().build();
    }
















}

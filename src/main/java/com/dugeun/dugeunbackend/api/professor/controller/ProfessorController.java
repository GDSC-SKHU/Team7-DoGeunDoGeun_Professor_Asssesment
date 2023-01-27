package com.dugeun.dugeunbackend.api.professor.controller;

import com.dugeun.dugeunbackend.api.professor.service.ApiProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProfessorController {

    private ApiProfessorService apiProfessorService;

    @GetMapping("/")
    public String hello(){
        return "Hello";
    }
}

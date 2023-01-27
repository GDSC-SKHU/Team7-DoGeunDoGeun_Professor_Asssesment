package com.dugeun.dugeunbackend.api.professor.service;

import com.dugeun.dugeunbackend.domain.professor.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class ApiProfessorService {

    private final ProfessorService professorService;
}

package com.dugeun.dugeunbackend.domain.professor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;


}





















package com.dugeun.dugeunbackend.api.professor.service;

import com.dugeun.dugeunbackend.api.common.dto.RspsTemplate;
import com.dugeun.dugeunbackend.api.professor.dto.MainPageProfessorDto;
import com.dugeun.dugeunbackend.domain.professor.Professor;
import com.dugeun.dugeunbackend.domain.professor.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ApiProfessorService {

    private final ProfessorService professorService;

    @Transactional
    public RspsTemplate<MainPageProfessorDto> findAll() {
        List<Professor> professors = professorService.findAll();

        List<MainPageProfessorDto> mainPageProfessorDtos = MainPageProfessorDto.ofList(professors);

        RspsTemplate<MainPageProfessorDto> response = RspsTemplate.<MainPageProfessorDto>builder()
                .status(HttpStatus.OK.value())
                .data(mainPageProfessorDtos)
                .build();

        return response;
    }
}

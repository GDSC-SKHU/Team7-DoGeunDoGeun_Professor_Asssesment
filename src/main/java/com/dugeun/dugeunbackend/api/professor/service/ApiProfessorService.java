package com.dugeun.dugeunbackend.api.professor.service;

import com.dugeun.dugeunbackend.api.ability.dto.AbilityListDto;
import com.dugeun.dugeunbackend.api.common.dto.RspsTemplate;
import com.dugeun.dugeunbackend.api.common.dto.SingleRspsTemplate;
import com.dugeun.dugeunbackend.api.professor.dto.MainPageProfessorDto;
import com.dugeun.dugeunbackend.api.professor.dto.ProfessorDetailDto;
import com.dugeun.dugeunbackend.domain.professor.Professor;
import com.dugeun.dugeunbackend.domain.professor.ProfessorService;
import com.dugeun.dugeunbackend.domain.professor.ability.Ability;
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

    @Transactional
    public SingleRspsTemplate<ProfessorDetailDto> findById(Long id) {
        // id로 조회, 교수의 능력치를 담은 detailDto 반환
        Professor professor = professorService.findById(id);
        List<Ability> abilities = professor.getAbility();

        AbilityListDto avgAbilityDto = AbilityListDto.getAvg(abilities);
        ProfessorDetailDto professorDetailDto = ProfessorDetailDto.builder()
                .professorName(professor.getProfessorName())
                .major(professor.getMajor())
                .ability(avgAbilityDto)
                .build();

        return SingleRspsTemplate.<ProfessorDetailDto>builder()
                .status(HttpStatus.OK.value())
                .data(professorDetailDto)
                .build();
    }
}





















package com.dugeun.dugeunbackend.api.professor.dto;


import com.dugeun.dugeunbackend.api.ability.dto.AbilityListDto;
import com.dugeun.dugeunbackend.domain.professor.Major;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ProfessorDetailDto {

    private String professorName;
    private Major major;
    private AbilityListDto ability;


    @Builder
    public ProfessorDetailDto(String professorName, Major major, AbilityListDto ability) {
        this.professorName = professorName;
        this.major = major;
        this.ability = ability;
    }
}















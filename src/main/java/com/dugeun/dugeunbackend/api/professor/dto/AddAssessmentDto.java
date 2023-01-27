package com.dugeun.dugeunbackend.api.professor.dto;

import com.dugeun.dugeunbackend.domain.professor.Professor;
import com.dugeun.dugeunbackend.domain.professor.ability.Ability;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AddAssessmentDto {
    private String commentContent;
    private Integer assignment; // 과제량
    private Integer kindness; // 친절함
    private Integer teaching; // 강의력
    private Integer humanity; // 인간미
    private Integer sensibility; // 감수성

    public Ability toEntity(Professor professor){
        return Ability.builder()
                .professor(professor)
                .assignment(assignment)
                .kindness(kindness)
                .teaching(teaching)
                .humanity(humanity)
                .sensibility(sensibility)
                .build();

    }


}




















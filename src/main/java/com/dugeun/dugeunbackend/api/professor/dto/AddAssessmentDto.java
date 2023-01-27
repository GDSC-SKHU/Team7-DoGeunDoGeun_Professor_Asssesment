package com.dugeun.dugeunbackend.api.professor.dto;

import com.dugeun.dugeunbackend.domain.professor.Professor;
import com.dugeun.dugeunbackend.domain.professor.ability.Ability;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@Getter
@NoArgsConstructor
public class AddAssessmentDto {
    private String commentContent;
    @Range(min = 1, max = 100)
    private Integer assignment; // 과제량
    @Range(min = 1, max = 100)
    private Integer kindness; // 친절함
    @Range(min = 1, max = 100)
    private Integer teaching; // 강의력
    @Range(min = 1, max = 100)
    private Integer humanity; // 인간미
    @Range(min = 1, max = 100)
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




















package com.dugeun.dugeunbackend.api.professor.dto;


import com.dugeun.dugeunbackend.api.ability.dto.AbilityListDto;
import com.dugeun.dugeunbackend.api.comment.dto.CommentListDto;
import com.dugeun.dugeunbackend.domain.professor.Major;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class ProfessorDetailDto {

    private String professorName;
    private Major major;
    private AbilityListDto ability;
    private List<CommentListDto> comments;

    @Builder
    public ProfessorDetailDto(String professorName, Major major, AbilityListDto ability, List<CommentListDto> comments) {
        this.professorName = professorName;
        this.major = major;
        this.ability = ability;
        this.comments = comments;
    }
}















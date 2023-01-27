package com.dugeun.dugeunbackend.api.professor.dto;

import com.dugeun.dugeunbackend.domain.professor.Major;
import com.dugeun.dugeunbackend.domain.professor.Professor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
public class MainPageProfessorDto {

    private Long id;
    private String professorName;
    private Major major;

    @Builder
    public MainPageProfessorDto(Long id, String professorName, Major major) {
        this.id = id;
        this.professorName = professorName;
        this.major = major;
    }

    public static MainPageProfessorDto of(Professor professor){
        return MainPageProfessorDto.builder()
                .id(professor.getId())
                .professorName(professor.getProfessorName())
                .major(professor.getMajor())
                .build();
    }

    public static List<MainPageProfessorDto> ofList(List<Professor> professors){
        return professors.stream()
                .map(professor -> MainPageProfessorDto.of(professor))
                .collect(Collectors.toList());
    }
}



















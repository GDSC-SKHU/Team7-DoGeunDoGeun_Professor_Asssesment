package com.dugeun.dugeunbackend.api.ability.dto;

import com.dugeun.dugeunbackend.domain.professor.ability.Ability;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
public class AbilityListDto {

    private Integer assignment; // 과제량
    private Integer kindness; // 친절함
    private Integer teaching; // 강의력
    private Double temperature = 36.5;
    private Integer humanity; // 인간미
    private Integer sensibility; // 감수성

    public static AbilityListDto of(Ability ability) {
        return AbilityListDto.builder()
                .assignment(ability.getAssignment())
                .kindness(ability.getKindness())
                .teaching(ability.getTeaching())
                .humanity(ability.getHumanity())
                .sensibility(ability.getSensibility())
                .build();
    }

    public static AbilityListDto getAvg(List<Ability> abilities){
        // jqpl avg 집계함수
        Double avgAssignment =  abilities.stream()
                .mapToInt(ability -> ability.getAssignment())
                .average()
                .getAsDouble();

        Double avgKindness =  abilities.stream()
                .mapToInt(ability -> ability.getKindness())
                .average()
                .getAsDouble();

        Double avgTeaching =  abilities.stream()
                .mapToInt(ability -> ability.getTeaching())
                .average()
                .getAsDouble();

        Double avgHumanity =  abilities.stream()
                .mapToInt(ability -> ability.getHumanity())
                .average()
                .getAsDouble();

        Double avgSensibility =  abilities.stream()
                .mapToInt(ability -> ability.getSensibility())
                .average()
                .getAsDouble();

        return AbilityListDto.builder()
                .assignment(avgAssignment.intValue())
                .kindness(avgKindness.intValue())
                .teaching(avgTeaching.intValue())
                .humanity(avgHumanity.intValue())
                .sensibility(avgSensibility.intValue())
                .build();
    }
    public static List<AbilityListDto> ofList(List<Ability> abilities){
        return abilities.stream()
                .map(ability -> AbilityListDto.of(ability))
                .collect(Collectors.toList());
    }

    @Builder
    public AbilityListDto(Integer assignment, Integer kindness, Integer teaching, Integer humanity, Integer sensibility) {
        this.assignment = assignment;
        this.kindness = kindness;
        this.teaching = teaching;
        this.humanity = humanity;
        this.sensibility = sensibility;
    }
}

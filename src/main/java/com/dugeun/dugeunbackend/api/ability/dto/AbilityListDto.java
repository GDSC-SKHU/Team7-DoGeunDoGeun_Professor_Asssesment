package com.dugeun.dugeunbackend.api.ability.dto;

import com.dugeun.dugeunbackend.domain.professor.ability.Ability;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Setter
    private Integer rating;

    public Integer getSum(){
        return assignment + kindness + teaching + humanity + sensibility;
    }

//    public static AbilityListDto getAvg(List<Ability> abilities){
//
//        // jqpl avg 집계함수로 변경.
//
//        Double avgAssignment =  abilities.stream()
//                .mapToInt(ability -> ability.getAssignment())
//                .average()
//                .getAsDouble();
//
//        Double avgKindness =  abilities.stream()
//                .mapToInt(ability -> ability.getKindness())
//                .average()
//                .getAsDouble();
//
//        Double avgTeaching =  abilities.stream()
//                .mapToInt(ability -> ability.getTeaching())
//                .average()
//                .getAsDouble();
//
//        Double avgHumanity =  abilities.stream()
//                .mapToInt(ability -> ability.getHumanity())
//                .average()
//                .getAsDouble();
//
//        Double avgSensibility =  abilities.stream()
//                .mapToInt(ability -> ability.getSensibility())
//                .average()
//                .getAsDouble();
//
//        double sum = avgAssignment + avgKindness + avgTeaching + avgHumanity + avgSensibility;
//
//        String stringRating = String.format("%.0f", sum / 5 / 20);
//        Integer rating = Integer.valueOf(stringRating);
//
//        return AbilityListDto.builder()
//                .assignment(avgAssignment.intValue())
//                .kindness(avgKindness.intValue())
//                .teaching(avgTeaching.intValue())
//                .humanity(avgHumanity.intValue())
//                .sensibility(avgSensibility.intValue())
//                .rating(rating)
//                .build();
//    }

    public static AbilityListDto of(Ability ability) {
        return AbilityListDto.builder()
                .assignment(ability.getAssignment())
                .kindness(ability.getKindness())
                .teaching(ability.getTeaching())
                .humanity(ability.getHumanity())
                .sensibility(ability.getSensibility())
                .build();
    }

    public static List<AbilityListDto> ofList(List<Ability> abilities){
        return abilities.stream()
                .map(ability -> AbilityListDto.of(ability))
                .collect(Collectors.toList());
    }

//    @Builder
//    public AbilityListDto(Double assignment, Double kindness, Double teaching, Double humanity, Double sensibility, Double rating) {
//        this.assignment = assignment.intValue();
//        this.kindness = kindness.intValue();
//        this.teaching = teaching.intValue();
//        this.humanity = humanity.intValue();
//        this.sensibility = sensibility.intValue();
//        this.rating = rating;
//    }

    // JPQL DTO로 조회
    public AbilityListDto(Double assignment, Double kindness, Double teaching, Double humanity, Double sensibility) {
        this.assignment = assignment.intValue();
        this.kindness = kindness.intValue();
        this.teaching = teaching.intValue();
        this.humanity = humanity.intValue();
        this.sensibility = sensibility.intValue();
    }

    @Builder
    public AbilityListDto(Integer assignment, Integer kindness, Integer teaching, Integer humanity, Integer sensibility, Integer rating) {
        this.assignment = assignment;
        this.kindness = kindness;
        this.teaching = teaching;
        this.humanity = humanity;
        this.sensibility = sensibility;
        this.rating = rating;
    }
}

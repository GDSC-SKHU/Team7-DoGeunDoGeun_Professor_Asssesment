package com.dugeun.dugeunbackend.domain.professor.ability;

import com.dugeun.dugeunbackend.domain.common.BaseTimeEntity;
import com.dugeun.dugeunbackend.domain.professor.Professor;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Ability extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "professor_id")
    private Professor professor;

    private Integer assignment; // 과제량
    private Integer kindness; // 친절함
    private Integer teaching; // 강의력
    private Double temperature = 36.5;
    private Integer humanity; // 인간미
    private Integer sensibility; // 감수성

    @Builder
    public Ability(Professor professor, Integer assignment, Integer kindness, Integer teaching, Integer humanity, Integer sensibility) {
        this.professor = professor;
        this.assignment = assignment;
        this.kindness = kindness;
        this.teaching = teaching;
        this.humanity = humanity;
        this.sensibility = sensibility;
    }
}




















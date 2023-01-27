package com.dugeun.dugeunbackend.domain.professor.ability;

import com.dugeun.dugeunbackend.domain.professor.Professor;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Ability {

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
    private Integer Humanity; // 인간미
    private Integer sensibility; // 감수성






}




















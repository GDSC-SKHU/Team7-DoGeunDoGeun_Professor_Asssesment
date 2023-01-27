package com.dugeun.dugeunbackend.domain.professor;


import com.dugeun.dugeunbackend.domain.common.BaseTimeEntity;
import com.dugeun.dugeunbackend.domain.professor.ability.Ability;
import com.dugeun.dugeunbackend.domain.professor.comment.Comment;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Professor extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String professorName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Major major;

    @OneToMany(mappedBy = "professor", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Ability> ability;

    @OneToMany(mappedBy = "professor", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Comment> comments;

    @Builder
    public Professor(String professorName, Major major) {
        this.professorName = professorName;
        this.major = major;
    }
}





















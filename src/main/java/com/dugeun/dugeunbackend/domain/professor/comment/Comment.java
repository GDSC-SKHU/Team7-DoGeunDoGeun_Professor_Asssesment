package com.dugeun.dugeunbackend.domain.professor.comment;

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
public class Comment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username = "익명";

    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "professor_id", nullable = false)
    private Professor professor;

    @Builder
    public Comment(String content, Professor professor) {
        this.content = content;
        this.professor = professor;
    }
}






















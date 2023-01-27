package com.dugeun.dugeunbackend.domain.professor;


import com.dugeun.dugeunbackend.domain.common.BaseEntity;
import com.dugeun.dugeunbackend.domain.professor.ability.Ability;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Professor extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String professorName;

    @Enumerated(EnumType.STRING)
    private Major major;

    @OneToMany(mappedBy = "professor", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Ability> ability;
}





















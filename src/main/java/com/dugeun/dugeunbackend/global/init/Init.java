package com.dugeun.dugeunbackend.global.init;

import com.dugeun.dugeunbackend.domain.professor.Major;
import com.dugeun.dugeunbackend.domain.professor.Professor;
import com.dugeun.dugeunbackend.domain.professor.ProfessorService;
import com.dugeun.dugeunbackend.domain.professor.ability.Ability;
import com.dugeun.dugeunbackend.domain.professor.ability.AbilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class Init {

    private final ProfessorService professorService;
    private final AbilityService abilityService;

    @Transactional
    @PostConstruct
    public void init(){
        String[] professorNames = new String[]{"이상윤", "이승진", "김덕봉", "정연식", "김명철", "홍은지", "유상신"
                , "노은하", "김태우", "박정식", "이하규", "정인철", "이종현", "홍성준", "임충규", "김학수"};

        for (String professorName : professorNames) {
            Professor professor = Professor.builder()
                    .professorName(professorName)
                    .major(Major.SOFT)
                    .build();


            professorService.save(professor);
            Ability ability1 = Ability.builder()
                    .professor(professor)
                    .assignment(100)
                    .kindness(100)
                    .humanity(100)
                    .sensibility(100)
                    .teaching(100)
                    .build();
            Ability ability2 = Ability.builder()
                    .professor(professor)
                    .assignment(10)
                    .kindness(10)
                    .humanity(10)
                    .sensibility(10)
                    .teaching(10)
                    .build();

            abilityService.save(ability1);
            abilityService.save(ability2);
        }
    }

}

